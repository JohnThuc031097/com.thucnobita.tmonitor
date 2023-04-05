package com.thucnobita.tmonitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.thucnobita.tmonitor.entity.COMenuItem;
import com.thucnobita.tmonitor.entity.COMenuItemDetail;
import com.thucnobita.tmonitor.entity.COOrderCategory;
import com.thucnobita.tmonitor.entity.MenuEngineering;
import com.thucnobita.tmonitor.entity.MenuGroup;
import com.thucnobita.tmonitor.entity.MenuGroupDetail;
import com.thucnobita.tmonitor.entity.MenuGroupDetailType;
import com.thucnobita.tmonitor.entity.order.OrderCategory;
import com.thucnobita.tmonitor.model.ApiResponseModel;
import com.thucnobita.tmonitor.model.FileTranferModel;
import com.thucnobita.tmonitor.model.MenuCateGoryExcelModel;
import com.thucnobita.tmonitor.model.MenuExcelModel;
import com.thucnobita.tmonitor.model.SOMenuExcelModel;
import com.thucnobita.tmonitor.util.Constants;
import com.thucnobita.tmonitor.util.StringConvert;

public class ApiConnect {
	private static String host = "http://%s:59900/ggg/api/%s";
	private static int timeOut = 5 * 60;
	private static Gson gson = new Gson();

	public ApiResponseModel postTransferFile(String ip, String pathFile, String folderFile, String nameFile)
			throws IOException {
		File file = new File(pathFile + "\\" + nameFile);
		byte[] arrFile = StringConvert.fileToBytes(file);
		FileTranferModel fileTranferModel = new FileTranferModel();
		fileTranferModel.setFolder(folderFile);
		fileTranferModel.setFileName(nameFile);
		fileTranferModel.setFile(arrFile);
		Gson gson = new Gson();
		String params = StringConvert.nameToJson(gson.toJson(fileTranferModel));
		return this.callApi("POST", ip, Constants.URL_API_FILE, params, 0);
	}

	public ApiResponseModel postCOMenuCategory(String type, String ip, int typeMenu, String code, String nameVN,
			String nameEN, String pathImg, List<String> groupsCodes) {
		COOrderCategory coOrderCategory = new COOrderCategory();
		coOrderCategory.setType(typeMenu);
		coOrderCategory.setCode(code);
		coOrderCategory.setNameVn(nameVN);
		coOrderCategory.setNameEn(nameEN);
		coOrderCategory.setDescVn(nameVN);
		coOrderCategory.setDescEn(nameEN);
		coOrderCategory.setSrcImg(pathImg);
		coOrderCategory.setSrcImgIntros(Arrays.asList(pathImg));
		coOrderCategory.setMenuGroupCodes(groupsCodes);

		String params = StringConvert.nameToJson(ApiConnect.gson.toJson(coOrderCategory));
		// System.out.println(params);

		return this.callApi("POST", ip, Constants.URL_API_CO_ORDER_CATEGORY + "/" + type, params, 0);
	}

	public ApiResponseModel postCOMenu(String type, String ip, String code, String sapCode, String nameVN,
			String nameEN, String pathImg) {
		COMenuItemDetail coMenuItemDetail = new COMenuItemDetail();
		coMenuItemDetail.setCode(code);
		coMenuItemDetail.setNameVn(nameVN);
		coMenuItemDetail.setNameEn(nameEN);
		List<COMenuItemDetail> coMenuItemDetails = new ArrayList<COMenuItemDetail>();
		coMenuItemDetails.add(coMenuItemDetail);

		COMenuItem coMenuItem = new COMenuItem();
		coMenuItem.setCode(code);
		coMenuItem.setSapCode(sapCode);
		coMenuItem.setCoMenuItemDetails(coMenuItemDetails);
		coMenuItem.setNameVn(nameVN);
		coMenuItem.setNameEn(nameEN);
		coMenuItem.setSrcImg(pathImg);
		coMenuItem.setSrcImgThumbnail(pathImg);
		coMenuItem.setTimeModify(System.currentTimeMillis());

		String params = StringConvert.nameToJson(ApiConnect.gson.toJson(coMenuItem));
		// System.out.println(params);

		return this.callApi("POST", ip, Constants.URL_API_CO_MENU_ITEMS + "/" + type, params, 0);
	}

	public List<ApiResponseModel> postSOMenu(String type, String ip, List<SOMenuExcelModel> lsSOMenuExcelModel) {
		if (lsSOMenuExcelModel == null)
			return null;

		int indexTypeCode = 1;
		int indexTypeCodeChild = 1;
		int level = -1;
		boolean isUpdateEngineering = true;
		String typeCode = "";
		String groupName = "";
		String groupNameChild = "";
		Map<String, List<MenuGroupDetail>> menuGroups = new HashMap<>();
		List<MenuGroup> menuGroupsChild = new ArrayList<>();
		MenuEngineering menuEngineering = new MenuEngineering();
		List<ApiResponseModel> results = new ArrayList<ApiResponseModel>();

		try {
			for (SOMenuExcelModel soMenuExcelModel : lsSOMenuExcelModel) {
				if (typeCode == "")
					typeCode = soMenuExcelModel.getTypeCode();
				level = soMenuExcelModel.getGroupChildCode() == null ? -1 : 0;

				if (soMenuExcelModel.getTypeName().equals("end")) {
					String groupCode = "";
					String params = "";
					for (Map.Entry<String, List<MenuGroupDetail>> entry : menuGroups.entrySet()) {
						int index = 1;
						MenuGroup menuGroup = ApiConnect.gson.fromJson(entry.getKey(), MenuGroup.class);
						List<MenuGroupDetail> menuGroupDetails = entry.getValue();
						List<MenuGroupDetail> menuGroupDetailsNew = new ArrayList<>();
						if (groupCode == "")
							groupCode = menuGroup.getCode();

						// System.out.println(String.format("[%s][%s]: %s", menuGroup.getCode(),
						// menuGroup.getName(), menuGroupDetails.size()));
						for (MenuGroupDetail item : menuGroupDetails) {
							// System.out.println(String.format("%s - %s", index, item.getName()));
							item.setOrderNumberItem(index);
							menuGroupDetailsNew.add(item);
							index++;
						}
						menuGroup.setDetails(menuGroupDetailsNew);
						params = StringConvert.nameToJson(ApiConnect.gson.toJson(menuGroup)).replace("orderNumberItem",
								"order-number-item");
						results.add(this.callApi("POST", ip, Constants.URL_API_SO_MENU_GROUP + "/" + type, params, 0));
					}
					System.out.println("[Updated item SO]:" + typeCode);
					if (isUpdateEngineering) {
						List<MenuGroup> menuGroupsKey = new ArrayList<>();
						List<MenuGroup> menuGroupsKeyNew = new ArrayList<>();
						int index = 1;
						for (String item : menuGroups.keySet()) {
							menuGroupsKey.add(ApiConnect.gson.fromJson(item, MenuGroup.class));
						}
						if (menuGroupsChild.size() > 0) {
							menuGroupsKey.addAll(menuGroupsChild);
						}
						for (MenuGroup item : menuGroupsKey) {
							item.setOrderNo(index++);
							menuGroupsKeyNew.add(item);
						}
						menuEngineering.setOrderCategory(new OrderCategory(typeCode));
						menuEngineering.setMenuType(groupCode.split("_")[0]);
						menuEngineering.setMenuGroups(menuGroupsKeyNew);
						params = StringConvert.nameToJson(ApiConnect.gson.toJson(menuEngineering)).replace("orderNo",
								"order-no");
						results.add(this.callApi("POST", ip, Constants.URL_API_SO_MENU_ENGINEERING + "/" + type, params,
								0));
						System.out.println("[Updated Engineering]:" + typeCode);
					}
					typeCode = "";
					groupName = "";
					groupNameChild = "";
					indexTypeCode = 1;
					indexTypeCodeChild = 1;
					isUpdateEngineering = true;
					menuGroups = new HashMap<>();
				} else {
					if (groupName == "")
						groupName = soMenuExcelModel.getGroupName();
					if (!groupName.equals(soMenuExcelModel.getGroupName())) {
						groupName = soMenuExcelModel.getGroupName();
						indexTypeCode++;
					}

					MenuGroup menuGroup = new MenuGroup();
					menuGroup.setCode(String.format(level == -1 ? "%s_%s_%s" : "%s_%s", soMenuExcelModel.getGroupCode(),
							soMenuExcelModel.getTypeCode(), indexTypeCode));
					menuGroup.setName(
							String.format("%s.%s", soMenuExcelModel.getGroupCode(), soMenuExcelModel.getGroupName()));
					menuGroup.setNameEn(
							String.format("%s.%s", soMenuExcelModel.getGroupCode(), soMenuExcelModel.getGroupNameEN()));
					menuGroup.setGroupType(0);
					menuGroup.setLevel(level);
					menuGroup.setOrderNo(indexTypeCode);

					String key = ApiConnect.gson.toJson(menuGroup);

					if (level == -1) {

						MenuGroupDetail menuGroupDetail = new MenuGroupDetail(soMenuExcelModel.getItemCode(),
								MenuGroupDetailType.MENU_ITEM, soMenuExcelModel.getItemNameVN());

						List<MenuGroupDetail> menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							menuGroupDetails.add(menuGroupDetail);
						} else {
							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
						}
						menuGroups.put(key, menuGroupDetails);

					} else {
						if (groupNameChild == "") {
							groupNameChild = soMenuExcelModel.getGroupChildName();
						}
						if (!groupNameChild.equals(soMenuExcelModel.getGroupChildName())) {
							groupNameChild = soMenuExcelModel.getGroupChildName();
							indexTypeCodeChild++;
						}
						MenuGroupDetail menuGroupDetail = new MenuGroupDetail(soMenuExcelModel.getGroupChildCode(),
								MenuGroupDetailType.MENU_GROUP, soMenuExcelModel.getGroupChildName());

						List<MenuGroupDetail> menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							isUpdateEngineering = false;
							menuGroupsChild.add(menuGroup);
							menuGroupDetails.add(menuGroupDetail);
						} else {
							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
						}
						menuGroups.put(key, menuGroupDetails);

						MenuGroup menuGroupChild = new MenuGroup();
						menuGroupChild.setCode(String.format("%s_%s_%s", soMenuExcelModel.getGroupChildCode(),
								soMenuExcelModel.getTypeCode(), indexTypeCodeChild));
						menuGroupChild.setName(String.format("%s", soMenuExcelModel.getGroupChildName()));
						menuGroupChild.setNameEn(String.format("%s", soMenuExcelModel.getGroupChildNameEN()));
						menuGroupChild.setGroupType(0);
						menuGroupChild.setLevel(level);
						menuGroup.setOrderNo(indexTypeCodeChild);

						menuGroupDetail = new MenuGroupDetail(soMenuExcelModel.getItemCode(),
								MenuGroupDetailType.MENU_ITEM, soMenuExcelModel.getItemNameVN());

						key = ApiConnect.gson.toJson(menuGroupChild);

						menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							menuGroupDetails.add(menuGroupDetail);
						} else {
							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
						}
						menuGroups.put(key, menuGroupDetails);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ApiResponseModel error = new ApiResponseModel();
			error.setData(e.getMessage());
			results.add(error);
		}
		return results;
	}

	public List<ApiResponseModel> postMenu(String type, String ip, List<MenuExcelModel> menuExcelModels,
			List<MenuCateGoryExcelModel> menuCateGoryExcelModels) {
		if (menuExcelModels == null)
			return null;

		int indexTypeCode = 1;
		int indexTypeCodeChild = 1;
		int level = -1;
		String typeCode = "";
		String groupName = "";
		String groupNameChild = "";

		Map<String, List<MenuGroupDetail>> menuGroups = new HashMap<>();
		Map<String, List<MenuGroup>> menuGroupsTotal = new HashMap<>();
		Map<String, List<String>> menuTypes = new HashMap<>();
		List<MenuGroup> menuGroupsChild = new ArrayList<>();
		MenuEngineering menuEngineering = new MenuEngineering();
		List<ApiResponseModel> results = new ArrayList<ApiResponseModel>();

		try {
			for (MenuExcelModel menuExcelModel : menuExcelModels) {
				if (typeCode == "")
					typeCode = menuExcelModel.getTypeCode();
				level = menuExcelModel.getGroupChildCode() == null ? -1 : 0;

				if (menuExcelModel.getTypeName().equals("end")) {
					String groupCode = "";
					String params = "";
					for (Map.Entry<String, List<MenuGroupDetail>> entry : menuGroups.entrySet()) {
						int index = 1;
						MenuGroup menuGroup = ApiConnect.gson.fromJson(entry.getKey(), MenuGroup.class);
						List<MenuGroupDetail> menuGroupDetails = entry.getValue();
						List<MenuGroupDetail> menuGroupDetailsNew = new ArrayList<>();
						if (groupCode == "")
							groupCode = menuGroup.getCode();

						// System.out.println(String.format("[%s][%s]: %s", menuGroup.getCode(),
						// menuGroup.getName(), menuGroupDetails.size()));
						for (MenuGroupDetail item : menuGroupDetails) {
							System.out.println(String.format("%s - %s", index, item.getName()));
							item.setOrderNumberItem(index);
							menuGroupDetailsNew.add(item);
							index++;
						}
						menuGroup.setDetails(menuGroupDetailsNew);
						params = StringConvert.nameToJson(ApiConnect.gson.toJson(menuGroup)).replace("orderNumberItem",
								"order-number-item");
						results.add(this.callApi("POST", ip, Constants.URL_API_SO_MENU_GROUP + "/" + type, params, 0));
					}
					System.out.println("[Updated item SO]:" + typeCode);

					List<MenuGroup> menuGroupsKey = new ArrayList<>();
					List<MenuGroup> menuGroupsKeyNew = new ArrayList<>();
					int index = 1;
					for (String item : menuGroups.keySet()) {
						menuGroupsKey.add(ApiConnect.gson.fromJson(item, MenuGroup.class));
					}
					if (menuGroupsChild.size() > 0) {
						menuGroupsKey.addAll(menuGroupsChild);
					}
					for (MenuGroup item : menuGroupsKey) {
						item.setOrderNo(index++);
						menuGroupsKeyNew.add(item);
					}

					String typeMenu = menuGroupsKeyNew.get(0).getCode().split("_")[0];
					List<String> typecodes = new ArrayList<>();
					if (menuTypes.containsKey(typeMenu)) {
						typecodes = menuTypes.get(typeMenu);
						typecodes.add(typeCode);
						menuTypes.put(typeMenu, typecodes);
					} else {
						typecodes.add(typeCode);
						menuTypes.put(typeMenu, typecodes);
					}

					menuGroupsTotal.put(typeCode, menuGroupsKeyNew);
					System.out.println("[Updated MenuGroup NOT Other]:" + typeCode);

					typeCode = "";
					groupName = "";
					groupNameChild = "";
					indexTypeCode = 1;
					indexTypeCodeChild = 1;
					menuGroups = new HashMap<>();
				} else {
					if (groupName == "")
						groupName = menuExcelModel.getGroupName();
					if (!groupName.equals(menuExcelModel.getGroupName())) {
						groupName = menuExcelModel.getGroupName();
						indexTypeCode++;
					}

					MenuGroup menuGroup = new MenuGroup();
					menuGroup.setCode(String.format("%s_%s_%s", menuExcelModel.getGroupCode(),
							menuExcelModel.getTypeCode(), indexTypeCode));
					if (level == 0) {
						menuGroup.setCode(menuExcelModel.getGroupName().toUpperCase());
					}
					menuGroup.setName(
							String.format("%s.%s", menuExcelModel.getGroupCode(), menuExcelModel.getGroupName()));
					menuGroup.setNameEn(
							String.format("%s.%s", menuExcelModel.getGroupCode(), menuExcelModel.getGroupNameEN()));
					menuGroup.setGroupType(0);
					menuGroup.setLevel(level);
					menuGroup.setOrderNo(indexTypeCode);

					String key = ApiConnect.gson.toJson(menuGroup);

					if (level == -1) {

						MenuGroupDetail menuGroupDetail = new MenuGroupDetail(menuExcelModel.getItemCode(),
								MenuGroupDetailType.MENU_ITEM, menuExcelModel.getItemName());

						List<MenuGroupDetail> menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							menuGroupDetails.add(menuGroupDetail);
						} else {
							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
						}
						menuGroups.put(key, menuGroupDetails);

					} else {

						MenuGroupDetail menuGroupDetail = new MenuGroupDetail(
								String.format("%s_%s_%s", menuExcelModel.getGroupChildCode(),
										menuExcelModel.getTypeCode(), indexTypeCodeChild),
								MenuGroupDetailType.MENU_GROUP, menuExcelModel.getGroupChildName());

						List<MenuGroupDetail> menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							menuGroupsChild.add(menuGroup);
							menuGroupDetails.add(menuGroupDetail);
							menuGroups.put(key, menuGroupDetails);
						}

						if (groupNameChild == "") {
							groupNameChild = menuExcelModel.getGroupChildName();
						}
						if (!groupNameChild.equals(menuExcelModel.getGroupChildName())) {
							indexTypeCodeChild++;
							menuGroupDetail = new MenuGroupDetail(
									String.format("%s_%s_%s", menuExcelModel.getGroupChildCode(),
											menuExcelModel.getTypeCode(), indexTypeCodeChild),
									MenuGroupDetailType.MENU_GROUP, menuExcelModel.getGroupChildName());

							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
							menuGroups.put(key, menuGroupDetails);

							groupNameChild = menuExcelModel.getGroupChildName();

						}

						MenuGroup menuGroupChild = new MenuGroup();
						menuGroupChild.setCode(String.format("%s_%s_%s", menuExcelModel.getGroupChildCode(),
								menuExcelModel.getTypeCode(), indexTypeCodeChild));
						menuGroupChild.setName(String.format("%s", menuExcelModel.getGroupChildName()));
						menuGroupChild.setNameEn(String.format("%s", menuExcelModel.getGroupChildNameEN()));
						menuGroupChild.setGroupType(0);
						menuGroupChild.setLevel(level);
						menuGroup.setOrderNo(indexTypeCodeChild);

						menuGroupDetail = new MenuGroupDetail(menuExcelModel.getItemCode(),
								MenuGroupDetailType.MENU_ITEM, menuExcelModel.getItemName());

						key = ApiConnect.gson.toJson(menuGroupChild);

						menuGroupDetails = new ArrayList<>();
						if (!menuGroups.containsKey(key)) {
							menuGroupDetails.add(menuGroupDetail);
						} else {
							menuGroupDetails = menuGroups.get(key);
							menuGroupDetails.add(menuGroupDetail);
						}
						menuGroups.put(key, menuGroupDetails);
					}
				}
			}
			for (Map.Entry<String, List<String>> entry : menuTypes.entrySet()) {
				String params = "";
				String mMenuType = entry.getKey();
				List<String> mTypeCode = entry.getValue();
				List<MenuGroup> mMenuGroups = new ArrayList<>();
				List<String> mMenuGroupTexts = new ArrayList<>();

				for (String itemTypeCode : mTypeCode) {
					if (mMenuType.equals("BUF")) {
						for (String mItemTypeCode : menuTypes.get("ALC")) {
							mMenuGroups.addAll(menuGroupsTotal.get(mItemTypeCode));
						}
					}
					mMenuGroups.addAll(menuGroupsTotal.get(itemTypeCode));

					for (MenuGroup item : mMenuGroups) {
						mMenuGroupTexts.add(item.getCode());
					}

					menuEngineering.setOrderCategory(new OrderCategory(itemTypeCode));
					menuEngineering.setMenuType(mMenuType);
					menuEngineering.setMenuGroups(mMenuGroups);
					params = StringConvert.nameToJson(ApiConnect.gson.toJson(menuEngineering)).replace("orderNo",
							"order-no");
					results.add(
							this.callApi("POST", ip, Constants.URL_API_SO_MENU_ENGINEERING + "/" + type, params, 0));
					System.out.println("[Updated Engineering]:" + itemTypeCode);

					if (menuCateGoryExcelModels != null) {
						if (menuCateGoryExcelModels.size() > 0) {
							for (MenuCateGoryExcelModel category : menuCateGoryExcelModels) {
								if (category.getCategoryCode().equals(itemTypeCode)) {
									String[] splitNameImage = category.getCategoryImage().split("\\\\");
									String nameImage = splitNameImage[splitNameImage.length - 1];
									results.add(this.postCOMenuCategory(type, ip, mMenuType.equals("ALC") ? 1 : 2,
											itemTypeCode, category.getCategoryName(), category.getCategoryNameEN(),
											String.format("/category/%s", nameImage), mMenuGroupTexts));
								}
							}
							System.out.println("[Updated Menu Order Category]:" + itemTypeCode);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			ApiResponseModel error = new ApiResponseModel();
			error.setData(e.getMessage());
			results.add(error);
		}
		return results;
	}

	public ApiResponseModel getAllParams(String ip) {
		return this.callApi("GET", ip, Constants.URL_API_SETUP_PARAM_LIST, "", 0);
	}

	private ApiResponseModel callApi(String method, String ip, String pathUrl, String params, int timeOutAdd) {
		HttpURLConnection con = null;
		ApiResponseModel response = new ApiResponseModel();
		long startTime = System.currentTimeMillis();

		try {
			URL url = new URL(String.format(host, ip, pathUrl));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("Accept", "*/*");
			con.setRequestProperty("Connection", "keep-alive");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
			con.setConnectTimeout(ApiConnect.timeOut + timeOutAdd);
			con.setDoOutput(true);

			if (method == "POST") {
				con.setRequestProperty("Content-Length", String.valueOf(params.getBytes("UTF-8").length));
				OutputStream os = con.getOutputStream();
				os.write(params.getBytes("UTF-8"));
				os.flush();
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer strBuff = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				strBuff.append(inputLine);
			}
			in.close();

			response.setData(strBuff);
		} catch (Exception e) {
			e.printStackTrace();
			response.setData(e.getMessage());
		} finally {
			long endTime = System.currentTimeMillis();
			response.setDurationTime(startTime + " - " + endTime);
		}
		return response;
	}

}
