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

import com.blogrecette.model.Membre;
import com.blogrecette.utils.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.Select;



/**
 * @author HB
 *
 */
public class MembreService {

public  MembreService() {
		
	}
	public Membre createMembre(Membre membre) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (membre != null) {
				session.save(membre);  
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return membre;
	}
	
	
	public Membre updateMembre (Membre membre) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (membre != null) {
				session.update(membre); 
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return membre;
	}
	







	public void  deleteMembre(Membre membre) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (membre != null) {
				session.delete(membre);   
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
	}
	
	


	public Membre getMembreFromId(int id) throws Exception { 

		Membre membre = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			membre = session.get(Membre.class, id);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		return membre; 
	}




	public List<Membre> getAllmembres() throws Exception { 
		
		ArrayList <Membre> allMembres= null;  
		try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
			String hql = "from Membre";
			Query query = session.createQuery(hql);
			allMembres = (ArrayList<Membre>) query.getResultList();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return allMembres;
	}

	public Membre selectMembreByPseudoMdp(String pseudo, String mdp) {

		Membre membre = null;

		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			 String hql = "SELECT m FROM Membre m WHERE m.pseudo = :pseudo AND m.mdp = :mdp";

			 Query query = session.createQuery(hql);

			 query.setParameter("pseudo", pseudo);

			 query.setParameter("mdp", mdp);

			 ArrayList<Membre> membres = (ArrayList<Membre>) query.getResultList();

			 if(membres.isEmpty()) {

				 membre = null;

			 } else {

				 membre = membres.get(0);

			 }

			 

		 } catch (Exception e) {

	            e.printStackTrace();

	     }

		return membre;

	}

	
	
	
	
	
	
}
	





