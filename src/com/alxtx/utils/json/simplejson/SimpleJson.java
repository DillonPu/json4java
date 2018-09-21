package com.alxtx.utils.json.simplejson;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.alxtx.utils.json.exception.SimpleJSONException;
import com.alxtx.utils.string.StringUtils;

public class SimpleJson {
	

	private static final long serialVersionUID = 1L;
	private Map<String, String> map = new HashMap<String,String>();
	private String parseContext;
	
	public SimpleJson(String parseContext) {
		this.parseContext = parseContext;
		this.map = parse(parseContext);
	}
	
	/**
	 * 解析简单的json格式，不包括嵌套模式
	 * @param parseText
	 * @return
	 */
	protected Map<String, String> parse(String parseText) {
		String text = StringUtils.trimSpace(parseText);//去掉空格
		text = StringUtils.trimSingleQuotes(text);
		if(!text.startsWith("{") || !text.endsWith("}"))
			try {
				throw new SimpleJSONException();
			} catch (SimpleJSONException e) {
				e.printStackTrace();
			}
		text = text.substring(1, text.length()-1);
		
		String[] key_value_strings = text.split(",");
		for(String key_value_string : key_value_strings) {
			String[] k_v = key_value_string.split(":");
			this.map.put(k_v[0], k_v[1]);
		}
		return this.map;
	}
	
	
	/**
	 * 根据key获取值
	 * @param key
	 * @return value 返回对应的键值
	 */
	public String getString(String key) {
		return map.get(key);
	}
	
	public String setValue(String key,String value) {
		return map.put(key, value);
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
	
}
