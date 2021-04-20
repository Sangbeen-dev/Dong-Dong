package com.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingApp {
	public static void main(String[] args) {
		
		//SLF4J
		Logger logger = LoggerFactory.getLogger(LoggingApp.class);
		logger.info("log 출력");
	}
}
