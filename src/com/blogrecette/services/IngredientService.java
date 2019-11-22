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
import com.blogrecette.model.Ingredient;
import com.blogrecette.utils.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.Select;



/**
 * @author HB
 *
 */
public class IngredientService {
public  IngredientService() {
		
	}

	public Ingredient addIngredient(Ingredient ingredient) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (ingredient != null) {
				session.save(ingredient);  
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return ingredient;
	}
	
	
	public Ingredient updateIngredient(Ingredient ingredient) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (ingredient != null) {
				session.update(ingredient); 
				session.flush();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		}  
		return ingredient;
	}
	



	public void  deleteIngredient(Ingredient ingredient) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction(); 
			if (ingredient != null) {
				session.delete(ingredient); 
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
	
	
	


	public Ingredient getIngredientFromId(int id) throws Exception { 
		
		Ingredient ingredient = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			ingredient = session.get(Ingredient.class, id);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ingredient; 
	}
	
	
	public ArrayList<Ingredient> selectIngredientByIdRecette(int idRecette) throws Exception {     //selectionne tout les commentaire des recette
        ArrayList<Ingredient> allIngredient = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT i FROM ingredient JOIN i.recette r "
            		+ "WHERE r.id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", idRecette);
            
            allIngredient = (ArrayList<Ingredient>) query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        
        }

        return allIngredient;
	}

	public List<Ingredient> getAllIngredients() {
		ArrayList <Ingredient> allIngredients= null;  
		try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
			String hql = "from Ingredient";
			Query query = session.createQuery(hql);
			allIngredients = (ArrayList<Ingredient>) query.getResultList();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return allIngredients;
	}
	



}
	





