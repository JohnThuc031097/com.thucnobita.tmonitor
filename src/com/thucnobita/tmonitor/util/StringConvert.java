package com.thucnobita.tmonitor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringConvert {

	public static String nameToJson(String text) {
		if (StringUtils.isBlank(text)) {
			return "";
		}

		String regex = "\"(.*?)\":\"";
		String regex2 = "([a-z])([A-Z]+)";
		String replacement = "$1-$2";

		Matcher m = Pattern.compile(regex).matcher(text);

		StringBuilder sb = new StringBuilder();
		int last = 0;
		while (m.find()) {
			// System.out.println("Regex 1:" + m.group(1));
			sb.append(text.substring(last, m.start()));
			sb.append("\"" + m.group(1).replaceAll(regex2, replacement).toLowerCase() + "\":\"");
			last = m.end();
			// System.out.println("Result:" + sb.toString());
		}
		sb.append(text.substring(last));
		return sb.toString();
	}

	public static void writeJsonToFile(String str, String pathFile, String nameFile) {
		File file = new File(pathFile + "\\" + nameFile);
		FileOutputStream fop;
		try {
			fop = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			fop.write(str.getBytes());
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] fileToBytes(File file) throws IOException {
		FileInputStream fl = new FileInputStream(file);

		byte[] arr = new byte[(int) file.length()];
		fl.read(arr);
		fl.close();

		return arr;
	}
}
