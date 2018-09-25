package com.alxtx.utils.json.exception;

import java.io.FileNotFoundException;

public class JsonFileNotFoundException extends FileNotFoundException {
	public JsonFileNotFoundException() {
		super("json文件不存在");
	}
}
