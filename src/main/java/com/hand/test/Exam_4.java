package com.hand.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exam_4 {
	/**
	 * 存放随机数的List
	 */
	private static List<Integer> listInt = new ArrayList<>();
	/**
	 * 存放十位相同的数字的Map
	 */
	private static Map<Integer, String> mapInt = new HashMap<>();

	public static void main(String[] args) {
		getList(listInt);
		getMap(mapInt, listInt);
		sortMapByKey(mapInt);
	}

	/**
	 * 将list中的数字按十位存放在Map中
	 * @param mapInt
	 * @param listInt
	 */
	private static void getMap(Map<Integer, String> mapInt, List<Integer> listInt) {
		for (Integer integer : listInt) {
			int key = integer / 10;
			String str = mapInt.get(key);
			if (str != null && !"".equals(str)) {
				str = str + "," + integer;
			} else {
				str = integer.toString();
			}
			mapInt.put(key, str);
		}
		int cnt = 0;
		System.out.print("Map中的数据为：{");
		for (Map.Entry<Integer, String> map : mapInt.entrySet()) {
			if(cnt > 0){
				System.out.print(",");
			}
			cnt++;
			System.out.print(map.getKey() + ">=[" + map.getValue() + "]");
		}
		System.out.println("}");
	}

	/**
	 * 生成随机数
	 * @param listInt
	 */
	private static void getList(List<Integer> listInt) {
		int i = 50;
		System.out.print("随机生成50个小于100的数，分别为：");
		while (i > 0) {
			if(i < 50){
				System.out.print(",");
			}
			int num = (int) (Math.random() * 100);
			listInt.add(num);
			System.out.print(num + "");
			i--;
		}
		System.out.println();
	}

	/**
	 * Map排序
	 * @param mapInt
	 * @return
	 */
	public static Map<Integer, String> sortMapByKey(Map<Integer, String> mapInt) {
		if (mapInt == null || mapInt.isEmpty()) {
			return null;
		}
		Map<Integer, String> sortMap = new TreeMap<Integer, String>(new MapKeyComparator());
		sortMap.putAll(mapInt);
		System.out.print("排序后的Map为：{");
		int cnt = 0;
		for (Map.Entry<Integer, String> map : sortMap.entrySet()) {
			if(cnt > 0){
				System.out.print(",");
			}
			cnt++;
			System.out.print(map.getKey() + ">=[" + map.getValue() + "]");
		}
		System.out.println("}");
		return sortMap;
	}

}

/**
 * 实现Comparator接口中的compare方法，对map排序
 */
class MapKeyComparator implements Comparator<Integer> {
	public int compare(Integer key1, Integer key2) {
		return key1 - key2;
	}
}
