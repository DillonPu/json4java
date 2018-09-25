package com.alxtx.utils.json.simplejson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.alxtx.utils.json.exception.SimpleJSONException;
import com.alxtx.utils.string.StringUtils;

public class SimpleJson {
	

	private static final long serialVersionUID = 1L;
	private Map<String, String> map = new HashMap<String,String>();
	private String parseContext;
	private File jsonFile;
	
	/**
	 * 解析纯json字符串
	 * @param parseContext
	 */
	public SimpleJson(String parseContext) {
		this.parseContext = parseContext;
		this.map = parse(parseContext);
	}
	
	public SimpleJson(File jsonFile) {
		this.jsonFile = jsonFile;
		this.parseContext = getJsonStringFromFile(jsonFile);
		this.map = parse(parseContext);
		for(String key : map.keySet()) {
			System.out.println(key);
		}
	}
	
	protected String getJsonStringFromFile(File file) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			FileReader fileReader = new FileReader(file);
			char[] buf = new char[1024];
			int len = 0;
			while((len = fileReader.read(buf))!=-1) {
				String jsonStr = new String(buf, 0, len);
				stringBuilder.append(jsonStr);
			}
			System.out.println(stringBuilder.toString());;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	
	/**
	 * 解析简单的json格式，不包括嵌套模式
	 * @param parseText
	 * @return
	 */
	protected Map<String, String> parse(String parseText) {
		String text = StringUtils.trimSpace(parseText);//去掉空格
		text = StringUtils.trimSingleQuotes(text);
		text = StringUtils.trimDoubleQuotes(text);
		
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
	
	
	
}
