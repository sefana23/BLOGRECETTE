/**
 * 
 */
package com.blogrecette.model;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import com.blogrecette.services.MembreService;

@Entity //gerer par hibernate
@Table(name = "membre")
public class Membre {

	@Id // CLE PRIMAIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENTE
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name="pseudo")
	private String pseudo;


	@Column(name="email")
	private String email;

	@Temporal(TemporalType.DATE)
	protected Date dateInscription;


	@Column(name="mdp")
	private String mdp;


	//@OneToOne(optional = false)
//	protected Cni cni;

	
	@OneToOne(mappedBy="membre")
	protected Cni cni;

	
    @OneToMany
    @JoinColumn(name = "idMembre")//BI DIRECTIONNEL permet d'avoir l'id que d'un coté
    private Collection <Recette> recettes;



	public Collection<Recette> getRecettes(){
		return recettes;
		}
	
    public Collection<Recette> addRecette(Recette recette) {
		recettes.add(recette);
		return recettes;
	}
	
	public Collection<Recette> removeRecette(Recette recette) {
		recettes.remove(recette);
		return recettes;
	}
	
	
	public Membre() {
		recettes = new ArrayList<Recette>();
	}
	

	public Membre(String nom, String pseudo, String email, Date dateInscription, String mdp) {
		super();
		this.nom = nom;
		this.pseudo = pseudo;
		this.email = email;
		this.dateInscription = dateInscription;
		this.mdp = mdp;
		recettes = new ArrayList<Recette>();

	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



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


	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the dateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}


	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}


	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public Cni getCni() {
		return cni;
	}
	public void setCni(Cni cni) {
		this.cni = cni;
	}
	
	



	
	
	
	
	@Override
	public String toString() {
		return "Membre [id=" + id + ", nom=" + nom + ", pseudo=" + pseudo + ", email=" + email + ", dateInscription="
				+ dateInscription + ", mdp=" + mdp + "]";
	}



}

