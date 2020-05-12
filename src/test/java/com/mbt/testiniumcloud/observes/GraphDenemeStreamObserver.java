package com.mbt.testiniumcloud.observes;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphwalker.core.event.EventType;
import org.graphwalker.core.event.Observer;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDenemeStreamObserver implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(GraphDenemeStreamObserver.class);

    public static JFrame frame = null;
    private static JTabbedPane tabbedPane = null;
    private static MultiGraph multiGraph = null;
    private static ConcurrentHashMap<String, MultiGraph> graphMap = null;
    private static ConcurrentHashMap<String, Integer> tabNumberMap = null;
    private static Element lastElement = null;
    private static Context lastContext = null;
    private static MultiGraph lastGraph = null;
    private static String startElementName = null;
    private static boolean isStartElement;
    private static int width = 1300;
    private static int height = 600;

    public GraphDenemeStreamObserver(Class startClass, List<Context> contextList) {

        isStartElement = true;
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        frame = new JFrame("GRAPH STREAM VERSION 2.0_1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        JPanel panel = new JPanel(new GridLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };

        List<Context> listContext = getContextList(startClass, contextList);
        tabbedPane = new JTabbedPane();
        graphMap = new ConcurrentHashMap<String, MultiGraph>();
        tabNumberMap = new ConcurrentHashMap<String, Integer>();
        createMultiTab(listContext);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        panel.add(tabbedPane);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        waitBySeconds(1);
        createModels(listContext);
        waitBySeconds(1);
    }

    @Override
    public void update(Machine machine, Element element, EventType eventType) {

        Context context = machine.getCurrentContext();
        String modelName = context.getModel().getName();
        multiGraph = graphMap.get(modelName);
        if (EventType.BEFORE_ELEMENT.equals(eventType)) {

            if (lastElement != null) {
                if (lastElement instanceof Vertex.RuntimeVertex) {
                    if(((Vertex.RuntimeVertex) lastElement).hasSharedState()){
                        Node node = lastGraph.getNode(getId(lastContext, lastElement));
                        node.addAttribute("ui.class", "shared");
                        node.setAttribute("ui.color", 0.50);
                    }else {
                        if (isStartElement && ((Vertex.RuntimeVertex) lastElement).getName().equals(startElementName)) {
                            logger.info(startElementName);
                            Node node = multiGraph.getNode(getId(lastContext, lastElement));
                            node.addAttribute("ui.class", "startModel");
                            node.setAttribute("ui.color",0.15);
                            isStartElement = false;
                        }else
                        multiGraph.getNode(getId(lastContext, lastElement)).addAttribute("ui.class", "success");
                    }
                } else {
                    multiGraph.getEdge(getId(lastContext, lastElement)).addAttribute("ui.class", "success");
                }
            }

            if (element instanceof Vertex.RuntimeVertex) {

                Vertex.RuntimeVertex vertex = (Vertex.RuntimeVertex) element;
                if (vertex.hasSharedState() && lastElement instanceof Vertex.RuntimeVertex &&
                        ((Vertex.RuntimeVertex) lastElement).hasSharedState() && context != lastContext) {
                    waitByMilliSeconds(500);
                    tabbedPane.setSelectedIndex(tabNumberMap.get(modelName));
                    waitBySeconds(1);
                }
                Node node = multiGraph.getNode(getId(context, vertex));
                if (vertex.hasSharedState()) {
                    node.addAttribute("sharedState", vertex.getSharedState());
                }
                node.addAttribute("ui.class", "active");
                node.setAttribute("ui.color",0.20);
                // Check whether we should draw an edge between 2 shared vertices
            } else {
                Edge.RuntimeEdge edge = (Edge.RuntimeEdge) element;
                org.graphstream.graph.Edge graphEdge = multiGraph.getEdge(getId(context, edge));
                graphEdge.addAttribute("ui.class", "active");
                graphEdge.setAttribute("ui.color",0.20);
            }
            lastElement = element;
            lastContext = context;
            lastGraph = multiGraph;
        }
    }

    private String getId(Context context, Element element) {
        return context.getModel().getName() + element.getId();
    }

    protected static void createMultiTab(List<Context> contextList){

        String modelName;
        for (int i=0; i < contextList.size() ; i++) {
            modelName = contextList.get(i).getModel().getName();
            JComponent panel = createPanel();
            tabbedPane.addTab(modelName, null, panel, modelName);
            ViewPanel viewPanel = createGraph(modelName);
            panel.add(viewPanel);
            tabNumberMap.put(modelName,i);
        }
    }

    protected static ViewPanel createGraph(String modelName){

        MultiGraph graph = new MultiGraph(modelName);
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        ViewPanel viewPanel = viewer.addDefaultView(false);
        viewer.disableAutoLayout();
        //graph.setAutoCreate(true);
        //graph.setStrict(false);
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet", stylesheet);
        graphMap.put(modelName, graph);
        return viewPanel;
    }

    protected static JComponent createPanel() {

        JPanel panel = new JPanel(new GridLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };
        panel.setLayout(new GridLayout(1, 1));
        return panel;
    }

    protected static List<Context> getContextList(Class startClass, List<Context> contextList){

        List<Context> list = new ArrayList<Context>();
        String value;
        startElementName = "";
        for (int i=0; i < contextList.size(); i++) {

            if (startElementName.equals("")) {
                for (Annotation annotation : startClass.getAnnotations()) {

                    value = annotation.toString();
                    logger.info("start: " + value);
                    if (value != null && value.contains("start")) {
                        startElementName = value.split("start=")[1].split(" ")[0].replace(",","");
                        break;
                    }
                }
            }

            Class<?> glazz = null;
            try {
                glazz = Class.forName("org.graphwalker." + contextList.get(i).getModel().getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Assert.fail("Model, resources klasörü altında org.graphwalker dizininde bulunamadı.");
            }
            if (glazz.isAssignableFrom(startClass)){
                list.add(contextList.get(i));
            }
        }
        logger.info("" + contextList.size());
        for (int i=0; i < contextList.size(); i++) {
            if (!contextList.get(i).getModel().getName().equals(list.get(0).getModel().getName())) {
                list.add(contextList.get(i));
            }
        }
        return list;
    }

    private static void createModels(List<Context> listContext){

        MultiGraph graph;
        Model.RuntimeModel model;
        List<Element> elementList;
        Element element;
        for (int i=0; i < listContext.size(); i++){

            model = listContext.get(i).getModel();
            graph = graphMap.get(model.getName());
            elementList = model.getElements();
            for (int j=0; j <elementList.size(); j++){
                element = elementList.get(j);
                if (element instanceof Vertex.RuntimeVertex){
                    createVertex(model, graph, (Vertex.RuntimeVertex) element);
                }else {
                    createEdge(model, graph, (Edge.RuntimeEdge) element);
                }
            }
        }
    }

    private static String createVertex(Model.RuntimeModel model, MultiGraph graph, Vertex.RuntimeVertex runtimeVertex){

        String id = model.getName() + runtimeVertex.getId();
        Node node = graph.getNode(id);
        Map<String,Object> map;
        if(node==null){
            node = graph.addNode(id);
            node.addAttribute("ui.label",runtimeVertex.getName());
            map = runtimeVertex.getProperties();
            node.setAttribute("x",(1.0d) * Double.parseDouble(map.get("x").toString()));
            node.setAttribute("y",(-1.0d) * Double.parseDouble(map.get("y").toString()));
        }
        return id;
    }

    private static void createEdge(Model.RuntimeModel model, MultiGraph graph, Edge.RuntimeEdge runtimeEdge){

        String id = model.getName() + runtimeEdge.getId();
        org.graphstream.graph.Edge edge = graph.getEdge(id);
        if(edge==null){
            edge = graph.addEdge(id, createVertex(model, graph, runtimeEdge.getSourceVertex())
                    , createVertex(model, graph, runtimeEdge.getTargetVertex()), true);
            edge.addAttribute("ui.label", runtimeEdge.getName());
        }
    }

    private static String stylesheet = "" +
            "node {" +
            " shape: rounded-box;" +
            " fill-color: grey;" +
            " fill-mode: dyn-plain;" +
            " size-mode: fit;" +
            //"padding: 4px, 4px;" +
            " text-alignment: center;" +
            " text-size: 10px;" +
            " text-style: bold-italic;" +
            " text-color: blue;" +
            //" text-background-mode: plain;" +
            " stroke-mode: plain;" +
            " stroke-color: black;" +
            " stroke-width: 1px;" +
            "}" +
            "node.active {" +
            " fill-color: magenta, black;" +
            " size:40px;" +
            "}" +
            "node.success {" +
            " fill-color: green;" +
            " size: 40px;" +
            "}" +
            "node.error {" +
            " fill-color: red;" +
            " size: 40px;" +
            "}" +
            "node.shared {" +
            " fill-color: red, yellow;" +
            " size: 40px;" +
            "}" +
            "node.startModel {" +
            " fill-color: yellow, white;" +
            " size: 40px;" +
            "}" +
            "edge {" +
            " shape: cubic-curve;" +
            " fill-color: grey;" + //magenta  aquamarine cyan
            " size-mode: dyn-size;" +
            " size: 2px;" +
            " arrow-shape: arrow;" +
            " arrow-size: 10px, 4px;" +
            //" text-mode: hidden;" +
            " text-visibility-mode: hidden;" +
            " text-alignment: center;" + //under center
            " text-background-mode: rounded-box;" + //rounded-box  plain
            //" text-padding: 15;" +
            " text-size: 9px;" +
            " text-style: bold-italic;" +
            " text-color: blue;" +
            "}" +
            "edge.active {" +
            " fill-color: magenta, black;" +
            " text-visibility-mode: normal;" +
            //" text-background-mode: plain;" +
            " size: 2px;" +
            "}" +
            "edge.success {" +
            " fill-color: green;" +
            " size: 2px;" +
            "}" +
            "edge.error {" +
            " fill-color: red;" +
            " size: 2px;" +
            "}";

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitBySeconds(long seconds){

        logger.info(seconds + " saniye bekleniyor...");
        waitByMilliSeconds(seconds*1000);
    }

    /**for (Annotation annotation : TestiniumModel.class.getAnnotations()) {

     System.out.println(annotation.toString());

     }
     Class<?> glazz = null;
     try {
     glazz = Class.forName("org.graphwalker.TestiniumModelV13");
     } catch (ClassNotFoundException e) {
     e.printStackTrace();
     }
     String packageName = getClass().getPackage().getName();
     File[] files = new File(System.getProperty("user.dir") + "/src/test/java/" + packageName.replace(".tests",".modelImplementation").replace(".","/")).listFiles(file -> !file.isDirectory() && file.getName().endsWith(".java"));
     for(File file: files) {
     System.out.println(file.getName());
     }

     System.out.println(glazz.isAssignableFrom(TestiniumModel.class));
     System.out.println(glazz.isAssignableFrom(TestiniumDashboard.class));
     System.out.println(glazz.isAssignableFrom(TestiniumAllScenarios.class));

     for (int i=0; i < contextList.size(); i++){

     System.out.println(contextList.get(i).getModel().getName());
     for (Element element: contextList.get(i).getModel().getElements()){
     if(element instanceof Vertex.RuntimeVertex){
     System.out.println(((Vertex.RuntimeVertex) element).getName());
     System.out.println(((Vertex.RuntimeVertex) element).getId());
     System.out.println(((Vertex.RuntimeVertex) element).getProperties());
     }else {
     System.out.println(((org.graphwalker.core.model.Edge.RuntimeEdge) element).getName());
     System.out.println(((org.graphwalker.core.model.Edge.RuntimeEdge) element).getId());
     System.out.println(((Edge.RuntimeEdge) element).getProperties());
     }
     }
     System.out.println("\r\n");
     }*/

    // Point3 gu = view.getCamera().transformPxToGu(e.getX(), e.getY());
    //        Node node = graph.addNode(e.getWhen());
    //        node.setAttribute("xyz", gu.x, gu.y, 0);
    /**
     Most often the graph is represented in two dimensions, although a 3D viewer is in the works. You set the individual coordinates of a node using the x, y and z attributes, this way:

     node.setAttribute("x", 1);
     node.setAttribute("y", 3);
     You can also use the xy or xyz attributes that take two or three values respectively:

     node.setAttribute("xyz", 1, 3, 0);

     text-alignment: The alignment of the text with respect to the element center (node, sprite or edge).

     center (default): The text will be centered on the element center.
     left: The text will be aligned on the left of the element center.
     right: The text will be aligned on the right or the element center.
     at-left: The text will be aside the element at left.
     at-right: The text will be aside the element at right.
     under: The text will be under the element.
     above: The text will be above the element.
     along: This is useful only for edges, the text will centered on the edge and will have the same orientation as the edge.

     A.addAttribute("layout.frozen");
     g.addEdge("4_4", "4", "4", true).addAttribute("layout.weight", 7.091967);
     g.getNode("1").addAttribute("xy", 0.0, 1.0);
     g.getNode("1").addAttribute("layout.frozen");
     g.getNode("2").addAttribute("xy", 10.0, -1.0);
     g.getNode("0").addAttribute("layout.frozen");
     g.getNode("0").addAttribute("xy", 0.0, -1.0);


     */

}
