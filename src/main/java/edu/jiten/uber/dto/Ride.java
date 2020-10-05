package edu.jiten.uber.dto;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ride")
public class Ride {
	
	@XmlElement(name = "id", required = true)
	private BigInteger id;
	
	@XmlElement(name = "to", required = true)
	private String to;
	
	@XmlElement(name = "from", required = true)
	private String from;
	
	@XmlElement(name = "cost", required = true)
	private Double cost;
	
	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public BigInteger getId() {
		return id;
	}
	
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	
	public String getTo() {
		return to;
	}
	
	
	public void setTo(String to) {
		this.to = to;
	}
	
	
	public String getFrom() {
		return from;
	}
	
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	

}
