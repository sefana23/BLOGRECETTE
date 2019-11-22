package com.blogrecette.model;



import java.util.Collection;

import javax.persistence.*;

@Entity

public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;


	@Column
	private String nom;


	public Tag() {
		super();
	}

	
	public Tag(String nom,Recette recette) {
		super();
		this.nom = nom;

	}
	
	public Tag(String nom) {
		super();
		this.nom = nom;

	}


	public String getNom() {
		return nom;

	}



	public void setNom(String nom) {
		this.nom = nom;

	}

	

	public int getId() {
		return id;

	}



	@Override
	public String toString() {
		return "Tag [id=" + id + ", nom=" + nom + "]";
	}

	

	

}