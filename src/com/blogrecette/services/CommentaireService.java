/**
 * 
 */
package  com.blogrecette.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogrecette.model.Commentaire;
import com.blogrecette.model.Membre;
import com.blogrecette.utils.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.Select;



/**
 * @author HB
 *
 */


public class CommentaireService {

	
	public  CommentaireService() {
		
	}
	public Commentaire createCommentaire(Commentaire commentaire) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (commentaire != null) {
				session.save(commentaire);  
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return commentaire;
	}
	
	
	public Commentaire updateCommentaire(Commentaire commentaire) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (commentaire != null) {
				session.update(commentaire); 
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return commentaire;
	}
	



	public void  deleteCommentaire(Commentaire commentaire) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (commentaire != null) {
				session.remove(commentaire);   
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
	
	}




	public Commentaire getCommentaireFromId(int id) throws Exception { 

		Commentaire commentaire = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			commentaire = session.get(Commentaire.class, id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return commentaire; 
	}




	

	public ArrayList<Commentaire> selectCommentaireByIdRecette(int idRecette) throws Exception {     //selectionne tout les commentaire des recette
  
        ArrayList<Commentaire> allCommentaires  = new ArrayList<Commentaire>();
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "Select c from Commentaire c join c.recette r where r.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", idRecette);
            allCommentaires = (ArrayList<Commentaire>) query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
           
            e.printStackTrace();
        }

        return allCommentaires;


    }

public List<Commentaire> getAllCommentaires() throws Exception { 
		
		ArrayList <Commentaire> allCommentaires= null;  
		try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
			String hql = "from Commentaire";
			Query query = session.createQuery(hql);
			allCommentaires = (ArrayList<Commentaire>) query.getResultList();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return allCommentaires;
	}
	
	
	
	
	
	
}
	





