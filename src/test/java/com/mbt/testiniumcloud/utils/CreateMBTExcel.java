package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.DriverCreater;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.joda.time.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateMBTExcel {

    public void createExcel(List<List<String>> testPathDurationsList, List<List<String>> modelEntityVisitCountList, String totalTime, List<String> timeList, List<String> modelList){


        String ExcelPath = DriverCreater.excelLocation;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("TestPathDurations");
        sheet1.setDefaultColumnWidth(45);

        XSSFSheet sheet2 = workbook.createSheet("ModelEntityVisitCount");
        sheet2.setDefaultColumnWidth(45);

        XSSFSheet sheet3 = workbook.createSheet("ModelStats");
        sheet3.setDefaultColumnWidth(45);

        /*sheet1.setColumnWidth(2,60);
        sheet2.setColumnWidth(2,60);*/
        XSSFColor color = getColor(workbook,153, 206, 115, 171); // green
        XSSFColor color2 = getColor(workbook,255, 255, 255, 255); // white
        XSSFColor color3 = getColor(workbook,168, 179, 199, 255); //grey
        XSSFColor color4 = getColor(workbook,96, 162, 195, 255); // blue

        //sheet1.getWorkbook().createCellStyle();
        XSSFCellStyle headStyle1 = workbook.createCellStyle();
        headStyle1.setFillForegroundColor(color);
        headStyle1.setFont(getFont(workbook,15,true,false));
        headStyle1 = getStyle(headStyle1,"CENTER","CENTER");

        XSSFCellStyle headStyle2 = workbook.createCellStyle();
        headStyle2.setFillForegroundColor(color);
        headStyle2.setFont(getFont(workbook,15,true,false));
        headStyle2 = getStyle(headStyle2,"CENTER","CENTER");
        headStyle2.setDataFormat(getDataFormat(workbook,"d/m/yy h:mm:ss.000"));

        XSSFCellStyle headStyleDate = workbook.createCellStyle();
        headStyleDate.setFillForegroundColor(color);
        headStyleDate.setFont(getFont(workbook,15,true,false));
        headStyleDate = getStyle(headStyleDate,"CENTER","CENTER");
        headStyleDate.setDataFormat(getDataFormat(workbook,"d/m/yy"));

        XSSFCellStyle headStyleTime = workbook.createCellStyle();
        headStyleTime.setFillForegroundColor(color);
        headStyleTime.setFont(getFont(workbook,15,true,false));
        headStyleTime = getStyle(headStyleTime,"CENTER","CENTER");
        headStyleTime.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle headStyle3 = workbook.createCellStyle();
        headStyle3.setFillForegroundColor(color);
        headStyle3.setFont(getFont(workbook,15,true,false));
        headStyle3 = getStyle(headStyle3,"CENTER","CENTER");
        headStyle3.setDataFormat(getDataFormat(workbook,"mm:ss.000"));

        XSSFCellStyle headStyle4 = workbook.createCellStyle();
        headStyle4.setFillForegroundColor(color);
        headStyle4.setFont(getFont(workbook,15,true,false));
        headStyle4 = getStyle(headStyle4,"CENTER","CENTER");
        headStyle4.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFillForegroundColor(color2);
        style1.setFont(getFont(workbook,11,false,false));
        style1 = getStyle(style1,"DISTRIBUTED","CENTER");

        XSSFCellStyle style1Grey = workbook.createCellStyle();
        style1Grey.setFillForegroundColor(color3);
        style1Grey.setFont(getFont(workbook,11,false,false));
        style1Grey = getStyle(style1Grey,"DISTRIBUTED","CENTER");

        XSSFCellStyle styleTotal = workbook.createCellStyle();
        styleTotal.setFillForegroundColor(color3);
        styleTotal.setFont(getFont(workbook,14,true,false));
        styleTotal = getStyle(styleTotal,"DISTRIBUTED","CENTER");

        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(color2);
        style2.setFont(getFont(workbook,11,false,false));
        style2 = getStyle(style2,"DISTRIBUTED","CENTER");
        style2.setDataFormat(getDataFormat(workbook,"d/m/yy h:mm:ss.000"));

        XSSFCellStyle styleDate = workbook.createCellStyle();
        styleDate.setFillForegroundColor(color2);
        styleDate.setFont(getFont(workbook,11,false,false));
        styleDate = getStyle(styleDate,"DISTRIBUTED","CENTER");
        styleDate.setDataFormat(getDataFormat(workbook,"d/m/yy"));

        XSSFCellStyle styleDateGrey = workbook.createCellStyle();
        styleDateGrey.setFillForegroundColor(color3);
        styleDateGrey.setFont(getFont(workbook,11,false,false));
        styleDateGrey = getStyle(styleDateGrey,"DISTRIBUTED","CENTER");
        styleDateGrey.setDataFormat(getDataFormat(workbook,"d/m/yy"));

        XSSFCellStyle styleTime = workbook.createCellStyle();
        styleTime.setFillForegroundColor(color2);
        styleTime.setFont(getFont(workbook,11,false,false));
        styleTime = getStyle(styleTime,"DISTRIBUTED","CENTER");
        styleTime.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle styleTimeGrey = workbook.createCellStyle();
        styleTimeGrey.setFillForegroundColor(color3);
        styleTimeGrey.setFont(getFont(workbook,11,false,false));
        styleTimeGrey = getStyle(styleTimeGrey,"DISTRIBUTED","CENTER");
        styleTimeGrey.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setFillForegroundColor(color2);
        style3.setFont(getFont(workbook,11,false,false));
        style3 = getStyle(style3,"DISTRIBUTED","CENTER");
        style3.setDataFormat(getDataFormat(workbook,"mm:ss.000"));

        XSSFCellStyle style3Grey = workbook.createCellStyle();
        style3Grey.setFillForegroundColor(color3);
        style3Grey.setFont(getFont(workbook,11,false,false));
        style3Grey = getStyle(style3Grey,"DISTRIBUTED","CENTER");
        style3Grey.setDataFormat(getDataFormat(workbook,"mm:ss.000"));

        XSSFCellStyle style4 = workbook.createCellStyle();
        style4.setFillForegroundColor(color2);
        style4.setFont(getFont(workbook,11,false,false));
        style4 = getStyle(style4,"DISTRIBUTED","CENTER");
        style4.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle style4Grey = workbook.createCellStyle();
        style4Grey.setFillForegroundColor(color3);
        style4Grey.setFont(getFont(workbook,11,false,false));
        style4Grey = getStyle(style4Grey,"DISTRIBUTED","CENTER");
        style4Grey.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFCellStyle styleTotalTime = workbook.createCellStyle();
        styleTotalTime.setFillForegroundColor(color3);
        styleTotalTime.setFont(getFont(workbook,14,true,false));
        styleTotalTime = getStyle(styleTotalTime,"DISTRIBUTED","CENTER");
        styleTotalTime.setDataFormat(getDataFormat(workbook,"h:mm:ss.000"));

        XSSFRow headRow = sheet1.createRow(0);
        headRow.setHeightInPoints((float) 40);
        setCell(headRow, headStyle1,0,"STRING",
                "Test Model Name","");
        setCell(headRow, headStyle1,1,"STRING",
                "Model visit seq num","");
        setCell(headRow, headStyle1,2,"STRING",
                "Steps (via nodes and edges)","");
        setCell(headRow, headStyle1,3,"STRING",
                "Entity visit seq num","");
        setCell(headRow, headStyleDate,4,"STRING",
                "Date","");
        setCell(headRow, headStyleTime,5,"STRING",
                "Time","");
        setCell(headRow, headStyle3,6,"STRING",
                "DURATION for each step (seconds)","");
        setCell(headRow, headStyle1,7,"STRING",
                "Failure?","");

        XSSFCellStyle style1A = style1;
        XSSFCellStyle styleDateA = styleDate;
        XSSFCellStyle styleTimeA = styleTime;
        XSSFCellStyle style3A = style3;
        int testPathDurationsListSize = testPathDurationsList.size();
       for (int i = 0; i < testPathDurationsListSize; i++){
            XSSFRow row = setRow(sheet1,i+1,25);
            String modelName = testPathDurationsList.get(i).get(0);
            boolean isNotEmpty = false;
            boolean isLastElement = testPathDurationsListSize == (i+1);
            if(!isLastElement) {
                isNotEmpty = !modelName.equals("");
            }
            if(isNotEmpty){
                style1A = style1Grey;
                styleDateA = styleDateGrey;
                styleTimeA = styleTimeGrey;
                style3A = style3Grey;
            }
            if (isNotEmpty || isLastElement) {
                setCell(row, style1A, 0, "STRING",
                        modelName, "");
            }else {
                setCell(row, style1A, 0, "BLANK",
                        "", "");
            }
           if (isNotEmpty) {
               setCell(row, style1A, 1, "NUMERIC",
                       testPathDurationsList.get(i).get(1), "");
           }else {
               setCell(row, style1A, 1, "BLANK",
                       "", "");
           }
           setCell(row, style1A,2,"STRING",
                    testPathDurationsList.get(i).get(2),"");

           if(isLastElement) {
               setCell(row, style1A, 3, "BLANK",
                       "", "");
           }else {
               setCell(row, style1A, 3, "NUMERIC",
                       testPathDurationsList.get(i).get(3), "");
           }
           String[] time = testPathDurationsList.get(i).get(4).split(" ");
           setCell(row, styleDateA,4,"STRING",
                   time[0],"");
           setCell(row, styleTimeA,5,"STRING",
                   time[1],"");
            if (isLastElement){
                setCell(row, style1A, 6, "STRING",
                        "", "");
            }else {
                setCell(row, style3A, 6, "STRING",//"FORMULA",
                        timeList.get(i),""); //"C" + (i + 3) + "-" + "C" + (i + 2));
            }
            setCell(row, style1A,7,"STRING",
                    testPathDurationsList.get(i).get(5),"");
           if(isNotEmpty){
               style1A = style1;
               styleDateA = styleDate;
               styleTimeA = styleTime;
               style3A = style3;
           }
       }

       XSSFRow modelEntityVisitCountRow = sheet2.createRow(0);
        modelEntityVisitCountRow.setHeightInPoints((float) 25);
        setCell(modelEntityVisitCountRow, style1,0,"FORMULA",
                "","COUNTA(A3:A" + (modelEntityVisitCountList.size()+2) + ")");
        setCell(modelEntityVisitCountRow, style1,1,"FORMULA",
                "","COUNTA(B3:B" + (modelEntityVisitCountList.size()+2) + ")");
        setCell(modelEntityVisitCountRow, style1,2,"FORMULA",
                "","COUNTA(C3:C" + (modelEntityVisitCountList.size()+2) + ")");
        setCell(modelEntityVisitCountRow, style1,3,"BLANK",
                "","");
        setCell(modelEntityVisitCountRow, style1,4,"BLANK",
                "","");
        setCell(modelEntityVisitCountRow, style1,5,"BLANK",
                "","");
        setCell(modelEntityVisitCountRow, style1,6,"BLANK",
                "","");
       //COUNTA(A3:A401)  COUNTA(B3:B401) COUNTA(C3:C401)
        //modelEntityVisitCountList.size() + 2

        XSSFRow headRow2 = sheet2.createRow(1);
        headRow2.setHeightInPoints((float) 40);
        setCell(headRow2, headStyle1,0,"STRING",
                "Model #","");
        setCell(headRow2, headStyle1,1,"STRING",
                "Test Model Name","");
        setCell(headRow2, headStyle1,2,"STRING",
                "Entity (nodes and edges)","");
        setCell(headRow2, headStyle1,3,"STRING",
                "Visit count of entity","");
        setCell(headRow2, headStyle1,4,"STRING",
                "Total visit count of model entities","");
        setCell(headRow2, headStyle4,5,"STRING",
                "Total time on entity","");
        setCell(headRow2, headStyle4,6,"STRING",
                "Total time on model","");

        XSSFCellStyle style1B = style1;
        XSSFCellStyle style4B = style4;
        int sumNumber = 3;
        List<Integer> modelNameExcelRowNumber = new ArrayList<Integer>();
        modelNameExcelRowNumber.add(sumNumber);
        for (int j = 0; j < modelEntityVisitCountList.size(); j++){
            XSSFRow row = setRow(sheet2,j+2,25);
            String modelName = modelEntityVisitCountList.get(j).get(1);
            boolean isNotEmpty = !modelName.equals("");
            if(isNotEmpty){
                style1B = style1Grey;
                style4B = style4Grey;
            }
            if (isNotEmpty) {
                setCell(row, style1B, 0, "STRING",
                        modelEntityVisitCountList.get(j).get(0), "");
            }else {
                setCell(row, style1B, 0, "BLANK",
                        "", "");
            }
            if (isNotEmpty) {
                setCell(row, style1B, 1, "STRING",
                        modelName, "");
            }else {
                setCell(row, style1B, 1, "BLANK",
                        "", "");
            }
            setCell(row, style1B,2,"STRING",
                    modelEntityVisitCountList.get(j).get(2),"");
            setCell(row, style1B,3,"NUMERIC",
                    modelEntityVisitCountList.get(j).get(3),"");
            if (modelEntityVisitCountList.get(j).get(4).equals("true")) {
                setCell(row, style1B, 4, "FORMULA",
                        "", "SUM(D" + sumNumber + ":D" + (j + 3) + ")");
                sumNumber = j+4;
                modelNameExcelRowNumber.add(sumNumber);
            }else {
                setCell(row, style1B,4,"BLANK",
                        "","");
            }
            setCell(row, style4B,5,"STRING",
                    modelEntityVisitCountList.get(j).get(5),"");
            setCell(row, style4B,6,"STRING",
                    modelEntityVisitCountList.get(j).get(6),"");
            if(isNotEmpty){
                style1B = style1;
                style4B = style4;
            }
        }
        XSSFRow row = setRow(sheet2,modelEntityVisitCountList.size()+2,25);
        setCell(row, styleTotal,0,"STRING",
                "","");
        setCell(row, styleTotal,1,"STRING",
                "Total","");
        setCell(row, styleTotal,2,"STRING",
                "","");
        setCell(row, styleTotal,3,"STRING",
                "","");
        setCell(row, styleTotal, 4, "FORMULA",
                "", "SUM(D3" + ":D" + (modelEntityVisitCountList.size()+2) + ")");
        setCell(row, styleTotal,5,"STRING",
                "","");
        setCell(row, styleTotalTime,6, "STRING",
                totalTime,"");

        sheet2.createFreezePane(0,2);

        XSSFRow headRow3 = sheet3.createRow(0);
        headRow3.setHeightInPoints((float) 40);

        setCell(headRow3, headStyle1,0,"STRING",
                "Model #","");
        setCell(headRow3, headStyle1,1,"STRING",
                "Test Model Name","");
        setCell(headRow3, headStyle1,2,"STRING",
                "# of Nodes","");
        setCell(headRow3, headStyle1,3,"STRING",
                "# of Edges","");
        setCell(headRow3, headStyle1,4,"STRING",
                "Total # of entities","");
        setCell(headRow3, headStyle4,5,"STRING",
                "Total time on model","");
        setCell(headRow3, headStyle1,6,"STRING",
                "SUM exec of entities","");

        for (int j = 0; j < modelList.size(); j++) {
            XSSFRow modelListRow = setRow(sheet3, j+1, 25);

            setCell(modelListRow, style1, 0, "FORMULA",
                    "", "ModelEntityVisitCount!A" + modelNameExcelRowNumber.get(j));
            setCell(modelListRow, style1, 1, "FORMULA",
                    "", "ModelEntityVisitCount!B" + modelNameExcelRowNumber.get(j));
            setCell(modelListRow, style1, 2, "FORMULA",
                    "", "COUNTIF(ModelEntityVisitCount!C" + modelNameExcelRowNumber.get(j)
                            + ":C" + (modelNameExcelRowNumber.get(j+1)-1) + ", \"v_*\")");
            setCell(modelListRow, style1, 3, "FORMULA",
                    "", "COUNTIF(ModelEntityVisitCount!C" + modelNameExcelRowNumber.get(j)
                            + ":C" + (modelNameExcelRowNumber.get(j+1)-1) + ", \"e_*\")");
            setCell(modelListRow, style1, 4, "FORMULA",
                    "", "C" + (j+2) + "+D" + (j+2));
            setCell(modelListRow, style4, 5, "FORMULA",
                    "", "ModelEntityVisitCount!G" + (modelNameExcelRowNumber.get(j+1)-1));
            setCell(modelListRow, style1, 6, "FORMULA",
                    "", "ModelEntityVisitCount!E" + (modelNameExcelRowNumber.get(j+1)-1));
        }

        /**
        int modelListSize = modelList.size();
        XSSFRow modelListRow = setRow(sheet3, modelListSize, 25);
        setCell(modelListRow, styleTotal, 0, "BLANK",
                "", "");
        setCell(modelListRow, styleTotal, 1, "STRING",
                "Total", "");
        setCell(modelListRow, styleTotal, 2, "FORMULA",
                "", "SUM(C2:C" + (modelListSize + 1));
        setCell(modelListRow, styleTotal, 3, "FORMULA",
                "", "SUM(D2:D" + (modelListSize + 1));
        setCell(modelListRow, styleTotal, 4, "FORMULA",
                "", "SUM(E2:E" + (modelListSize + 1));
        setCell(modelListRow, styleTotalTime, 5, "FORMULA",
                "", "ModelEntityVisitCount!G" + modelNameExcelRowNumber.get(modelListSize));
         */

        try {

            FileOutputStream outputStream = new FileOutputStream(new File(ExcelPath),false);
            try {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public XSSFCellStyle getStyle(XSSFCellStyle style, String horizontal, String vertical){

        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.valueOf(horizontal));
        style.setVerticalAlignment(VerticalAlignment.valueOf(vertical));
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        return style;
    }

    public XSSFFont getFont(XSSFWorkbook workbook, int textSize, boolean bold, boolean italic){

        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) textSize);
        font.setBold(bold);
        font.setItalic(italic);
        return font;
    }

    public XSSFColor getColor(XSSFWorkbook workbook, int r, int g, int b, int a){

        IndexedColorMap colorMap = workbook.getStylesSource().getIndexedColors();
        return new XSSFColor(new java.awt.Color(r, g, b, a), colorMap);
    }

    public short getDataFormat(XSSFWorkbook workbook, String dataFormat){

        XSSFDataFormat format = workbook.createDataFormat();
        return format.getFormat(dataFormat);
    }

    public XSSFRow setRow(XSSFSheet sheet, int rowNumber, int height){

        XSSFRow row = sheet.createRow(rowNumber);
        row.setHeightInPoints((float) height);
        return row;
    }

    public void setCell(XSSFRow row,XSSFCellStyle style, int columnNumber, String cellType, String cellValue, String formula){

        XSSFCell cell = row.createCell(columnNumber, CellType.valueOf(cellType));
        cell.setCellStyle(style);
        switch (cellType){
            case "NUMERIC":
                cell.setCellValue(Double.parseDouble(cellValue));
                break;
            case "BLANK":
                break;
            case "STRING":
                cell.setCellValue(cellValue);
                break;
            case "FORMULA":
                cell.setCellFormula(formula);
                break;
            case "ERROR":
                // ?
                break;
            case "BOOLEAN":
                cell.setCellValue(Boolean.parseBoolean(cellValue));
                break;
            default:
            }
    }
}
