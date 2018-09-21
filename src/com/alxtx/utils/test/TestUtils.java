package com.alxtx.utils.test;

import org.junit.Test;

import com.alxtx.utils.json.simplejson.SimpleJson;

public class TestUtils {
	@Test
	public void testDemo1() {
		String text = "{'name':'value  ','name2  ':' value2'}";
		SimpleJson simpleJson = new SimpleJson(text);
		String value = simpleJson.getString("name");
		System.out.println(value);
	}
}
