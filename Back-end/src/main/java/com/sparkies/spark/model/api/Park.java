package com.sparkies.spark.model.api;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="park")
public class Park {
	
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="Free")
	private Integer free;
	@XmlElement(name="Total")
	private Integer total;
	
	public String getName() {
		return this.name;
	}
	
	public Integer getFree() {
		return free;
	}
	
	public Integer getTotal() {
		return total;
	}
}
