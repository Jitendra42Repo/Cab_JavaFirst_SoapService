package edu.jiten.uber.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cabReserve")
public class CabReserve {
	
	@XmlElement(name="cancle")
	private boolean cancle;

	public boolean isCancle() {
		return cancle;
	}

	public void setCancle(boolean status) {
		this.cancle = status;
	}

	
	

}
