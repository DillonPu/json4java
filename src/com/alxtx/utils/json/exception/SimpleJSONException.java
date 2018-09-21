package com.alxtx.utils.json.exception;

public class SimpleJSONException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleJSONException() {
		super("JSON源数据不符合格式");
	}
}
