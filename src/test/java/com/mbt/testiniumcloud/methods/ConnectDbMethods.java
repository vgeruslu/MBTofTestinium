package com.mbt.testiniumcloud.methods;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.utils.DatabaseInfo;
import com.mbt.testiniumcloud.utils.DatabaseInfos;
import org.junit.jupiter.api.Assertions;

import java.sql.*;
import java.util.*;

public class ConnectDbMethods {

    MethodsUtil methodsUtil;

    public ConnectDbMethods(){

        methodsUtil = new MethodsUtil();
    }

    public DatabaseInfos getDatabaseInfo(String tbValue, String username, String password, String jsonLocation){

        String jsonString = methodsUtil.getJsonStringWithBufferedReader(jsonLocation);
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean databaseExist = jsonObject.get(tbValue) != null;

        DatabaseInfos databaseInfos = new DatabaseInfos();
        databaseInfos.setDatabaseExist(databaseExist);
        if (databaseExist) {
            databaseInfos.setEnvironment(tbValue);
            databaseInfos.setUsername(username);
            databaseInfos.setPassword(password);
            LinkedTreeMap<String, DatabaseInfo> map = methodsUtil.readJson(methodsUtil
                            .getClassTypeToken(LinkedTreeMap.class, String.class, DatabaseInfo.class)
                    , jsonObject.get(tbValue).toString(), false);
            databaseInfos.setDatabaseMap(map);
        }
        return databaseInfos;
    }

    public HashMap<String, List<Object>> getResultListWithMap(ResultSet resultSet){

        HashMap<String, List<Object>> dataMap = new HashMap<>();
        List<String> columnNameList = new ArrayList<>();
        try {
            int columnSize = resultSet.getMetaData().getColumnCount();
            //System.out.println(columnSize);
            Object value = null;
            String columnName = "";
            int index = 0;
            for (int i = 1; i < columnSize+1; i++){
                columnNameList.add(resultSet.getMetaData().getColumnName(i));
            }
            while (resultSet.next()) {
                index++;
                for (int i = 1; i < columnSize+1; i++) {
                    value = null;
                    columnName = columnNameList.get(i-1);
                    if (resultSet.getObject(i) != null) {
                        String columnTypeName = resultSet.getMetaData().getColumnTypeName(i);
                        switch (columnTypeName) {
                            case "decimal":
                            case "DECIMAL":
                                value = resultSet.getBigDecimal(i).toPlainString();
                                break;
                            case "VARCHAR2":
                            case "CHAR":
                            case "varchar":
                            case "text":
                                value = resultSet.getString(i);
                                break;
                            case "float8":
                                value = resultSet.getFloat(i);
                                break;
                            case "numeric":
                            case "NUMBER":
                                value = resultSet.getObject(i);
                                break;
                            case "DATE":
                                if (index == 1) {
                                    System.out.println((i - 1) + " date ");
                                }
                                value = resultSet.getString(i);
                                break;
                            case "timestamp":
                                // if(index == 1){
                                //   System.out.print(" timestamp ");
                                // }
                                value = resultSet.getString(i);
                                break;
                            case "bool":
                                value = resultSet.getBoolean(i);
                                break;
                            case "int8":
                            case "int4":
                                value = resultSet.getInt(i);
                                break;
                            case "bigserial":
                                value = resultSet.getLong(i);
                                break;
                            case "BLOB":
                                value = resultSet.getBlob(i);
                                if (value != null) {
                                    value = value.toString();
                                }
                                break;
                            case "jsonb":
                                value = resultSet.getString(i);
                                break;
                            default:
                                if (index == 1) {
                                    System.out.println((i - 1) + " " + columnTypeName);
                                }
                                value = resultSet.getString(i);
                        }
                    }
                    if (dataMap.containsKey(columnName)){
                        dataMap.get(columnName).add(value);
                    }else {
                        List<Object> list = new ArrayList<>();
                        list.add(value);
                        dataMap.put(columnName, list);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Driver.TestMap.put("queryHeader", columnNameList);
        return dataMap;
    }

    public Connection connectDatabase(String database, Properties properties, String databaseName, String ip, String port){

        String databaseClassName = "";
        String jdbcName = "";
        String databaseNameSlash = "";
        switch (database.toLowerCase()){
            case "postgre":
                databaseClassName = "org.postgresql.Driver";
                jdbcName = "jdbc:postgresql://";
                databaseNameSlash = "/";
                break;
            case "oracle":
                databaseClassName = "oracle.jdbc.OracleDriver";
                jdbcName = "jdbc:oracle:thin:@";
                databaseNameSlash = ":";
                break;
            default:
                Assertions.fail(database + " database desteği yok");
        }
        return connectDatabase(databaseClassName, jdbcName, properties, ip, port, databaseNameSlash, databaseName);
    }

    private Connection connectDatabase(String databaseClassName, String jdbcName, Properties properties, String ip, String port, String databaseNameSlash, String databaseName) {

        Connection databaseConnection = null;
        try {
            Class.forName(databaseClassName);
            String db = jdbcName + ip + ":" + port + databaseNameSlash + databaseName;
            databaseConnection = DriverManager.getConnection(db, properties);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            Assertions.fail("connection error");
        }
        System.out.println("Opened database successfully");

        return databaseConnection;
    }

    public void printDataBaseTableNames(Connection c, String database, String oracleTables){

        try {
            DatabaseMetaData dbmd = c.getMetaData();
            String[] types = {"TABLE"};
            ResultSet tables = dbmd.getTables(null, null, "%", types);

            while (tables.next()) {
                if (database.equalsIgnoreCase("oracle")) {
                    if (tables.getString(4).equalsIgnoreCase("TABLE")) {
                        String tableGroup = tables.getString(2);
                        if (oracleTables.equals("") || Arrays.asList(oracleTables.split(",")).contains(tableGroup)) {
                            System.out.println(tableGroup + " " + tables.getString(3));
                        }
                    }
                } else {
                    System.out.println(tables.getString("TABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement createStatement(String connectionMapKey){

        Statement statement = null;
        if (!Driver.DatabaseMap.containsKey("statement" + connectionMapKey)) {
            Connection c = (Connection) Driver.DatabaseMap.get(connectionMapKey);
            try {
                statement = c.createStatement();
                Driver.DatabaseMap.put("statement" + connectionMapKey, statement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            statement = (Statement) Driver.DatabaseMap.get("statement" + connectionMapKey);
        }

        return statement;
    }

    public ResultSet executeQuery(Statement statement, String query) {

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public int executeUpdate(Statement statement, String query) {

        int i = 0;
        try {
            i = statement.executeUpdate(query);
            return i;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long executeLargeUpdate(Statement statement, String query) {

        long i = 0;
        try {
            i = statement.executeLargeUpdate(query);
            statement.close();
            return i;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeDatabase(String mapKey){

        if (Driver.DatabaseMap.containsKey(mapKey)) {
            Object connection = Driver.DatabaseMap.get(mapKey);
            if (connection instanceof Connection) {
                try {
                    if (Driver.DatabaseMap.containsKey("statement"+ mapKey)){
                        Object statement = Driver.DatabaseMap.get("statement"+ mapKey);
                        if (statement instanceof Statement){
                            ((Statement) statement).close();
                            System.out.println("statement" + mapKey + " statement kapatıldı");
                        }
                    }
                    ((Connection) connection).close();
                    System.out.println(mapKey + " connection kapatıldı");
                    Driver.DatabaseMap.remove("statement" + mapKey);
                    Driver.DatabaseMap.remove(mapKey);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
