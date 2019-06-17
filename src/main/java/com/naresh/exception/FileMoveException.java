package com.naresh.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileMoveException extends RuntimeException {
	private static final Logger logger = LogManager.getLogger(RuntimeException.class);
	private static final long serialVersionUID = 1L;

	public FileMoveException(String s) {
		logger.error(s);
	}
}
