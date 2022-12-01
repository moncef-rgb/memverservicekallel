package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member{
	
	private String grade;
	private String etablissement;
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public EnseignantChercheur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnseignantChercheur(String cin, String nom, String prenom, Date date, byte[] photo, String cv, String email,
			String password, String grade, String etablissement) {
		super(cin, nom, prenom, date, photo, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}
	
	
	

}
