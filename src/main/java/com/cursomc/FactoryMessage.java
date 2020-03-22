package com.cursomc;

public  class FactoryMessage {
	
	public static final String generate(String msg, String... params) {
		
		String newMsg = new String(msg);
		
		String paramName;
		
		int index = 0;
		
		for (String paramValue : params) {
			
			paramName =  "{" + index + "}";
			
			newMsg = newMsg.replace(paramName, paramValue);
			
			index++;
		}
		
		return newMsg;
	}

}
