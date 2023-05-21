package com.sparkies.spark.model;

import javax.persistence.*;

@Entity
@Table
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicle")
	private Long idVehicle;

	private double consomation;

	@ManyToOne
	@JoinColumn(name = "id_energy")
	private Energy energy;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private AppUser vehicleUser;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_vehicle", columnDefinition = "enum('moto','voiture')")
	private TypeVehicle typeVehicle;

	public Vehicle() {

	}

	public Vehicle(double consomation) {
		super();
		this.consomation = consomation;
	}

	public Vehicle(double consomation, Energy energy, TypeVehicle typeVehicle) {
		super();
		this.consomation = consomation;
		this.energy = energy;
		this.typeVehicle = typeVehicle;
	}

	public Vehicle(Long idVehicle, double consomation, TypeVehicle typeVehicle) {
		super();
		this.idVehicle = idVehicle;
		this.consomation = consomation;
		this.typeVehicle = typeVehicle;
	}

	public Vehicle(double consomation, Energy energy, AppUser vehicleUser, TypeVehicle typeVehicle) {
		super();
		this.consomation = consomation;
		this.energy = energy;
		this.vehicleUser = vehicleUser;
		this.typeVehicle = typeVehicle;
	}

	public Long getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}

	public double getConsomation() {
		return consomation;
	}

	public void setConsomation(double consomation) {
		this.consomation = consomation;
	}

	public Energy getEnergy() {
		return energy;
	}

	public void setEnergy(Energy energy) {
		this.energy = energy;
	}

	public AppUser getVehicleUser() {
		return vehicleUser;
	}

	public void setVehicleUser(AppUser vehicleUser) {
		this.vehicleUser = vehicleUser;
	}

	public TypeVehicle getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(TypeVehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

}
