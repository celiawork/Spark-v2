package com.sparkies.spark.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * User Entity for SQL table 'U'
 */

@Entity
@DiscriminatorValue("PROFILE")
public class Profile extends AppUser {

	/**
	 * 'GAIN' -> 'NOMBRE_SPARK' Double && not NULL (at least equal to zero)
	 */
	@Column(name = "GAIN")
	private int numberOfGain = 0;

	/**
	 * 'isPMR' -> 'isPMR' Boolean && not NULL
	 */
	@Column(name = "isPMR")
	private Boolean isPMR = false;

	public Profile() {
		super();

	}

	public Profile(Long id, int numberOfGain, Boolean isPMR) {

		super(id);
		this.numberOfGain = numberOfGain;
		this.isPMR = isPMR;
	}

	public int getNumberOfGain() {
		return numberOfGain;
	}

	public void setNumberOfGain(int numberOfGain) {
		this.numberOfGain = numberOfGain;
	}

	public Boolean getIsPMR() {
		return isPMR;
	}

	public void setIsPMR(Boolean isPMR) {
		this.isPMR = isPMR;
	}

	public Profile(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

}