package com.junjay.spring5.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

public class UserLog {
	
	@Nullable
	private String name;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Logger getLog() {
		return log;
	}
	private static final Logger log = LoggerFactory.getLogger(UserLog.class);
	public static void main(String[] args) {
		UserLog userLog = new UserLog();
		userLog.setName(null);
		log.info(" name属性可以为空 "+userLog.getName());
		
	}

}
