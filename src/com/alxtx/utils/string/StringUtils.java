package com.alxtx.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author AL
 *
 */
public class StringUtils {
	
	/**
	 * 去掉所有的空格 包括首尾
	 * @param string 
	 * @return String
	 */
	public static String trimSpace(String string) {
		String regxSpace = "\\s"; //匹配空格
		Pattern pattern = Pattern.compile(regxSpace);
		Matcher matcher = pattern.matcher(string);
		String string2 = matcher.replaceAll("");
		return string2;
	}
	
	/**
	 * 去掉单引号
	 * @param string
	 * @return String
	 */
	public static String trimSingleQuotes(String string) {
		String regxSpace = "\\'"; //匹配空格
		Pattern pattern = Pattern.compile(regxSpace);
		Matcher matcher = pattern.matcher(string);
		String string2 = matcher.replaceAll("");
		return string2;
	}
}
