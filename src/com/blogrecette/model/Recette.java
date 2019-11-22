package com.blogrecette.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
 
@Entity
@Table(name = "recette")
public class Recette {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

     
    @Column(name = "titre")
    private String titre;
     
    @Column(name="description")
    private String description;
    
   
    @Column(name="photo")
    private String photo;
     
    @Temporal(TemporalType.DATE)
    protected Date dateCreation;

    @Transient
	private int moyenneNote;
    
  

    @OneToMany(mappedBy = "recette",fetch = FetchType.EAGER)
    private Collection <Commentaire>commentaires;
    
    public Collection<Commentaire> getCommentaires(){
		return commentaires;
	}

	
	public Collection<Commentaire> addCommentaire(Commentaire commentaire){
		commentaires.add(commentaire);
		return commentaires;
	}

	

	public Collection<Commentaire> removeCommentaire(Commentaire commentaire){
		commentaires.remove(commentaire);
		return commentaires;

	}


    
    @OneToMany(mappedBy = "recette")
    private Collection <Ingredient>ingredients;
    
    public Collection<Ingredient> getIngredients(){
		return ingredients;

	}

	public Collection<Ingredient> addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
		return ingredients;
	}

	
	public Collection<Ingredient> removeIngredient(Ingredient ingredient){
		ingredients.remove(ingredient);
		return ingredients;

	}
    
    
    
    @ManyToOne
    private Categorie categorie;
    
    public Categorie getCategorie() {
    	return categorie;
	}

    public void setCategorie(Categorie categorie) {
    	this.categorie = categorie;
    }
    
 



	public Recette() {
		commentaires = new ArrayList<Commentaire>();
		ingredients = new ArrayList<Ingredient>();
	
	}
	
	
	public Recette(int idCategorie, String titre, String description, String photo, Date dateCreation) {

		this.titre = titre;
		this.description = description;
		this.photo = photo;
		this.dateCreation = dateCreation;
		commentaires = new ArrayList<Commentaire>();
		ingredients = new ArrayList<Ingredient>();
	}

	
	public Recette(String titre, String description, String photo, Date date) {
		this.titre = titre;
		this.description = description;
		this.photo = photo;
		this.dateCreation = date;
		commentaires = new ArrayList<Commentaire>();
		ingredients = new ArrayList<Ingredient>();
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public int getMoyenneNote() {
		return moyenneNote;

	}

	public void setMoyenneNote(int moyenneNote) {
		this.moyenneNote = moyenneNote;
	}
	
	@Override
	public String toString() {
		return "Recette [id=" + id +  ", titre=" + titre
				+ ", descritption=" + description + ", photo=" + photo + ", dateCreation=" + dateCreation + "]";
	}
    
    
}