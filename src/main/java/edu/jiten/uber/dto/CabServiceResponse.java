package edu.jiten.uber.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "carServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CabServiceResponse {
	
	@XmlElement(name = "processed")
	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
