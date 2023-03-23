package com.thucnobita.tmonitor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.thucnobita.tmonitor.model.COMenuExcelModel;
import com.thucnobita.tmonitor.model.COOrderCategoryExcelModel;
import com.thucnobita.tmonitor.model.MenuCateGoryExcelModel;
import com.thucnobita.tmonitor.model.MenuExcelModel;
import com.thucnobita.tmonitor.model.SOMenuExcelModel;

public class Excel {

	public List<String> readIp(File file) {
		List<String> lsIP = new ArrayList<String>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			for (Row currentRow : datatypeSheet) {
				if (currentRow.getRowNum() == 0)
					continue;

				String ip = "";
				String ipPrefix = "";
				// IP
				currentRow.getCell(0).setCellType(CellType.STRING);
				ip = currentRow.getCell(0).getStringCellValue();
				String[] ipSplit = ip.split(Pattern.quote("."));
				// IP Prefix
				currentRow.getCell(1).setCellType(CellType.STRING);
				ipPrefix = currentRow.getCell(1).getStringCellValue();

				ip = ipSplit[0] + "." + ipSplit[1] + "." + ipSplit[2] + "." + ipPrefix;

				// Add menu item to list menu
				lsIP.add(ip);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lsIP = null;
		}
		return lsIP;

	}

	public List<COOrderCategoryExcelModel> readCOMenuCategory(File file) {
		List<COOrderCategoryExcelModel> lsCOOrderCategory = new ArrayList<COOrderCategoryExcelModel>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			for (Row currentRow : datatypeSheet) {
				if (currentRow.getRowNum() == 0)
					continue;

				COOrderCategoryExcelModel coOrderCategoryExcel = new COOrderCategoryExcelModel();
				// Type menu
				currentRow.getCell(0).setCellType(CellType.STRING);
				coOrderCategoryExcel.setTypeMenu(Integer.parseInt(currentRow.getCell(0).getStringCellValue()));
				// Code
				currentRow.getCell(1).setCellType(CellType.STRING);
				coOrderCategoryExcel.setCode(currentRow.getCell(1).getStringCellValue());
				// Name VN
				currentRow.getCell(2).setCellType(CellType.STRING);
				coOrderCategoryExcel.setNameVN(currentRow.getCell(2).getStringCellValue());
				// Name EN
				currentRow.getCell(3).setCellType(CellType.STRING);
				coOrderCategoryExcel.setNameEN(currentRow.getCell(3).getStringCellValue());
				// Path file
				currentRow.getCell(4).setCellType(CellType.STRING);
				coOrderCategoryExcel.setPathFile(currentRow.getCell(4).getStringCellValue());
				// Folder
				currentRow.getCell(5).setCellType(CellType.STRING);
				coOrderCategoryExcel.setFolder(currentRow.getCell(5).getStringCellValue());
				// File name
				currentRow.getCell(6).setCellType(CellType.STRING);
				coOrderCategoryExcel.setFileName(currentRow.getCell(6).getStringCellValue());
				// Group code
				if (currentRow.getCell(7) != null) {
					currentRow.getCell(7).setCellType(CellType.STRING);
					coOrderCategoryExcel
							.setGroupCodes(Arrays.asList(currentRow.getCell(7).getStringCellValue().split(",")));
				}

				// Add order category to list
				lsCOOrderCategory.add(coOrderCategoryExcel);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lsCOOrderCategory = null;
		}
		return lsCOOrderCategory;
	}

	public List<COMenuExcelModel> readCOMenu(File file) {
		List<COMenuExcelModel> lsMenu = new ArrayList<COMenuExcelModel>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			for (Row currentRow : datatypeSheet) {
				if (currentRow.getRowNum() == 0)
					continue;

				COMenuExcelModel menuExcel = new COMenuExcelModel();
				// Code
				currentRow.getCell(0).setCellType(CellType.STRING);
				menuExcel.setCode(currentRow.getCell(0).getStringCellValue());
				// Sap code
				currentRow.getCell(1).setCellType(CellType.STRING);
				menuExcel.setSapCode(currentRow.getCell(1).getStringCellValue());
				// Name VN
				currentRow.getCell(2).setCellType(CellType.STRING);
				menuExcel.setNameVN(currentRow.getCell(2).getStringCellValue());
				// Name EN
				currentRow.getCell(3).setCellType(CellType.STRING);
				menuExcel.setNameEN(currentRow.getCell(3).getStringCellValue());
				// Path file
				if (currentRow.getCell(4) != null) {
					currentRow.getCell(4).setCellType(CellType.STRING);
					menuExcel.setPathFile(currentRow.getCell(4).getStringCellValue());
				}
				// Folder
				if (currentRow.getCell(5) != null) {
					currentRow.getCell(2).setCellType(CellType.STRING);
					menuExcel.setFolder(currentRow.getCell(5).getStringCellValue());
				}
				// File name
				if (currentRow.getCell(6) != null) {
					currentRow.getCell(6).setCellType(CellType.STRING);
					menuExcel.setFileName(currentRow.getCell(6).getStringCellValue());
					;
				}

				// Add menu item to list
				lsMenu.add(menuExcel);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lsMenu = null;
		}
		return lsMenu;
	}

	public List<SOMenuExcelModel> readSOMenu(File file) {

		List<SOMenuExcelModel> lssoMenuExcelModel = new ArrayList<SOMenuExcelModel>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			for (Row currentRow : datatypeSheet) {
				Cell cell;
				if (currentRow.getRowNum() == 0)
					continue;

				SOMenuExcelModel soMenuExcelModel = new SOMenuExcelModel();
				int index = 0;

				// Type name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setTypeName(cell.getStringCellValue());
						if (cell.getStringCellValue() == "end")
							continue;
					}
				}
				// Type code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setTypeCode(cell.getStringCellValue().trim());
					}
				}
				// Group code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupCode(cell.getStringCellValue().trim());
					}
				}
				// Group name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupName(cell.getStringCellValue().trim());
					}
				}
				// Group name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupNameEN(cell.getStringCellValue().trim());
					}
				}
				// Group child code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupChildCode(cell.getStringCellValue());
					}
				}
				// Group child name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupChildName(cell.getStringCellValue().trim());
					}
				}
				// Group child name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setGroupChildNameEN(cell.getStringCellValue().trim());
					}
				}
				// Item code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setItemCode(cell.getStringCellValue());
					}
				}
				// Item sap code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setItemSapCode(cell.getStringCellValue().trim());
					}
				}
				// Item name VN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setItemNameVN(cell.getStringCellValue().trim());
					}
				}
				// Item name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setItemNameEN(cell.getStringCellValue().trim());
					}
				}
				// Item is new
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						soMenuExcelModel.setItemIsNew(Boolean.parseBoolean(cell.getStringCellValue().trim()));
					}
				}

				lssoMenuExcelModel.add(soMenuExcelModel);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lssoMenuExcelModel = null;
		}
		return lssoMenuExcelModel;
	}

	public List<MenuExcelModel> readMenu(File file, int sheetAt) {

		List<MenuExcelModel> menuExcelModels = new ArrayList<MenuExcelModel>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(sheetAt);
			for (Row currentRow : datatypeSheet) {
				Cell cell;
				if (currentRow.getRowNum() == 0)
					continue;

				MenuExcelModel menuExcelModel = new MenuExcelModel();
				int index = 0;

				// Type name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setTypeName(cell.getStringCellValue());
						if (cell.getStringCellValue() == "end")
							continue;
					}
				}
				// Type code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setTypeCode(cell.getStringCellValue().trim());
					}
				}
				// Group code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupCode(cell.getStringCellValue().trim());
					}
				}
				// Group name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupName(cell.getStringCellValue().trim());
					}
				}
				// Group name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupNameEN(cell.getStringCellValue().trim());
					} else {
						menuExcelModel.setGroupNameEN(menuExcelModel.getGroupName());
					}
				} else {
					menuExcelModel.setGroupNameEN(menuExcelModel.getGroupName());
				}
				// Group child code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupChildCode(cell.getStringCellValue());
					}
				}
				// Group child name
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupChildName(cell.getStringCellValue().trim());
					}
				}
				// Group child name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setGroupChildNameEN(cell.getStringCellValue().trim());
					} else {
						menuExcelModel.setGroupChildNameEN(menuExcelModel.getGroupChildName());
					}
				} else {
					menuExcelModel.setGroupChildNameEN(menuExcelModel.getGroupChildName());
				}
				// Item code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setItemCode(cell.getStringCellValue());
					}
				}
				// Item sap code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setItemSapCode(cell.getStringCellValue().trim());
					}
				}
				// Item name VN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setItemName(cell.getStringCellValue().trim());
					}
				}
				// Item name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setItemNameEN(cell.getStringCellValue().trim());
					} else {
						menuExcelModel.setItemNameEN(menuExcelModel.getItemName());
					}
				} else {
					menuExcelModel.setItemNameEN(menuExcelModel.getItemName());
				}
				// Item is new
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuExcelModel.setItemIsNew(Boolean.parseBoolean(cell.getStringCellValue().trim()));
					}
				}

				menuExcelModels.add(menuExcelModel);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			menuExcelModels = null;
		}
		return menuExcelModels;
	}

	public List<MenuCateGoryExcelModel> readMenuCategory(File file, int sheetAt) {

		List<MenuCateGoryExcelModel> menuCateGoryExcelModels = new ArrayList<MenuCateGoryExcelModel>();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook((InputStream) excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(sheetAt);
			for (Row currentRow : datatypeSheet) {
				Cell cell;
				if (currentRow.getRowNum() == 0)
					continue;

				MenuCateGoryExcelModel menuCateGoryExcelModel = new MenuCateGoryExcelModel();
				int index = 0;

				// Type
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuCateGoryExcelModel.setCategoryType(Integer.valueOf(cell.getStringCellValue().trim()));
					}
				}
				// Code
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuCateGoryExcelModel.setCategoryCode(cell.getStringCellValue().trim());
					}
				}
				// Name VN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuCateGoryExcelModel.setCategoryName(cell.getStringCellValue().trim());
					}
				}
				// Name EN
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuCateGoryExcelModel.setCategoryNameEN(cell.getStringCellValue().trim());
					} else {
						menuCateGoryExcelModel.setCategoryNameEN(menuCateGoryExcelModel.getCategoryName());
					}
				} else {
					menuCateGoryExcelModel.setCategoryNameEN(menuCateGoryExcelModel.getCategoryName());
				}
				// Image
				if (null != (cell = currentRow.getCell(index++))) {
					cell.setCellType(CellType.STRING);
					if (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()) {
						menuCateGoryExcelModel.setCategoryImage(cell.getStringCellValue().trim());
					}
				}

				menuCateGoryExcelModels.add(menuCateGoryExcelModel);
			}
			workbook.close();
			excelFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			menuCateGoryExcelModels = null;
		}
		return menuCateGoryExcelModels;
	}
}
