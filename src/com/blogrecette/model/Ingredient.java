/**
 * 
 */
package com.blogrecette.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "ingredient")
public class Ingredient {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    
    @Column(name = "nom")
    private String nomIngredient;
     
    @Column(name="quantite")
    private double quantite;
    
   
    @Column(name="unit")
    private String unit;
     
    @ManyToOne
    private Recette recette;
    
    public Recette getRecette() {

	return recette;

	}


	public void setRecette(Recette recette) {

		this.recette = recette;

	}
    
    public Ingredient() {
    }


    public Ingredient(int idIngredient, int idRecette, String nomIngredient, int quantite, String unit) {

		super();

		this.nomIngredient = nomIngredient;

		this.quantite = quantite;

		this.unit = unit;

	}
    public Ingredient(int idRecette, String nomIngredient, int quantite, String unit) {

		super();
		this.nomIngredient = nomIngredient;
		this.quantite = quantite;
		this.unit = unit;

	}


	public Ingredient(String nomIngredient, int quantite, String unit) {

		this.nomIngredient = nomIngredient;

		this.unit = unit;

		this.quantite = quantite;

	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	public String getNomIngredient() {
		return nomIngredient;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}



	/**
	 * @return the quantite
	 */
	public double getQuantite() {
		return quantite;
	}



	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}



	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}



	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}



	@Override
	public String toString() {
		return "Ingredient [id=" + id + ",  nom=" + nomIngredient + ", quantite=" + quantite
				+ ", unit=" + unit + "]";
	}
    
    
    
}
