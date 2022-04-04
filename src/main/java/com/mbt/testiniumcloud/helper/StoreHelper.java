package com.mbt.testiniumcloud.helper;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mbt.testiniumcloud.model.ElementInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.fail;

public enum StoreHelper {
  INSTANCE;
  Logger logger = LoggerFactory.getLogger(getClass());
  private static final String DEFAULT_DIRECTORY_PATH = "elementValues";
  ConcurrentMap<String, Object> elementMapList;
  ConcurrentMap<String, List<ElementInfo>> elementInfoListMap;
  boolean duplicateKeyControlActive = false;
  List<String> fileNameList;

  StoreHelper() {
    initMap(getFileList());
  }

  private void initMap(List<File> fileList) {

    boolean initMapError = false;
    elementMapList = new ConcurrentHashMap<String, Object>();
    elementInfoListMap = new ConcurrentHashMap<String, List<ElementInfo>>();
    Type elementType = new TypeToken<List<ElementInfo>>() {
    }.getType();
    Gson gson = new Gson();
    List<ElementInfo> elementInfoList = null;
    File file = null;
    fileNameList = new ArrayList<>();
    for (int i = 0; i < fileList.size(); i++) {
      file = fileList.get(i);
      fileNameList.add(file.getPath().split(DEFAULT_DIRECTORY_PATH,2)[1]);
      try {
        elementInfoList = gson.fromJson(new FileReader(file), elementType);
        if (duplicateKeyControlActive)
          elementInfoListMap.put(file.getName(), elementInfoList);
        int fileNameListIndex = i;
        elementInfoList.parallelStream()
                .forEach(elementInfo -> setElementListMap(elementInfo, fileNameListIndex));
      } catch (FileNotFoundException e) {
        logger.warn("{} not found", e);
      }catch (JsonIOException | JsonSyntaxException e) {
        initMapError = true;
        logger.error(file.getPath() + " dosyasında syntax hatalı");
      }
    }
    if (initMapError){
      fail("Json dosya okuma hatası Logu kontrol edip hatalı dosya yollarını belirleyebilirsiniz");
    }
  }

  private void setElementListMap(ElementInfo elementInfo, int fileNameListIndex){

    elementInfo.setFileNameIndex(fileNameListIndex);
    elementMapList.put(elementInfo.getKey(), elementInfo);
  }

  private List<File> getFileList() {
    URI uri = null;
    String jsonPath = "";
    try {
      uri = new URI(this.getClass().getClassLoader().getResource(DEFAULT_DIRECTORY_PATH).getFile());
      File file = new File(uri.getPath());
      jsonPath = file.getAbsolutePath();
    } catch (URISyntaxException e) {
      e.printStackTrace();
      throw new NullPointerException("File Directory Is Not Found! file name: " + DEFAULT_DIRECTORY_PATH);
    }
    List<File> list = new ArrayList<>();
    try {
      Files.walk(Paths.get(jsonPath))
              .filter(Files::isRegularFile)
              .forEach(path -> addFileList(path, list));
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("json uzantılı dosya sayısı: " + list.size());
    if (list.size() == 0){
      throw new NullPointerException("Json uzantılı dosya bulunamadı."
              + " Default Directory Path = " + uri.getPath());
    }
    return list;
  }

  private void addFileList(Path path, List<File> list){

    File file = path.toFile();
    if (file.getName().endsWith(".json")){
      list.add(file);
    }
  }

  public void printAllValues() {
    elementMapList.forEach((key, value) -> logger.info("Key = {} value = {}", key, value));
  }

  public ElementInfo findElementInfoByKey(String key) {

    if(!elementMapList.containsKey(key)){
      fail(key + " adına sahip element json dosyalarında mevcut elementler arasında bulunamadı. Lütfen kontrol ediniz...");
    }
    return (ElementInfo) elementMapList.get(key);
  }

  public String getFileName(int i){

    return fileNameList.get(i);
  }

  public void addElementInfoByKey(String key, ElementInfo elementInfo){elementMapList.put(key,elementInfo);}

  public boolean containsKey(String key){return elementMapList.containsKey(key);}

  public void saveValue(String key, String value) {
    elementMapList.put(key, value);
  }

  public String getValue(String key) {
    return elementMapList.get(key).toString();
  }

  public void duplicateKeyControl(boolean allElements) {

    if (!duplicateKeyControlActive){
      System.out.println("duplicateKeyControl aktif değil... duplicateKeyControlActive boolean değeri true olarak değiştirilmeli");
      return;
    }
    List<ElementInfo> elementInfoList = null;
    int elementNumberInFile = 0;
    ConcurrentHashMap<String,List<String>> map = new ConcurrentHashMap<String, List<String>>();
    Set<String> keySet = elementInfoListMap.keySet();
    StringBuilder emptyValues = new StringBuilder();
    for (String fileName : keySet) {

      elementNumberInFile = 0;
      elementInfoList = elementInfoListMap.get(fileName);
      for (ElementInfo elementInfo: elementInfoList){

        elementNumberInFile++;
        String key = elementInfo.getKey();
        String value = elementInfo.getValue();
        String type = elementInfo.getType();
        if (allElements){
          System.out.println("fileName: " + fileName + " elementNumberInFile: " + elementNumberInFile
                  + " elementKey: " + key + " elementValue: " + value
                  + " elementType: " + type);
          }

        if(!key.equals("") && (value.equals("") || type.equals(""))) {
          emptyValues.append("fileName: " + fileName + " elementNumberInFile: " + elementNumberInFile
                  + " elementKey: " + key + " elementValue: " + value
                  + " elementType: " + type + " elementLine: " + (elementNumberInFile * 5 - 3) + "\n");
        }
        if(!map.containsKey(key)){
          List<String> list = new ArrayList<String>();
          list.add(fileName + "!DATA!" + elementNumberInFile);
          map.put(key, list);
        }else {
          List<String> list = map.get(key);
          list.add(fileName + "!DATA!" + elementNumberInFile);
        }
      }
    }
    System.out.println("********************************************************************");
    System.out.println("Empty value or type");
    System.out.println(emptyValues.toString());
    System.out.println("Duplicate key");
     Set<String> elementKeySet = map.keySet();
     for (String elementKey: elementKeySet) {

       List<String> list = map.get(elementKey);
       if(list.size() >= 2) {
         for (String value : list) {

           String[] values = value.split("!DATA!");
           System.out.println("*Duplicate Key* " + " fileName: " + values[0] + " elementKey: " + elementKey
                   + " elementNumberInFile: " + values[1] + " elementLine: " + (Integer.parseInt(values[1]) * 5 - 3));
         }
       }
     }
    System.out.println("********************************************************************");
   }

}