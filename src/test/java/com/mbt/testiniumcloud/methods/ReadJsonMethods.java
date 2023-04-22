package com.mbt.testiniumcloud.methods;

import com.google.common.base.Splitter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.utils.JsonPathValue;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class ReadJsonMethods {

    private static final Logger logger = LogManager.getLogger(ReadJsonMethods.class);
    MethodsUtil methodsUtil;
    private boolean keyTrim = false;
    private boolean valueTrim = false;

    public ReadJsonMethods(){

        methodsUtil = new MethodsUtil();
    }

    public void setKeyTrim(boolean keyTrim){
        this.keyTrim = keyTrim;
    }

    public void setValueTrim(boolean valueTrim){
        this.valueTrim = valueTrim;
    }

    public void readJsonPath(JsonElement element, List<String> jsonPath, String type, String mapKey){

        String splitValue = "";
        for (String value : jsonPath) {
            splitValue = !splitValue.equals("") ? splitValue + "|?" + value : value;
            if (element.isJsonArray()) {
                element = element.getAsJsonArray().get(Integer.parseInt(value));
            } else if (element.isJsonObject()) {
                element = element.getAsJsonObject().get(value);
            } else {
                Driver.TestMap.put(mapKey, null);
              //  logger.info(splitValue + " elementi bulunamadı");
              //  fail("Hatalı json path: " + jsonPath.toString());
                return;
            }
            if (element == null) {
                Driver.TestMap.put(mapKey, null);
             //   logger.info(splitValue + " elementi bulunamadı");
                return;
            }
        }
        if(element.isJsonNull()){
            Driver.TestMap.put(mapKey, null);
           // logger.info(splitValue + " elementi null değere sahip");
            return;
        }
        getValueFromJsonAndSaveMap(element, type, mapKey);
    }

    public List<String> getJsonPathAsList(String jsonPath, String splitRegex){

        if (jsonPath.equals(""))
            return new ArrayList<>();
        return Splitter.on(splitRegex).splitToList(jsonPath);
    }

    public int getJsonListSize(JsonArray jsonArray){

        return jsonArray.size();
    }

    public void setJsonPathMultipleValue(String jsonPath, String value, String type, String id, String mapKey, String valueControlType, boolean OrActive){

        jsonPath = methodsUtil.setValueWithMapKey(jsonPath);
        Object objectValue;
        if (value.endsWith("KeyValue")){
            objectValue = Driver.TestMap.get(value);
        }else {
            objectValue = value;
        }
        JsonPathValue jsonPathValue = new JsonPathValue();
        jsonPathValue.setKey(jsonPath);
        jsonPathValue.setValue(objectValue);
        jsonPathValue.setType(type);
        jsonPathValue.setId(id);
        jsonPathValue.setValueControlType(methodsUtil.getTextByMap(valueControlType));
        jsonPathValue.setOrActive(OrActive);
        if (Driver.TestMap.containsKey(mapKey)){
            ((List<JsonPathValue>) Driver.TestMap.get(mapKey)).add(jsonPathValue);
        }else {
            List<JsonPathValue> list = new ArrayList<>();
            list.add(jsonPathValue);
            Driver.TestMap.put(mapKey, list);
        }
    }

    public void getMultipleValue(String jsonPathKey, JsonElement jsonElement, String splitRegex, String mapKeySuffix){

        List<JsonPathValue> jsonPathValues = (List<JsonPathValue>) Driver.TestMap.get(jsonPathKey);
        for (JsonPathValue jsonPathValue: jsonPathValues){
            String mapKey = jsonPathValue.getId() + mapKeySuffix;
            List<String> values = getJsonPathAsList(jsonPathValue.getKey(), splitRegex);
            readJsonPath(jsonElement, values, jsonPathValue.getType(), mapKey);
            logger.info(mapKey + " : " + Driver.TestMap.get(mapKey).toString());
        }
    }

    public void getMultipleListValue(String controlJsonKey, String jsonKey, JsonElement jsonElement, String splitRegex, String mapKeySuffix){

        List<String> listJsonElementNumber = new ArrayList<>();
        boolean condition = true;
        if (!jsonElement.isJsonArray())
            fail("Hata Json array olmalı");
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        List<JsonPathValue> jsonPathValues = (List<JsonPathValue>) Driver.TestMap.get(jsonKey);
        jsonPathValues.forEach(jsonPathValue -> Driver.TestMap.remove(jsonPathValue.getId() + "List" + mapKeySuffix));
        Driver.TestMap.remove("numberListJsonArray" + mapKeySuffix);
        boolean isControlJsonKey = !controlJsonKey.equals("");
        List<JsonPathValue> jsonPathControlValues = null;
        if (isControlJsonKey){
            if(!Driver.TestMap.containsKey(controlJsonKey)){
                isControlJsonKey = false;
            }else {
                jsonPathControlValues = (List<JsonPathValue>) Driver.TestMap.get(controlJsonKey);
            }
        }
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement jsonElementInArray = jsonArray.get(i);
            condition = true;
            if (isControlJsonKey) {
                for (JsonPathValue jsonPathValue : jsonPathControlValues) {
                    String mapKey = jsonPathValue.getId() + mapKeySuffix;
                    List<String> values = getJsonPathAsList(jsonPathValue.getKey(), splitRegex);
                    readJsonPath(jsonElementInArray, values, jsonPathValue.getType(), mapKey);
                    String value = Driver.TestMap.get(mapKey).toString();
                    if (!jsonPathValue.getOrActive()){
                    condition = methodsUtil.conditionValueControl(keyTrim ? jsonPathValue.getValue().toString().trim()
                            : jsonPathValue.getValue().toString(), keyTrim ? value.trim() : value
                            , jsonPathValue.getValueControlType());
                    }else {
                        List<String> controlValues = (List<String>) jsonPathValue.getValue();
                        for (String controlValue: controlValues){
                            if (jsonPathValue.getValueControlType().startsWith("not")) {
                                condition = methodsUtil.conditionValueControl(keyTrim ? controlValue.trim() : controlValue
                                        , keyTrim ? value.trim() : value, jsonPathValue.getValueControlType());
                               if (!condition){
                                   break;
                               }
                            }else {
                                condition = methodsUtil.conditionValueControl(keyTrim ?  controlValue.trim() : controlValue
                                        , keyTrim ? value.trim() : value, jsonPathValue.getValueControlType());
                                if (condition) {
                                    break;
                                }
                            }
                        }
                    }
                    if (!condition){
                        break;
                    }
                }
            }
            if (condition) {
                listJsonElementNumber.add(String.valueOf(i));
                for (JsonPathValue jsonPathValue : jsonPathValues) {
                    String jsonPath = jsonPathValue.getKey();
                    if(jsonPath.contains("{?}")){
                        getMultipleJsonArrayLoop(jsonElementInArray, jsonPathValue, mapKeySuffix, splitRegex);
                    }else{
                        saveMultipleListValue(jsonElementInArray, jsonPathValue, mapKeySuffix, splitRegex);
                    }
                }
            }
        }
        Driver.TestMap.put("numberListJsonArray" + mapKeySuffix, listJsonElementNumber);
    }

    private void saveMultipleListValue(JsonElement jsonElement, JsonPathValue jsonPathValue, String mapKeySuffix, String splitRegex){

        String mapKey = jsonPathValue.getId() + mapKeySuffix;
        List<String> values = getJsonPathAsList(jsonPathValue.getKey(), splitRegex);
        readJsonPath(jsonElement, values, jsonPathValue.getType(), mapKey);
        String name = jsonPathValue.getId() + "List" + mapKeySuffix;
        if (jsonPathValue.getType().equals("String")) {
            String jsonValue = Driver.TestMap.get(mapKey).toString();
            if (Driver.TestMap.containsKey(name)) {
                ((List<String>) Driver.TestMap.get(name)).add(jsonValue);
            } else {
                List<String> list = new ArrayList<>();
                list.add(jsonValue);
                Driver.TestMap.put(name, list);
            }
        }else{
            Object jsonValue = Driver.TestMap.get(mapKey);
            if (Driver.TestMap.containsKey(name)) {
                ((List<Object>) Driver.TestMap.get(name)).add(jsonValue);
            } else {
                List<Object> list = new ArrayList<>();
                list.add(jsonValue);
                Driver.TestMap.put(name, list);
            }
        }
    }

    private void getMultipleJsonArrayLoop(JsonElement jsonElement, JsonPathValue jsonPathValue, String mapKeySuffix, String splitRegex){

        String mapKey = jsonPathValue.getId() + mapKeySuffix;
        String name = jsonPathValue.getId() + "List" + mapKeySuffix;
        List<String> jsonPathAsList = getJsonPathAsList(jsonPathValue.getKey(),splitRegex + "{?}" + splitRegex);
        boolean finishHim = false;
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        List<JsonElement> jsonElements = new ArrayList<JsonElement>();
        jsonElements.add(jsonElement);
        map.put("work", jsonElements);
        List<String> work3 = new ArrayList<>();
        List<String> work2 = new ArrayList<>();
        for (int i = 0; i < jsonPathAsList.size(); i++){
            String a = jsonPathAsList.get(i);
            JsonArray jsonArray = null;
            List<JsonElement> work = (List<JsonElement>) map.get("work");
            for (int k = 0; k < work.size(); k++) {
                JsonElement jsonElement1 = work.get(k);
                if(i == jsonPathAsList.size()-1){
                    readJsonPath(jsonElement1, getJsonPathAsList(a, splitRegex), jsonPathValue.getType(), mapKey);
                  //  String u = work3.get(k) + splitRegex + a;
                 //   System.out.println(u);
                    if (jsonPathValue.getType().equals("String")) {
                        String jsonValue = Driver.TestMap.get(mapKey).toString();
                        if (Driver.TestMap.containsKey(name)) {
                            ((List<String>) Driver.TestMap.get(name)).add(jsonValue);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(jsonValue);
                            Driver.TestMap.put(name, list);
                        }
                    }else {
                        Object jsonValue = Driver.TestMap.get(mapKey);
                        if (Driver.TestMap.containsKey(name)) {
                            ((List<Object>) Driver.TestMap.get(name)).add(jsonValue);
                        } else {
                            List<Object> list = new ArrayList<>();
                            list.add(jsonValue);
                            Driver.TestMap.put(name, list);
                        }
                    }
                    finishHim = true;
                }else {
                    readJsonPath(jsonElement1, getJsonPathAsList(a, splitRegex),"JsonArray", mapKey);
                    if (Driver.TestMap.get(mapKey) == null) {
                        continue;
                    }
                    JsonElement jsonElement2 = (JsonElement) Driver.TestMap.get(mapKey);
                    if (jsonElement2.isJsonArray()) {
                        jsonArray = jsonElement2.getAsJsonArray();
                        for (int j = 0; j < jsonArray.size(); j++) {
                            String u = work3.size() != 0 ? work3.get(k) + splitRegex + a + splitRegex + j : a + splitRegex + j;
                            map.put(u, jsonArray.get(j));
                            work2.add(u);
                        }
                    }
                }
            }
            work3.clear();
            work.clear();
            if (!finishHim) {
                for (String workString: work2) {
                    work.add((JsonElement)map.get(workString));
                }
                work3.addAll(work2);
                work2.clear();
            }
        }
        work3.clear();
        work2.clear();
    }

    public JsonElement getJsonElementByMap(String jsonMapKey){

        String jsonString;
        JsonElement element = null;
        if(Driver.apiMap.containsKey(jsonMapKey)){
            jsonString = ((Response)Driver.apiMap.get(jsonMapKey).get("response")).asString();
            element = JsonParser.parseString(jsonString);
        }else if(jsonMapKey.endsWith("KeyValue")){
            Object value = Driver.TestMap.get(jsonMapKey);
            if(value instanceof JsonElement){
                element = (JsonElement) value;
            }else if(value instanceof String){
                element = JsonParser.parseString(value.toString());
            }else
                fail("Hatalı json data");
        }else {
            element = JsonParser.parseString(jsonMapKey);
        }
        return element;
    }

    private void getValueFromJsonAndSaveMap(JsonElement jsonElement, String type, String mapKey){

        switch (type){
            case "JsonObject":
                Driver.TestMap.put(mapKey, jsonElement.getAsJsonObject());
                break;
            case "JsonArray":
                Driver.TestMap.put(mapKey, jsonElement.getAsJsonArray());
                break;
            case "JsonPrimitive":
                Driver.TestMap.put(mapKey, jsonElement.getAsJsonPrimitive());
                break;
            case "JsonNull":
                Driver.TestMap.put(mapKey, null);
                break;
            case "String":
                Driver.TestMap.put(mapKey, valueTrim ? jsonElement.getAsString().trim() : jsonElement.getAsString());
                break;
            case "ToString":
                Driver.TestMap.put(mapKey, jsonElement.toString());
                break;
            case "Integer":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsInt());
                break;
            case "Boolean":
                assertTrue(jsonElement.toString().equals("true") || jsonElement.toString().equals("false")
                        ," boolean bir değer değil");
                Driver.TestMap.put(mapKey, jsonElement.getAsBoolean());
                break;
            case "Long":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsLong());
                break;
            case "BigInteger":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsBigInteger());
                break;
            case "BigDecimal":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?.*[0-9]+[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                if(!Pattern.matches("[0-9]+[\\.]?[0-9]*", jsonElement.toString()))
                    logger.warn(jsonElement.toString() + " degeri string bir değer");
                Driver.TestMap.put(mapKey, jsonElement.getAsBigDecimal());
                break;
            case "Double":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsDouble());
                break;
            case "Float":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsFloat());
                break;
            case "Short":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsShort());
                break;
            case "Number":
                assertTrue(Pattern.matches("[\"]?[0-9]+[\\.]?[0-9]*[\"]?", jsonElement.toString())
                        ,jsonElement.toString() + " sayı dışında karakter içeriyor");
                Driver.TestMap.put(mapKey, jsonElement.getAsNumber());
                break;
            default:
                fail(type + " data Tipi hatalı");
        }
    }

}
