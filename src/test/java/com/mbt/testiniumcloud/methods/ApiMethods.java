package com.mbt.testiniumcloud.methods;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.baseURI;
import static org.junit.jupiter.api.Assertions.fail;

public class ApiMethods {

    private static final Logger logger = LogManager.getLogger(ApiMethods.class);
    MethodsUtil methodsUtil;

    public ApiMethods(){

        methodsUtil = new MethodsUtil();
    }

    public void setApiBaseUri(String apiBaseUri){

        baseURI = apiBaseUri;
    }

    public Response getResponse(ConcurrentHashMap<String,Object> apiTestMap){

      //  .urlEncodingEnabled(true)
        try {
            RequestSpecification requestSpecification = RestAssured.given();
            setRelaxedHTTPSValidation(requestSpecification, apiTestMap);
            basicAuth(requestSpecification, apiTestMap);
            oauth2(requestSpecification, apiTestMap);
            setProxy(requestSpecification, apiTestMap);
            setBaseUri(requestSpecification, apiTestMap);
            setAccept(requestSpecification, apiTestMap);
            setContentType(requestSpecification, apiTestMap);
            setHeaders(requestSpecification, apiTestMap);
            setCookies(requestSpecification, apiTestMap);
            setFormParams(requestSpecification, apiTestMap);
            setParams(requestSpecification, apiTestMap);
            setPathParams(requestSpecification, apiTestMap);
            setQueryParams(requestSpecification, apiTestMap);
            setMultiPartFormData(requestSpecification, apiTestMap);
            setBody(requestSpecification, apiTestMap);
            requestSpecification.when();
            return returnResponse(requestSpecification, apiTestMap);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return null;
    }

    public void setRelaxedHTTPSValidation(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("isRelaxedHTTPSValidation") && Boolean.parseBoolean(apiTestMap.get("isRelaxedHTTPSValidation").toString())){

            requestSpecification.config(RestAssured.config().sslConfig( new SSLConfig().relaxedHTTPSValidation()));
        }
    }

    @SuppressWarnings("unchecked")
    public void basicAuth(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("basicAuth")) {

            ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) apiTestMap.get("basicAuth");

            if (Boolean.parseBoolean(map.get("preemptive").toString())){
                requestSpecification.auth().preemptive().basic(map.get("username").toString(), map.get("password").toString());
            }else {
                requestSpecification.auth().basic(map.get("username").toString(), map.get("password").toString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void oauth2(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("oauth2")) {

            ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) apiTestMap.get("oauth2");

            requestSpecification.auth().oauth2(map.get("token").toString());
        }
    }

    @SuppressWarnings("unchecked")
    public void setProxy(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("proxy")) {

            ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) apiTestMap.get("proxy");
            if(map.containsKey("uri")){
                try {
                    requestSpecification.proxy(new URI(map.get("uri").toString()));
                } catch (URISyntaxException e) {
                    fail(map.get("uri").toString() + " URISyntaxException: " + e.getCause());
                }
            }else if (map.containsKey("username") && map.containsKey("password")) {
                requestSpecification.proxy(ProxySpecification.host(map.get("host").toString())
                        .withPort(Integer.parseInt(map.get("port").toString()))
                        .withAuth(map.get("username").toString(), map.get("password").toString()));
            }else {
                requestSpecification.proxy(ProxySpecification.host(map.get("host").toString())
                        .withPort(Integer.parseInt(map.get("port").toString())));
            }
        }
    }

    public void setBaseUri(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("baseUri")) {

            requestSpecification.baseUri(apiTestMap.get("baseUri").toString());
        }
    }

    public void setAccept(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("accept")) {

            String contentType = apiTestMap.get("accept").toString();
            switch (contentType){
                case "ANY":
                case "BINARY":
                case "HTML":
                case "JSON":
                case "TEXT":
                case "URLENC":
                case "XML":
                case "MULTIPART":
                    requestSpecification.accept(ContentType.valueOf(contentType).withCharset(StandardCharsets.UTF_8));
                    break;
                default:
                    requestSpecification.accept(contentType);
            }
        }
    }

    /**
      ANY(new String[]{"* /*"}),
     TEXT(new String[]{"text/plain"}),
     JSON(new String[]{"application/json", "application/javascript", "text/javascript", "text/json"}),
     XML(new String[]{"application/xml", "text/xml", "application/xhtml+xml"}),
     HTML(new String[]{"text/html"}),
     URLENC(new String[]{"application/x-www-form-urlencoded"}),
     BINARY(new String[]{"application/octet-stream"});
     */

    public void setContentType(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if(apiTestMap.containsKey("contentType")) {

            String contentType = apiTestMap.get("contentType").toString();
            switch (contentType){
                case "ANY":
                case "BINARY":
                case "HTML":
                case "JSON":
                case "TEXT":
                case "URLENC":
                case "XML":
                case "MULTIPART":
                    requestSpecification.contentType(ContentType.valueOf(contentType).withCharset(StandardCharsets.UTF_8));
                    break;
                default:
                    requestSpecification.contentType(contentType);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void setHeaders(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("headers")){

            requestSpecification.headers((ConcurrentHashMap<String, String>) apiTestMap.get("headers"));
        }
    }

    @SuppressWarnings("unchecked")
    public void setCookies(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("cookies")){

            requestSpecification.cookies((ConcurrentHashMap<String, String>) apiTestMap.get("cookies"));
        }
    }

    @SuppressWarnings("unchecked")
    public void setParams(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("params")){

            requestSpecification.params((ConcurrentHashMap<String, Object>) apiTestMap.get("params"));
        }
    }

    @SuppressWarnings("unchecked")
    public void setFormParams(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("formParams")){

            requestSpecification.formParams((ConcurrentHashMap<String, Object>) apiTestMap.get("formParams"));
        }
    }

    @SuppressWarnings("unchecked")
    public void setPathParams(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("pathParams")){

            requestSpecification.pathParams((ConcurrentHashMap<String, Object>) apiTestMap.get("pathParams"));
        }
    }

    @SuppressWarnings("unchecked")
    public void setQueryParams(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("queryParams")){

            requestSpecification.queryParams((ConcurrentHashMap<String, Object>) apiTestMap.get("queryParams"));
        }
    }

    public void setMultiPartFormData(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap){

        if (apiTestMap.containsKey("multipart")){
            HashMap<String, Object> multipartMap = (HashMap<String, Object>) apiTestMap.get("multipart");
            for (String key: multipartMap.keySet()) {
                requestSpecification.multiPart(key, multipartMap.get(key));
            }
        }
    }

    public void setBody(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap) throws IOException {

        if(apiTestMap.containsKey("bodyType")){

            switch (apiTestMap.get("bodyType").toString()){

                case "bodyString":
                    requestSpecification.body(apiTestMap.get("body").toString());
                    break;

                case "bodyFile":
                    File file = new File(apiTestMap.get("body").toString());
                    requestSpecification.body(file);
                    break;

                case "bodyInputStream":
                    FileInputStream inputStream = new FileInputStream(apiTestMap.get("body").toString());
                    requestSpecification.body(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
                    break;

                default:
                    Assert.fail("HATA");
            }
        }
    }

    public Response returnResponse(RequestSpecification requestSpecification, ConcurrentHashMap<String,Object> apiTestMap) throws URISyntaxException, MalformedURLException {

        String requestType = apiTestMap.get("requestType").toString();
        String condition =  apiTestMap.get("requestPathType").toString();
        Response response = null;
        switch (condition){

            case "":
                response = requestSpecification.request(Method.valueOf(requestType.toUpperCase())).thenReturn();
                break;

            case "Uri":
                response = requestSpecification.request(Method.valueOf(requestType.toUpperCase())
                        , new URI(apiTestMap.get("requestPath").toString())).thenReturn();
                break;

            case "Url":
                response = requestSpecification.request(Method.valueOf(requestType.toUpperCase())
                        , new URL(apiTestMap.get("requestPath").toString())).thenReturn();
                break;

            case "String":
                response = requestSpecification.request(Method.valueOf(requestType.toUpperCase())
                        , apiTestMap.get("requestPath").toString()).thenReturn();
                break;

            case "StringAndMap":
                //response = requestSpecification.get().thenReturn();
                break;

            default:
                Assert.fail("HATA");
        }
        return response;
    }

}
