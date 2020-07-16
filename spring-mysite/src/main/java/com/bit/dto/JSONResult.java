package com.bit.dto;

// DTO(Data Transfer Object)
//	: 데이터 전송 객체
// vo,map : 내부적으로 쓰는 객체?
// dto : 얻어오는 것이 다른곳에서 얻어오면 dto 객체?, 가져오기위한 객체 , 선언만있으면 transfer object라고도 함?

public class JSONResult {
	private String result; 	// "success" or "fail"
	private String message;	// result가 "fail"일 경우 원인 메세지, 정보 (ex-이미 존재하는 이메일입니다)
	private Object data;	// result가 "success"일 때 전달할 데이터 객체
	
	// error와 success 핸들링, 각 메소드 호출에 따라 다르게 생성하여 반환
	public static JSONResult error(String message) {
		return new JSONResult(false, null, message);
	}
	
	public static JSONResult success(Object data) {
		return new JSONResult(true, data, null);
	}
	
	private JSONResult(boolean inSuccess, Object data, String message){
		result = inSuccess ? "success" : "fail" ;
		this.data = data;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
	
}
