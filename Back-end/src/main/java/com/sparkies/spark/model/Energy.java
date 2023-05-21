package com.sparkies.spark.model;

import javax.persistence.*;

@Entity
@Table
public class Energy {
	
	/**
     * id : "id_energy"
     * name : name
     * coefficient : coefficient
     */
	
	@Id
	@Column(name="id_energy")
	private Long idEnergy; 
	private String name;
	private double coefficient;
	
	
	public Energy() {
		
	}

	public Energy(String name, double coefficient) {
		super();
		this.name = name;
		this.coefficient = coefficient;
	}


	public Energy(Long idEnergy, String name, double coefficient) {
		super();
		this.idEnergy = idEnergy;
		this.name = name;
		this.coefficient = coefficient;
	}


	public Long getIdEnergy() {
		return idEnergy;
	}


	public void setIdEnergy(Long idEnergy) {
		this.idEnergy = idEnergy;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}


	@Override
	public String toString() {
		return "Energy [idEnergy=" + idEnergy + ", name=" + name + ", coefficient=" + coefficient + "]";
	}
	
	
	
}


