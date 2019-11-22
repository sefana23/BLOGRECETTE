/**
 * 
 */
package  com.blogrecette.services;


import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogrecette.model.Recette;
import com.blogrecette.model.Tag;
import com.blogrecette.utils.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.Select;



/**
 * @author HB
 *
 */


public class RecetteService {
	public  RecetteService() {

	}

	public Recette createRecette(Recette recette) throws Exception {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (recette != null) {
				session.save(recette);  
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 

			e.printStackTrace();
		}  
		return recette;

	}


	public Recette updateRecette (Recette recette) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (recette != null) {
				session.update(recette); 
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return recette;
	}






	public void  deleteRecette(Recette recette) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (recette != null) {
				session.delete(recette);  
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
	}


	public Recette getRecetteFromId(int id) throws Exception { 

		Recette recette = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			recette = session.get(Recette.class, id);

		} catch (Exception e) {

			e.printStackTrace();
		} 
		recette.setMoyenneNote(this.moyNoteRecetteByRecette(recette.getId()));
		return recette; 
	}



	public ArrayList<Recette> getRecetteByCategorie(int idCategorie) throws Exception {    //recupère toute les recettes par categorie

		ArrayList<Recette> allRecettes = new ArrayList<Recette>();

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql= "SELECT r FROM Recette r JOIN r.categorie c"
					+ "WHERE c.id= :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idCategorie);
			allRecettes=(ArrayList<Recette>)query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();

		}
		for (Recette recette : allRecettes) {

			recette.setMoyenneNote(this.moyNoteRecetteByRecette(recette.getId()));

		}
		return allRecettes;

	}

	public ArrayList<Recette> getAllRecettes() throws Exception { 
		ArrayList < Recette > allRecettes = new ArrayList<Recette>();  
		try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
			String hql="FROM Recette";
			Query query= session.createQuery(hql);
			allRecettes=(ArrayList<Recette>)query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();

		}
		for (Recette recette : allRecettes) {

			recette.setMoyenneNote(this.moyNoteRecetteByRecette(recette.getId()));

		}
		return allRecettes;
	}






	public ArrayList<Recette> getRecetteByTag(int idTag) throws Exception {    //recupère toute les recettes par tag
		
		ArrayList<Recette> allTags = new ArrayList<Recette>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT r FROM Recette r "
					+ "JOIN r.tag t"
					+ "WHERE t.id =:id";
			Query query = session.createQuery(hql);

			 query.setParameter("id", idTag);
			 allTags = (ArrayList<Recette>) query.getResultList();
			 
		} catch (Exception e) {
			e.printStackTrace();
		

		}

		return allTags;


	}




	public int moyNoteRecetteByRecette (int idRecette) {

		int note = 0;

		//On prepare le requette HQL
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "Select floor (avg (c.note))"
					+ " From recette r join r.commentaires c "
					+ "where r.id = :id ";
			Query query = session.createQuery(hql);
			query.setParameter("id", idRecette);
			note=(int) query.getSingleResult();
		} catch (Exception e) {

			note = 0;

		}


		return note;

	}





}