package com.blogrecette.tests;



import static org.junit.Assert.*;



import org.hibernate.SessionFactory;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;



import com.blogrecette.model.Categorie;

import com.blogrecette.services.CategorieService;

import com.blogrecette.utils.HibernateUtil;



import junit.framework.TestCase;

import junit.framework.TestSuite;





import java.sql.SQLException;

import java.util.Date;

import java.util.List;



public class TestCategorieService extends TestCase {

	

	private static SessionFactory sessionFactory = null;

	private static CategorieService categorieService = null;

	private static Categorie categorieTest = null;

	

	public TestCategorieService(){

		

	}

	

	public TestCategorieService(String testName){

		super(testName);

		



		

	}

	

	@Before

	public void setUp() throws Exception {

		

		sessionFactory = HibernateUtil.getSessionFactory();

		categorieService = new CategorieService();

		

		if (categorieTest == null) {

		categorieTest = new Categorie("dessert");
		categorieTest = new Categorie("entree");
		categorieTest = new Categorie("plat");



		}

	}



	@After

	public void tearDown() throws Exception {

		

		

	}



	@Test

	public void testCreateCategorie() throws Exception {

		



		

		// action

		categorieTest = categorieService.createCategorie(categorieTest);

		Categorie categorieCree = categorieService.getCategorieFromId(categorieTest.getId());

				

		// assert

	
		assertNotEquals((long)0,(long)categorieTest.getId());
		assertEquals(categorieTest.getNom(), categorieCree.getNom());

		

		

	}

	

	@Test

	public void testGetCategorieFromId() throws Exception {



		// action

		

		Categorie categorieFromId = categorieService.getCategorieFromId(categorieTest.getId());

				

		// assert

		assertEquals(categorieFromId.getNom(), categorieTest.getNom());

		

		

	}

	

	@Test

	public void testgetAllCategories() throws Exception {



		// action

		List <Categorie> categories = categorieService.selectAllCategorie();

				

		// assert

		assertEquals(categories.size(), 2);

		

	}

	

	

	@Test

	public void testUpdateCategorie() throws Exception{

		

		//Creer un jeu de tests (arrange)

		Date newDate = new Date("2019/11/04");

		

		//membre.setId(4);

		categorieTest.setNom("nom");

		

		

		// action

		categorieService.updateCategorie(categorieTest);

		Categorie categorieUpdate = categorieService.getCategorieFromId(categorieTest.getId());

		

		// assert

		assertEquals(categorieUpdate.getNom(), categorieTest.getNom());



	}

	

	@Test

	public void testDeleteCategorie() throws Exception {

		

		//Creer un jeu de tests (arrange)

		categorieService.deleteCategorie(categorieTest);

		categorieTest = categorieService.getCategorieFromId(categorieTest.getId());

		

		// assert

		assertNull(categorieTest);

		

	}

	

	public static junit.framework.Test suite() {

		

		TestSuite suite = new TestSuite("Suite TestCategorieService");

		

		suite.addTest(new TestCategorieService("testCreateCategorie"));

		//suite.addTest(new TestCategorieService("testGetCategorieFromId"));	

		//suite.addTest(new TestCategorieService("testUpdateCategorie"));	

		//suite.addTest(new TestCategorieService("testgetAllCategories"));

		//suite.addTest(new TestCategorieService("testDeleteCategorie"));

		

		return suite;

	}



}