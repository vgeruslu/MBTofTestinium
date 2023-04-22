package com.mbt.testiniumcloud.methods;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReadExcelMethods {

    public ReadExcelMethods(){

    }

    public XSSFWorkbook readExcel(File excelFile) {

        XSSFWorkbook workbook = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert workbook != null;
       // for (Sheet rows : workbook) {
         //   System.out.println(rows.getSheetName());
       // }
        return workbook;
    }

    public HashMap<Object, Object> getSheetAt(XSSFWorkbook workbook, int sheetNumber){

        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        FormulaEvaluator formulaEval = workbook.getCreationHelper().createFormulaEvaluator();
        return getSheetAt(sheet, formulaEval);
    }

    public HashMap<Object, Object> getSheetAt(XSSFWorkbook workbook, String sheetName){

        XSSFSheet sheet = workbook.getSheet(sheetName);
        FormulaEvaluator formulaEval = workbook.getCreationHelper().createFormulaEvaluator();
        return getSheetAt(sheet, formulaEval);
    }

    private HashMap<Object, Object> getSheetAt(XSSFSheet sheet, FormulaEvaluator formulaEval){

        HashMap<Object, Object> excelMap = new HashMap<Object, Object>();
        System.out.println(sheet.getSheetName());
        int excelLineNumber = 0;
        Object cellValue = null;
        Iterator<Row> rowIt = sheet.iterator();
        Cell excelCell;
        Row row;
        while(rowIt.hasNext()) {
            row = rowIt.next();
            List<Object> cellList = new ArrayList<>();
            for (int i = 0; i < row.getLastCellNum(); i++) {
                excelCell = row.getCell(i);
                if (excelCell == null) {
                    cellValue = null;
                }else {
                    switch (excelCell.getCellType().name()) {
                        case "STRING":
                            cellValue = excelCell.getStringCellValue();
                            break;
                        case "NUMERIC":
                            cellValue = excelCell.getNumericCellValue();
                            break;
                        case "BLANK":
                            cellValue = null;
                            break;
                        case "BOOLEAN":
                            cellValue = excelCell.getBooleanCellValue();
                            break;
                        case "FORMULA":
                            System.out.println(excelCell.getCellFormula());
                            CellValue formulaCellValue = formulaEval.evaluate(excelCell);
                            cellValue = formulaCellValue.getCellType().name()
                                    .equals("NUMERIC") ? formulaCellValue.getNumberValue()
                                    : formulaCellValue.getStringValue();
                            break;

                        default:
                            cellValue = excelCell.toString();
                    }
                }
                cellList.add(cellValue);
            }
            excelMap.put(excelLineNumber, cellList);
            excelLineNumber++;
        }
        excelMap.put("excelLength", excelLineNumber);
        System.out.println(excelLineNumber);
        return excelMap;
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
