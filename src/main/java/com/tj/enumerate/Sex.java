package com.tj.enumerate;

public enum Sex {
	GENTLEMEN("男性","gentlemen",1),LADY("女性","lady",0);
	
	private String Chinese;
	private String English;
	private Integer code;
	
	private Sex(String Chinese,String English,Integer code){
		this.Chinese=Chinese;
		this.English=English;
		this.code=code;
	}
	
	 public Integer getCode() {
	        return this.code;
	 }

}
