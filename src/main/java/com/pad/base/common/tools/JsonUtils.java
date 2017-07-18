package com.pad.base.common.tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * JSON处理
 * @author YF
 */
public class JsonUtils {

	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String jsonStr) {

		Map<String, Object> map = new HashMap<String, Object>();

		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object key : json.keySet()) {
			Object value = json.get(key);
			// 如果内层还是数组的话，继续解析
			if (value instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) value).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(jsonToMap(json2.toString()));
				}
				map.put(key.toString(), list);
			} else {
				map.put(key.toString(), value);
			}
		}
		return map;
	}

}
