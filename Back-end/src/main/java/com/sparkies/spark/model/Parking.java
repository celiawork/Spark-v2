package com.sparkies.spark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

/**
 * Address Entity for SQL table 'PARKING'
 */
@Entity
@Table(name = "PARKING")
public class Parking {

	/**
	 * Unique 'id' formatted as following : [CodePostal(5chiffres)]_[Nom Parking en
	 * 6 lettres MAX] id : "id_parking" type : String - Max length of 15 'car' &&
	 * not NULL
	 */
	@Id
	@Column(name = "id_parking", length = 15, nullable = false) // String ID
	@JsonProperty("id")
	private String idParking;

	/**
	 * 'name' -> 'nom' type : String - Max length of 50 'car' && not NULL
	 */
	@Column(name = "nom", length = 50, nullable = false)
	@JsonProperty("nom")
	private String name;

	/**
	 * Nb de places de parkings libres
	 */
	@Transient
	private Integer freeCapacity;

	/**
	 * informative address - display only 'addressInfo' -> 'adresse_info' type :
	 * String - Max length of 50 'car' && not NULL
	 */
	@Column(name = "adresse_info", length = 50, nullable = false)
	@JsonProperty("adresse")
	private String addressInfo;

	/**
	 * Return if the park as free cost true if park as free cost 'asFreeCost' ->
	 * 'gratuit' type : Boolean && not NULL
	 */
	@Column(name = "gratuit", nullable = false)
	@JsonProperty("gratuit")
	private boolean asFreeCost;

	/**
	 * Total number of spaces 'nbPlaces' -> 'nb_places' type : Int && not NULL
	 */
	@Column(name = "nb_places", nullable = false)
	@JsonProperty("nb_places")
	private int nbPlaces;

	/**
	 * Number of 'PMR' spaces Allow to display number of 'PMR spaces' ou define if
	 * they exist (!= 0 || != NULL) 'nbPMR' -> 'nb_pmr' type : Int && nullable
	 */
	@Column(name = "nb_pmr", nullable = true)
	@JsonProperty("nb_pmr")
	private int nbPMR;

	/**
	 * Number of 'velo' spaces 'nbVelo' -> 'nb_velo' type : Int && nullable
	 */
	@Column(name = "nb_velo", nullable = true)
	@JsonProperty("nb_velo")
	private int nbVelo;

	/**
	 * Number of 'Moto' spaces ("2 roues motorisés") 'nb2RM' -> 'nb_2_rm' type : Int
	 * && nullable
	 */
	@Column(name = "nb_2_rm", nullable = true)
	@JsonProperty("nb_2_rm")
	private int nb2RM;

	/**
	 * Max Height (usable for filter result on specified 'vehicles' height)
	 * 'maxHeight' -> 'hauteur_max' type : Int && Nullable
	 */
	@Column(name = "hauteur_max", nullable = true)
	@JsonProperty("hauteur_ma")
	private String maxHeight;

	/**
	 * Park 'longitude' 'Xlong' 'xLong' -> 'Xlong' type : long && not NULL
	 */
	@Column(name = "Xlong", nullable = false)
	@JsonProperty("Xlong")
	@JsonSerialize(as = Double.class)
	private double xLong;

	/**
	 * Park 'longitude' 'Ylat' 'yLat' -> 'Ylat' type : long && not NULL
	 */
	@Column(name = "Ylat", nullable = false)
	@JsonProperty("Ylat")
	@JsonSerialize(as = Double.class)
	private double yLat;

	/**
	 * Kind of structure ('ouvrage' or 'enclos en surface') 'structType' ->
	 * 'type_ouvra' type : String - Max length of 50 'car' && Nullable
	 */
	@Column(name = "type_ouvra", length = 50, nullable = true)
	@JsonProperty("type_ouvra")
	private String structType;

	/**
	 * Kind of usage ('centre-ville', 'proximité', 'parc relais') 'functionType' ->
	 * 'typo_fonct' type : String - Max length of 50 'car' && Nullable
	 */
	@Column(name = "type_fonct", length = 50, nullable = true)
	@JsonProperty("typo_fonct")
	private String functionType;

	/**
	 * Number of levels 'nbLevel' -> 'nbre_niv' type : Int - Max lenght 11 &&
	 * Nullable
	 */
	@Column(name = "nbre_niv", length = 11, nullable = true)
	@JsonProperty("nbre_niv")
	private int nbLevel;

	/**
	 * Number of public spaces 'nbPub' -> 'places_pub' type : Int - Max lenght 11 &&
	 * Nullable
	 */
	@Column(name = "places_pub", length = 11, nullable = true)
	@JsonProperty("places_pub")
	private int nbPub;

	/**
	 * url vers l'APÏ parking
	 */
	@Column(name = "url_api", nullable = false)
	@JsonProperty("url_api")
	private String apiUrl;

	/**
	 * Number of residential spaces 'NbRes' -> 'places_res' type : Int - Max lenght
	 * 11 && Nullable
	 */
	@Column(name = "places_res", length = 11, nullable = true)
	@JsonProperty("places_res")
	private int NbRes;

	/**
	 * Personal and 'Favorites' address
	 */
	@ManyToOne
	@JoinColumn(name = "id_adress")
	private Address parkingAddress;

	public Parking(Parking parking) {
		this.idParking = parking.idParking;
		this.name = parking.name;
		this.addressInfo = parking.addressInfo;
		this.asFreeCost = parking.asFreeCost;
		this.nbPlaces = parking.nbPlaces;
		this.nbPMR = parking.nbPMR;
		this.nbVelo = parking.nbVelo;
		this.nb2RM = parking.nb2RM;
		this.maxHeight = parking.maxHeight;
		this.xLong = parking.xLong;
		this.yLat = parking.yLat;
		this.structType = parking.structType;
		this.functionType = parking.functionType;
		this.nbLevel = parking.nbLevel;
		this.nbPub = parking.nbPub;
		this.NbRes = parking.NbRes;
		this.apiUrl = parking.apiUrl;
	}

	public Parking() {
	
	}

	public String getIdParking() {
		return idParking;
	}

	public void setIdParking(String idParking) {
		this.idParking = idParking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public boolean isAsFreeCost() {
		return asFreeCost;
	}

	public void setAsFreeCost(boolean asFreeCost) {
		this.asFreeCost = asFreeCost;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getNbPMR() {
		return nbPMR;
	}

	public void setNbPMR(int nbPMR) {
		this.nbPMR = nbPMR;
	}

	public int getNbVelo() {
		return nbVelo;
	}

	public void setNbVelo(int nbVelo) {
		this.nbVelo = nbVelo;
	}

	public int getNb2RM() {
		return nb2RM;
	}

	public void setNb2RM(int nb2RM) {
		this.nb2RM = nb2RM;
	}

	public String getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	public double getxLong() {
		return xLong;
	}

	public void setxLong(double xLong) {
		this.xLong = xLong;
	}

	public double getyLat() {
		return yLat;
	}

	public void setyLat(double yLat) {
		this.yLat = yLat;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getStructType() {
		return structType;
	}

	public void setStructType(String structType) {
		this.structType = structType;
	}

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public int getNbLevel() {
		return nbLevel;
	}

	public void setNbLevel(int nbLevel) {
		this.nbLevel = nbLevel;
	}

	public int getNbPub() {
		return nbPub;
	}

	public void setNbPub(int nbPub) {
		this.nbPub = nbPub;
	}

	public int getNbRes() {
		return NbRes;
	}

	public void setNbRes(int nbRes) {
		NbRes = nbRes;
	}

	public Address getParkingAddress() {
		return parkingAddress;
	}

	public void setParkingAddress(Address parkingAddress) {
		this.parkingAddress = parkingAddress;
	}

	public Integer getFreeCapacity() {
		return freeCapacity;
	}

	public void setFreeCapacity(Integer freeCapacity) {
		this.freeCapacity = freeCapacity;
	}

	@Override
	public String toString() {
		return "Parking{" + "idParking='" + idParking + '\'' + ", name='" + name + '\'' + ", freeCapacity="
				+ freeCapacity + ", addressInfo='" + addressInfo + '\'' + ", asFreeCost=" + asFreeCost + ", nbPlaces="
				+ nbPlaces + ", nbPMR=" + nbPMR + ", nbVelo=" + nbVelo + ", nb2RM=" + nb2RM + ", maxHeight='"
				+ maxHeight + '\'' + ", xLong=" + xLong + ", yLat=" + yLat + ", apiUrl='" + apiUrl + '\''
				+ ", structType='" + structType + '\'' + ", functionType='" + functionType + '\'' + ", nbLevel="
				+ nbLevel + ", nbPub=" + nbPub + ", NbRes=" + NbRes +

				'}';
	}
}
