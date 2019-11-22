package com.blogrecette.tests;



import static org.junit.Assert.*;



import org.hibernate.SessionFactory;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;



import com.blogrecette.model.Ingredient;

import com.blogrecette.services.IngredientService;

import com.blogrecette.utils.HibernateUtil;



import junit.framework.TestCase;

import junit.framework.TestSuite;



import java.sql.Connection;

import java.sql.SQLException;

import java.util.Date;

import java.util.List;



public class TestIngredientService extends TestCase {

	

	private static SessionFactory sessionFactory = null;

	private static IngredientService ingredientService = null;

	private static Ingredient ingredientTest = null;

	

	public TestIngredientService(){

		

	}

	

	public TestIngredientService(String testName){

		super(testName);

		



		

	}

	

	@Before

	public void setUp() throws Exception {

		

		sessionFactory = HibernateUtil.getSessionFactory();

		ingredientService = new IngredientService();

		

		if (ingredientTest == null) {

		ingredientTest = new Ingredient("sel", 1, "g" );

		}

	}



	@After

	public void tearDown() throws Exception {

		

		

	}



	@Test

	public void testCreateIngredient() throws Exception {



		// action

		ingredientTest = ingredientService.addIngredient(ingredientTest);

		Ingredient ingredientCree = ingredientService.getIngredientFromId(ingredientTest.getId());

				

		// assert

		assertNotEquals((long)0, (long)ingredientTest.getId());

		assertEquals(ingredientTest.getNomIngredient(),ingredientCree.getNomIngredient());

		assertEquals(ingredientTest.getQuantite(), ingredientCree.getQuantite());

		assertEquals(ingredientTest.getUnit(), ingredientCree.getUnit());



		

	}

	

	@Test

	public void testGetIngredientFromId() throws Exception {



		// action

		

		Ingredient ingredientFromId = ingredientService.getIngredientFromId(ingredientTest.getId());

				

		// assert

		

		assertEquals(ingredientFromId.getNomIngredient(), ingredientTest.getNomIngredient());

		assertEquals(ingredientFromId.getQuantite(), ingredientTest.getQuantite());

		assertEquals(ingredientFromId.getUnit(), ingredientTest.getUnit());



		

	}

	

	@Test

	public void testGetAllIngredients() throws Exception {



		// action

		List <Ingredient> ingredients = ingredientService.getAllIngredients();

				

		// assert

		assertEquals(ingredients.size(), 3);

		

	}

	

	

	@Test

	public void testUpdateIngredient() throws Exception{

		

		//Creer un jeu de tests (arrange)

		Date newDate = new Date("2019/11/04");

		

		

		

		ingredientTest.setNomIngredient("poivre");

		ingredientTest.setQuantite(2);

		ingredientTest.setUnit("cc");

		

		

		// action

		ingredientService.updateIngredient(ingredientTest);

		Ingredient ingredientUpdate = ingredientService.getIngredientFromId(ingredientTest.getId());

		

		// assert

		

		assertEquals(ingredientUpdate.getNomIngredient(), ingredientTest.getNomIngredient());

		assertEquals(ingredientUpdate.getQuantite(), ingredientTest.getQuantite());

		assertEquals(ingredientUpdate.getUnit(), ingredientTest.getUnit());



	}

	

	@Test

	public void testDeleteIngredient() throws Exception {

		

		//Creer un jeu de tests (arrange)

		ingredientService.deleteIngredient(ingredientTest);

		ingredientTest = ingredientService.getIngredientFromId(ingredientTest.getId());

		

		// assert

		assertNull(ingredientTest);

		

	}

	

	public static junit.framework.Test suite() {

		

		TestSuite suite = new TestSuite("Suite TestIngredientService");

		

		suite.addTest(new TestIngredientService("testCreateIngredient"));

		suite.addTest(new TestIngredientService("testGetIngredientFromId"));	

		suite.addTest(new TestIngredientService("testUpdateIngredient"));	

		suite.addTest(new TestIngredientService("testGetAllIngredients"));

		suite.addTest(new TestIngredientService("testDeleteIngredient"));

		

		return suite;

	}



}