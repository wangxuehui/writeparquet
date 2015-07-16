package com.lotuseed.parquet.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson extends TestCase {

	public static void testJson() {
		String jsonInstall = "{\"1\":[{\"id\":4433342,\"ps\":[],\"sz\":\"0\",\"t\":\"1387805022631\",\"v\":626},{\"id\":4426706,\"ps\":[],\"sz\":\"0\",\"t\":\"1387812959763\",\"v\":3398}],\"2\":[]}";
		JSONObject json = JSON.parseObject(jsonInstall);

		JSONArray jsonArrayInstallZore = JSON.parseArray(json.get("1")
				.toString());
		JSONArray jsonArrayInstallTwo = JSON.parseArray(json.get("2")
				.toString());

		for (int i = 0; i < jsonArrayInstallZore.size(); i++) {
			System.out.println("uninstallzore" + "\t"
					+ jsonArrayInstallZore.getJSONObject(i).get("id"));
		}
		for (int i = 0; i < jsonArrayInstallTwo.size(); i++) {
			System.out.println("uninstalltwo" + "\t"
					+ jsonArrayInstallTwo.getJSONObject(i).get("id"));
		}
		String jsonUninstall = "[{\"id\":4433342,\"v\":0},{\"id\":4425055,\"v\":0}]";
		JSONArray jsonArrayUninstallZore = JSON.parseArray(jsonUninstall);
		for (int i = 0; i < jsonArrayUninstallZore.size(); i++) {
			System.out.println("uninstall" + "\t"
					+ jsonArrayUninstallZore.getJSONObject(i).get("id"));
		}

	}

	/**
	 * 根据年 月 获取对 应的月份 天数
	 * */
	public static void testDaysByYearMonth() {
		int year = 2015, month = 2;
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		int maxDate = a.getActualMaximum(Calendar.DAY_OF_MONTH);
		;
		System.out.println(maxDate);
	}

	public static void getDaysByYearMonth() {
		int year = 2015, month = 2;
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		System.out.println(maxDate);
	}

	public static void testDayListRemove() {
		List<Long> listOne = new ArrayList<Long>();
		List<Long> listTwo = new ArrayList<Long>();
		listOne.add(1l);
		listOne.add(1l);
		listOne.add(2l);
		listTwo.add(1l);
		listOne.retainAll(listTwo);
		System.out.println(listOne.size());
		


	}
}
