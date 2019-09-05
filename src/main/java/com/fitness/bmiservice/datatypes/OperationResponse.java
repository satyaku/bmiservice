package com.fitness.bmiservice.datatypes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OperationResponse {
	
	private boolean executed = false;
	private String Message = null;
	
	
	public boolean isExecuted() {
		return executed;
	}
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	@Override
	public String toString() {
		return "OperationResponse [executed=" + executed + ", Message=" + Message + "]";
	}
	
	

}
