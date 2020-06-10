package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	private String documment;
	
	public ErrorMessage(String errorMessage, int errorCode, String documment) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documment = documment;
	}

	public ErrorMessage() {
		super();
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the documment
	 */
	public String getDocumment() {
		return documment;
	}

	/**
	 * @param documment the documment to set
	 */
	public void setDocumment(String documment) {
		this.documment = documment;
	}
}

