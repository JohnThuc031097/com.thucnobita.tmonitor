package com.thucnobita.tmonitor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thucnobita.tmonitor.model.ApiResponseModel;
import com.thucnobita.tmonitor.model.COMenuExcelModel;
import com.thucnobita.tmonitor.model.COOrderCategoryExcelModel;
import com.thucnobita.tmonitor.model.MenuCateGoryExcelModel;
import com.thucnobita.tmonitor.model.MenuExcelModel;
import com.thucnobita.tmonitor.model.SOMenuExcelModel;

public class MenuConnect {

	public void pushCOOrderCategory(List<COOrderCategoryExcelModel> lsCOOrderCategoryExcel, List<String> lsIp,
			String typeAction, boolean isTransferText, boolean isTransferFile) throws Exception {
		ApiConnect conn = new ApiConnect();
		ApiResponseModel result = new ApiResponseModel();
		if (lsIp != null && lsCOOrderCategoryExcel != null) {
			if (lsIp.size() > 0 && lsCOOrderCategoryExcel.size() > 0) {
				for (String ip : lsIp) {
					for (COOrderCategoryExcelModel item : lsCOOrderCategoryExcel) {
						if (isTransferText) {
							result = conn.postCOMenuCategory(typeAction, ip, item.getTypeMenu(), item.getCode(),
									item.getNameVN(), item.getNameEN(),
									"/" + item.getFolder() + "/" + item.getFileName(), item.getGroupCodes());
							System.out.println("[" + ip + "][Action][" + typeAction + "][" + item.getCode()
									+ "][Push data to COOrderCategory] => " + result.getData());
						}

						if (isTransferFile) {
							pushFile(ip, item.getPathFile(), item.getFileName(), item.getFolder());
						}
					}
				}
			}
		}
	}

	public void pushCOMenu(List<COMenuExcelModel> lsCOMenuExcel, List<String> lsIp, String typeAction,
			boolean isTransferText, boolean isTransferFile) throws Exception {
		ApiConnect conn = new ApiConnect();
		ApiResponseModel result = new ApiResponseModel();
		if (lsIp != null && lsCOMenuExcel != null) {
			if (lsIp.size() > 0 && lsCOMenuExcel.size() > 0) {
				for (String ip : lsIp) {
					for (COMenuExcelModel item : lsCOMenuExcel) {
						if (isTransferText) {
							result = conn.postCOMenu(typeAction, ip, item.getCode(), item.getSapCode(),
									item.getNameVN(), item.getNameEN(),
									"/" + item.getFolder() + "/" + item.getFileName());
							System.out.println("[" + ip + "][Action][" + typeAction + "][" + item.getCode() + " - "
									+ item.getSapCode() + "][Push data to COMenu] => " + result.getData());

						}
						if (isTransferFile) {
							pushFile(ip, item.getPathFile(), item.getFileName(), item.getFolder());
						}
					}
				}
			}
		}
	}

	public void pushSOMenu(List<SOMenuExcelModel> lsSOMenuExcelModel, List<String> lsIp, String typeAction)
			throws Exception {
		ApiConnect conn = new ApiConnect();
		List<ApiResponseModel> results = new ArrayList<ApiResponseModel>();
		if (lsIp != null && lsSOMenuExcelModel != null) {
			if (lsIp.size() > 0 && lsSOMenuExcelModel.size() > 0) {
				for (String ip : lsIp) {
					results = conn.postSOMenu(typeAction, ip, lsSOMenuExcelModel);
					for (ApiResponseModel result : results) {
						System.out.println(
								"[" + ip + "][Action][" + typeAction + "][Push data to SOMenu] => " + result.getData());
					}
				}
			}
		}
	}

	public void pushMenu(List<MenuExcelModel> menuExcelModels, List<MenuCateGoryExcelModel> menuCateGoryExcelModels,
			List<String> lsIp, String typeAction) throws Exception {
		ApiConnect conn = new ApiConnect();
		List<ApiResponseModel> results = new ArrayList<ApiResponseModel>();
		if (lsIp != null && menuExcelModels != null && menuCateGoryExcelModels != null) {
			if (lsIp.size() > 0 && menuExcelModels.size() > 0 && menuCateGoryExcelModels.size() > 0) {
				for (String ip : lsIp) {
					results = conn.postMenu(typeAction, ip, menuExcelModels, menuCateGoryExcelModels);
					for (ApiResponseModel result : results) {
						// System.out.println("[" + ip + "][Action][" + typeAction + "][Push data to
						// SOMenu] => " + result.getData());
					}
				}
			}
		}
	}

	public void pushFile(String ip, String pathFile, String fileName, String folder) throws Exception {
		ApiConnect conn = new ApiConnect();
		ApiResponseModel result = new ApiResponseModel();
		if (pathFile != null && fileName != null && folder != null) {
			if ((new File(pathFile + "\\" + fileName).exists())) {
				result = conn.postTransferFile(ip, pathFile, folder, fileName);
				System.out.println("\n[" + ip + "][Transfer file][" + fileName + "]:" + result.getData());
			}
		}
	}
}
