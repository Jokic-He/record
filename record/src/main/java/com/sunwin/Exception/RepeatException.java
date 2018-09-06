package com.sunwin.Exception;

public class RepeatException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepeatException(){
		super();
	}
	
	public RepeatException(String message,Throwable cause){
		super(message,cause);
	}
	
	public RepeatException(String message){
		super(message);
	}
	
	public RepeatException(Throwable cause){
		super(cause);
	}

}
