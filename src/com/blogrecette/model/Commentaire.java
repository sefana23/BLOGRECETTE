/**
 * 
 */
package com.blogrecette.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "commentaire")
public class Commentaire {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "auteur")
    private String auteur;
     
    @Column(name="contenu")
    private String contenu;
    
   
    @Column(name="note")
    private int note;
     
    @Temporal(value=TemporalType.DATE)
    @Column
	private Date dateCreation;
    
    @ManyToOne 
    private Recette recette;
    
    public Recette getRecette() {
		return recette;
	}



	public void setRecette(Recette recette) {
		this.recette = recette;
		recette.addCommentaire(this);

	}
    
    public Commentaire() {
    }



	/**
	 * @param id
	 * @param idRecette
	 * @param auteur
	 * @param contenu
	 * @param note
	 * @param dateCreation
	 */
	public Commentaire(String auteur, String contenu,  Date dateCreation, Recette recette) {
		super();
		this.auteur = auteur;
		this.contenu = contenu;
		this.dateCreation = dateCreation;
	}



	/**
	 * @param idRecette
	 * @param auteur
	 * @param contenu
	 * @param note
	 * @param dateCreation
	 */
	public Commentaire( String auteur, String contenu, Date dateCreation) {
		super();
	
		this.auteur = auteur;
		this.contenu = contenu;
		this.dateCreation = dateCreation;
	}
	
	public Commentaire( String auteur, String contenu,int note, Date dateCreation) {
		super();
	
		this.auteur = auteur;
		this.contenu = contenu;
		this.note = note;
		this.dateCreation = dateCreation;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public int getNote() {
		return note;
	}



	public void setNote(int note) {
		this.note = note;
	}


	public Date getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	@Override
	public String toString() {
		return "Commentaire [id=" + id +  ", auteur=" + auteur + ", contenu=" + contenu
				+ ", note=" + note + ", dateCreation=" + dateCreation + "]";
	}
    
    
    
    
}
