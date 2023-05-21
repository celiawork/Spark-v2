package com.sparkies.spark.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table
public class Zone {

	@Id
	@Column(name="id_zone")
	private Long idZone; 

	@Nullable
	private String name;
	
	private int minute;
	
	
	public Zone() {
		
	}

	public Zone(Long idZone, String name, int minute) {

		this.idZone = idZone;
		this.name = name;
		this.minute = minute;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String name) {
		this.name = name;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Long getIdZone() {
		return idZone;
	}

	public void setIdZone(Long idZone) {
		this.idZone = idZone;
	}
	
	@Override
	public String toString() {
		return "Zone [idZone=" + idZone + ", name=" + name + ", minute=" + minute + "]";
	}
	
}
