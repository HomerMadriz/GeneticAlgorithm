package org.gava;

@SuppressWarnings("serial")
public class MissingStageException extends RuntimeException {
	
	private String message;
	
	public MissingStageException(String message) {
		this.message = message;
	}
	
	public String toString() {
		return String.format("%s\n%s", super.toString(), this.message);
	}
	
}
