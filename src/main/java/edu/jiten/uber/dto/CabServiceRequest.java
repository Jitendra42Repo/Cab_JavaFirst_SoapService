package edu.jiten.uber.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cabServiceRequest")
public class CabServiceRequest {
	
	@XmlElement(name = "ride")
	private Ride ride;
	
	@XmlElement(name = "cabReserve", required = true)
	private CabReserve cabRequestStatus;

	public CabReserve getCabRequestStatus() {
		return cabRequestStatus;
	}

	public void setCabRequestStatus(CabReserve cabRequestStatus) {
		this.cabRequestStatus = cabRequestStatus;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	

}
