package com.alxtx.utils.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alxtx.utils.json.exception.SimpleJSONException;
import com.alxtx.utils.json.simplejson.SimpleJson;
import com.alxtx.utils.string.StringUtils;

public class TestUtils {
	@Test
	public void testDemo1() {
		String text = "{'name':'value  ','name2  ':' value2'}";
		SimpleJson simpleJson = new SimpleJson(text);
		String value = simpleJson.getString("name");
		System.out.println(value);
	}
	
	@Test
	public void test() throws SimpleJSONException {
		Map<String, String> map = new HashMap<String, String>();
		String text = "{'name':'value  ','name2  ':' value2'}";
		text = StringUtils.trimSpace(text);//去掉空格
		text = StringUtils.trimSingleQuotes(text);
		System.out.println(text);
		if(!text.startsWith("{") || !text.endsWith("}")) 
			throw new SimpleJSONException();
		text = text.substring(1, text.length()-1);
		
		String[] key_value_strings = text.split(",");
		for(String key_value_string : key_value_strings) {
			System.out.println(key_value_string);
			String[] k_v = key_value_string.split(":");
//			System.out.println(k_v[0]);
//			System.out.println(k_v[1]);
			map.put(k_v[0], k_v[1]);
		}
		
		System.out.println(map.get("name"));
	}
	
	@Test
	public void test2() {
		File file = new File("src/json.json");
		SimpleJson simpleJson = new SimpleJson(file);
		System.out.println(simpleJson.getString("address"));
	}
}
