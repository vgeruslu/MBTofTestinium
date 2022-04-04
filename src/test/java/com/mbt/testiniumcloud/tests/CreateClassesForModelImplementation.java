package com.mbt.testiniumcloud.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbt.testiniumcloud.driver.FindOS;
import com.mbt.testiniumcloud.modelUtils.*;
import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CreateClassesForModelImplementation {

    public static String slash = "";
    public static int modelCount = 0;
    public static ConcurrentHashMap<String, ModelMapInfo> modelMap = new ConcurrentHashMap<String, ModelMapInfo>();

    public static void main(String[] args) throws IOException {

        String osName = FindOS.getOperationSystemName();
        String modelClassFolderName = "modelImplementation";
        System.out.println(osName);
        slash = osName.equals("WINDOWS") ? "\\" : "/";
        String packageName = CreateClassesForModelImplementation.class.getPackage().getName()
                .replace("test","");

        String modelImpClass = "package " + packageName + modelClassFolderName + ";\n" +
                "\n" +
                "import " + packageName + "driver.Driver;\n" +
                "import " + packageName + "methods.Methods;\n" +
                "import " + packageName + "utils.CoverageValue;\n" +
                "import " + packageName + "utils.ExcelMapData;\n" +
                "import org.apache.logging.log4j.Level;\n" +
                "import org.graphwalker.core.machine.ExecutionContext;\n" +
                "import org.graphwalker.java.annotation.AfterElement;\n" +
                "import org.graphwalker.java.annotation.BeforeElement;\n" +
                "import org.graphwalker.java.annotation.GraphWalker;\n" +
                "import org.apache.logging.log4j.Logger;\n" +
                "import org.apache.logging.log4j.LogManager;\n" +
                "import static org.apache.logging.log4j.LogManager.*;\n" +
                "import org.apache.logging.log4j.core.config.Configurator;\n" +
                "\n" +
                "@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)\n" +
                "public class %s extends ExecutionContext implements org.graphwalker.%s {\n" +
                "\n" +
                "    private static final Logger logger = LogManager.getLogger(%s.class);\n" +
                "    Methods methods;\n" +
                "    ExcelMapData excelMapData;\n" +
                "\n" +
                "    public %s(){\n" +
                "\n" +
                "        methods = new Methods();\n" +
                "        excelMapData = new ExcelMapData();\n" +
                "        Configurator.setLevel(getLogger(%s.class), Level.toLevel(Driver.modelImplLogLevel));\n" +
                "    }\n" +
                "\n" +
                "    @BeforeElement\n" +
                "    public void beforeElement() {\n" +
                "\n" +
                "        logger.info(\"══════════════════════════════════════════════════════════════════════════════════════════════════════\");\n" +
                "        excelMapData.setBeforeElementData(getModel(), getCurrentElement());\n" +
                "    }\n" +
                "\n" +
                "    @AfterElement\n" +
                "    public void afterElement() {\n" +
                "\n" +
                "        logger.info(\"══════════════════════════════════════════════════════════════════════════════════════════════════════\");\n" +
                "    }";

        String modelMethod = "\n\n" +
                "    @Override\n" +
                "    public void %s() {\n" +
                "\n" +
                "    }";

        String closeClass = "    \n\n" +
                "}";

        String location = System.getProperty("user.dir")
                + slash + "src" + slash + "test" + slash + "java"
                + slash + packageName.replace(".", slash);
        System.out.println(location);

        File file1 = new File(location + modelClassFolderName.replace(".", slash));

        if(!file1.exists()){
            System.out.println(file1.mkdirs());
        }
        File[] files = getFileList();
        for (File file: files) {
            modelMap = new ConcurrentHashMap<String, ModelMapInfo>();
            modelCount = 0;
            System.out.println("modelsJsonFileName: " + file.getName());
            List<String> modelClassNameList = new ArrayList<String>();
            try {
                readModelJsonFile(file);
                for (int i = 1; i < (modelCount+1); i++) {

                    ModelMapInfo modelMapInfo = modelMap.get("model" + i);
                    String modelName = modelMapInfo.getModelName();
                    StringBuilder methods = new StringBuilder();
                    for (String elementName: modelMapInfo.getElementSet()) {

                        methods.append(String.format(modelMethod,
                                elementName.startsWith("vertices_") ? elementName
                                        .replaceFirst("vertices_","") : elementName
                                        .replaceFirst("edges_","")));
                    }
                    String modelClassName = modelName.replace("_","");

                    String classInfo = String.format(modelImpClass, modelClassName, modelName, modelClassName, modelClassName, modelClassName)
                            + methods + closeClass;
                    String fileLocation = location + modelClassFolderName.replace(".", slash) + slash + modelClassName + ".java";

                    modelClassNameList.add(modelClassName);

                    File myFile = new File(fileLocation);
                    if (!myFile.exists()) {

                        myFile.createNewFile();
                        BufferedWriter bufferedWriter = createWriter(fileLocation,true);
                        bufferedWriter.write(classInfo);
                        bufferedWriter.close();
                    }

                }
            }catch (Exception e){

                e.printStackTrace();
            }
            String modelClasses = "";
            for (String className: modelClassNameList){
                // modelClasses = modelClasses + (modelClasses.equals("") ? "" : ", ") + className + ".class";
                modelClasses = className + ".class" + (modelClasses.equals("") ? "" : ", ") + modelClasses;
            }
            System.out.println(modelClasses);
        }

        /**
         BufferedWriter bufferedWriter = createWriter(location,true);
         bufferedWriter.write("");
         bufferedWriter.close();
         */

    }

    public static BufferedWriter createWriter(String dir, boolean appendCondition) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriterWithEncoding(dir, StandardCharsets.UTF_8, appendCondition));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

    public static void readModelJsonFile(File file) throws FileNotFoundException {


        Type elementType = new TypeToken<ModelsGsonType>(){}.getType();
        Gson gson = new Gson();
        ModelsGsonType modelsGsonType = gson.fromJson(new FileReader(file), elementType);

        List<ModelGsonType> list = modelsGsonType.getModel();
        for (ModelGsonType modelGsonType: list){
            modelCount++;
            ModelMapInfo modelMapInfo = new ModelMapInfo();
            Set<String> elementSet = new HashSet<String>();

            List<EdgeGsonType> edgeList = modelGsonType.getEdges();
            for (EdgeGsonType edgeGsonType : edgeList){

                String edgeName = edgeGsonType.getName();
                if(!edgeName.startsWith("e_")){
                    System.out.println("e_ ile baslamayan edge: " + edgeName);
                }
                if(elementSet.contains("edges_" + edgeName)) {
                    System.out.println("duplicate edge: " + edgeName);
                }
                elementSet.add("edges_" + edgeName);
            }

            List<VertexGsonType> vertexList = modelGsonType.getVertices();
            for (VertexGsonType vertexGsonType: vertexList){

                String vertexName = vertexGsonType.getName();
                if(!vertexName.startsWith("v_")){
                    System.out.println("v_ ile baslamayan vertex: " + vertexName);
                }
                if(elementSet.contains("vertices_" + vertexName)) {
                    System.out.println("duplicate vertex:" + vertexName);
                }
                elementSet.add("vertices_" + vertexName);
            }

            System.out.println(modelGsonType.getName());
            System.out.println(edgeList.size());
            System.out.println(vertexList.size());
            System.out.println(elementSet.size());

            modelMapInfo.setModelName(modelGsonType.getName());
            modelMapInfo.setJsonFileLocation(file.getName());
            modelMapInfo.setElementSet(elementSet);
            modelMap.put("model" + modelCount, modelMapInfo);
        }
    }

    public static File[] getFileList() {
        String location = "";
        /**
         URI uri = null;
         try {
         uri = new URI(CreateClassesForModelImplementation.class
         .getClassLoader().getResource("org" + slash + "graphwalker").getFile());
         } catch (URISyntaxException e) {

         e.printStackTrace();
         throw new NullPointerException();
         }
         location = uri.getPath();
         */

        location = System.getProperty("user.dir")
                + slash + "src" + slash + "test" + slash + "resources"
                + slash + "org" + slash + "graphwalker";
        File[] fileList = new File(location)
                .listFiles(pathname -> !pathname.isDirectory() && pathname.getName().endsWith(".json"));
        try{
            System.out.println("Json uzantılı dosya sayısı: " + fileList.length);
        }catch (Exception e){

            throw new NullPointerException(location + " dizininde json uzantılı dosya bulunamadı");
        }
        return fileList;
    }

}
