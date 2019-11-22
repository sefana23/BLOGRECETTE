/**
 * 
 */
package com.blogrecette.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "categorie")
public class Categorie {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
     
    @Column(name = "titre")
    private String nom;
    
    @OneToMany(mappedBy = "categorie")
    private Collection<Recette> recettes;
    
    public Collection<Recette> getRecette(){

		return this.recettes;
	}

    public Collection<Recette> addRecette(Recette recette) {
    	recettes.add(recette);	
    	return recettes;
    }
    public Collection<Recette> removeRecette(Recette recette) {
    	recettes.remove(recette);
    	return recettes;
    }
    public Categorie() {
    	recettes= new ArrayList<Recette>();
    }



	/**
	 * @param id
	 * @param nom
	 */
	public Categorie(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	/**
	 * @param nom
	 */
	public Categorie(String nom) {
		super();
		this.nom = nom;
		recettes= new ArrayList<Recette>();
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}
    
    
}