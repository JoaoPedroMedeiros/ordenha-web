package com.dac.produtor.util;

import javax.servlet.http.HttpServletRequest;

public class ErrorHandler {

	public static void handleException(HttpServletRequest request, Exception e) {
		e.printStackTrace();
	}
}
