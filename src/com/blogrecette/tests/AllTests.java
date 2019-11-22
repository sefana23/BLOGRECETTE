package com.blogrecette.tests;
import org.junit.runner.RunWith;

import org.junit.runners.Suite;

import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)

@SuiteClasses({ TestCommentaireService.class, TestIngredientService.class, TestMembreService.class,

		TestRecetteService.class })

public class AllTests {

}
