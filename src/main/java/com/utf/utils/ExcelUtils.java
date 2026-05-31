package com.utf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    // Original method — kept for backward compatibility
    public static List<Map<String, String>> getExcelDetails(String sheetname) {
        return readSheet(sheetname, null);
    }

    // New method — filters by testMethodName and execute=yes
    public static List<Map<String, String>> getTestData(
            String filePath, String sheetname, String testMethodName) throws Exception {
        Map<String, String> map;
        List<Map<String, String>> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = wb.getSheet(sheetname);
            DataFormatter format = new DataFormatter();
            int lastRowNum = sheet.getLastRowNum();
            int columnNum = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < columnNum; j++) {
                	String key = format.formatCellValue(sheet.getRow(0).getCell(j)).toLowerCase().trim();
                    String value = format.formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                String rowTestName = map.get("testname");
                String execute = map.get("execute");
                if (rowTestName != null
                        && rowTestName.equalsIgnoreCase(testMethodName)
                        && execute != null
                        && execute.equalsIgnoreCase("yes")) {
                    list.add(map);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
        return list;
    }

    // Private helper used by getExcelDetails
    private static List<Map<String, String>> readSheet(String sheetname, String filter) {
        Map<String, String> map;
        List<Map<String, String>> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(
                com.utf.constant.FrameworkConstant.getExcelFile());
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = wb.getSheet(sheetname);
            DataFormatter format = new DataFormatter();
            int lastRowNum = sheet.getLastRowNum();
            int columnNum = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < columnNum; j++) {
                	String key = format.formatCellValue(sheet.getRow(0).getCell(j)).toLowerCase().trim();
                    String value = format.formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}