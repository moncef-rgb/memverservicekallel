package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Member {
	
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String diplome;
	

	
	@ManyToOne
	private EnseignantChercheur encadrant;

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String cin, String nom, String prenom, Date date, byte[] photo, String cv, String email,
			String password, Date dateInscription, String diplome, EnseignantChercheur encadrant) {
		super(cin, nom, prenom, date, photo, cv, email, password);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.encadrant=encadrant;
	}

}
