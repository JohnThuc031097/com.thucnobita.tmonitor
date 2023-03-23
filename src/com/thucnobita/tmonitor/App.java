package com.thucnobita.tmonitor;

import java.io.File;
import java.util.List;

import com.thucnobita.tmonitor.model.MenuCateGoryExcelModel;
import com.thucnobita.tmonitor.model.MenuExcelModel;
import com.thucnobita.tmonitor.util.Enums;
import com.thucnobita.tmonitor.util.Excel;

public class App {

	public static void main(String[] args) {

		Excel excel = new Excel();

		String brand = "test";
		String pathFile = "D:\\Projects\\data\\" + brand + "\\files\\";

		File fileIp = new File(pathFile + "ip.xlsx");
		File fileMenu = new File(pathFile + "menu.xlsx");
		// File fileSOMenu = new File(pathFile + "so_menu.xlsx");
		// File fileCOMenu = new File(pathFile + "co_menu.xlsx");
		// File fileCOOrderCategory = new File(pathFile + "co_order_category.xlsx");

		List<String> ipExcel = null;
		List<MenuExcelModel> menuExcelModels = null;
		List<MenuCateGoryExcelModel> menuCateGoryExcelModels = null;
		// List<SOMenuExcelModel> soMenuExcel = null;
		// List<COMenuExcelModel> coMenuExcel = null;
		// List<COOrderCategoryExcelModel> coOrderCategoryExcel = null;

		MenuConnect menuConn = new MenuConnect();
		try {
			ipExcel = excel.readIp(fileIp);

			menuExcelModels = excel.readMenu(fileMenu, 0);
			menuCateGoryExcelModels = excel.readMenuCategory(fileMenu, 1);
			// soMenuExcel = excel.readSOMenu(fileSOMenu);
			// coMenuExcel = excel.readCOMenu(fileCOMenu);
			// coOrderCategoryExcel = excel.readCOMenuCategory(fileCOOrderCategory);

			menuConn.pushMenu(menuExcelModels, menuCateGoryExcelModels, ipExcel, Enums.API_ACTION_CREATE_OR_UPDATE);

			// menuConnect.pushSOMenu(soMenuExcel, ipExcel,
			// Enums.API_ACTION_CREATE_OR_UPDATE);
			// menuConn.pushCOMenu(coMenuExcel, ipExcel, Enums.API_ACTION_CREATE_OR_UPDATE,
			// false, true);
			// menuConnect.pushCOOrderCategory(coOrderCategoryExcel, ipExcel,
			// Enums.API_ACTION_CREATE_OR_UPDATE, true, true);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
