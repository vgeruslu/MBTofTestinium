package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.Driver;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.model.Vertex;

public class SharedNodeControl {

    public static void sharedNodeElementControl(Element element){

        boolean sharedNodeElementControl;
        boolean isElementNotNull = Driver.TestMap.containsKey("lastElement");
        if (isElementNotNull && element instanceof Vertex.RuntimeVertex
                && Driver.TestMap.get("lastElement") instanceof Vertex.RuntimeVertex){
            Vertex.RuntimeVertex vertex = (Vertex.RuntimeVertex) element;
            Vertex.RuntimeVertex lastVertex = (Vertex.RuntimeVertex) Driver.TestMap.get("lastElement");
            sharedNodeElementControl = lastVertex.hasSharedState() && vertex.hasSharedState()
                    && lastVertex.getSharedState().equals(vertex.getSharedState());
        }else {
            sharedNodeElementControl = false;
        }
        Driver.TestMap.put("sharedNodeElementControl", sharedNodeElementControl);
        Driver.TestMap.put("lastElement", element);
    }
}
