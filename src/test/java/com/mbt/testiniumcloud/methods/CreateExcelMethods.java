package com.mbt.testiniumcloud.methods;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;

public class CreateExcelMethods {

    public XSSFCellStyle headStyle1;
    public XSSFCellStyle style1;
    public XSSFCellStyle styleRed;
    public XSSFCellStyle styleYellow;
    public XSSFCellStyle style1Grey;
    public XSSFCellStyle styleTotal;

    public void createStyle(XSSFWorkbook workbook){

        XSSFColor color = getColor(workbook,153, 206, 115, 171); // green
        XSSFColor color2 = getColor(workbook,255, 255, 255, 255); // white
        XSSFColor color3 = getColor(workbook,168, 179, 199, 255); //grey
        XSSFColor color4 = getColor(workbook,96, 162, 195, 255); // blue
        XSSFColor yellow = getColor(workbook,255, 238, 5, 255);
        XSSFColor red = getColor(workbook,255, 0, 0, 255); // red

        headStyle1 = workbook.createCellStyle();
        headStyle1.setFillForegroundColor(color);
        headStyle1.setFont(getFont(workbook,15,true,false));
        headStyle1 = getStyle(headStyle1,"CENTER","CENTER");

        style1 = workbook.createCellStyle();
        style1.setFillForegroundColor(color2);
        style1.setFont(getFont(workbook,12,false,false));
        style1 = getStyle(style1,"CENTER","CENTER");

        styleRed = workbook.createCellStyle();
        styleRed.setFillForegroundColor(red);
        styleRed.setFont(getFont(workbook,12,false,false));
        styleRed = getStyle(styleRed,"CENTER","CENTER");

        styleYellow = workbook.createCellStyle();
        styleYellow.setFillForegroundColor(yellow);
        styleYellow.setFont(getFont(workbook,12,false,false));
        styleYellow = getStyle(styleYellow,"CENTER","CENTER");

        style1Grey = workbook.createCellStyle();
        style1Grey.setFillForegroundColor(color3);
        style1Grey.setFont(getFont(workbook,11,false,false));
        style1Grey = getStyle(style1Grey,"DISTRIBUTED","CENTER");

        styleTotal = workbook.createCellStyle();
        styleTotal.setFillForegroundColor(color3);
        styleTotal.setFont(getFont(workbook,14,true,false));
        styleTotal = getStyle(styleTotal,"DISTRIBUTED","CENTER");
    }

    public void setCellValue(XSSFRow row, Object value, String cellType, XSSFCellStyle style, int columnNumber){

        if (value != null) {
            setCell(row, style, columnNumber, cellType, value.toString(),"");
        }else {
            setCell(row, style, columnNumber,"BLANK","","");
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

    public void closeWorkbook(XSSFWorkbook workbook){

        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
