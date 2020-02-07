package com.pfs.project.util;

import org.json.JSONObject;

public class CustomResponse {
	
	public static final int OK = 200;
	public static final int UPDATE = 201; 
	public static final int ERR = 400; 
	public static final int NOT_FOUND = 404; 
	public static final int SERVER_ERR = 500;
	
	private int resCode = 200;
	private String msg;
	private JSONObject body;
	
	public CustomResponse() {
		super();
	}
	
	public CustomResponse(int resCode, String msg, JSONObject body) {
		super();
		this.resCode = resCode;
		this.msg = msg;
		this.body = body;
	}
	
	public int getResCode() {
		return resCode;
	}
	
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getBody() {
		return body;
	}
	
	public void setBody(JSONObject body) {
		this.body = body;
	}
	
}
