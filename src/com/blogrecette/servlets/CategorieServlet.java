package com.blogrecette.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blogrecette.model.Categorie;
import com.blogrecette.model.Recette;
import com.blogrecette.services.CategorieService;
import com.blogrecette.services.RecetteService;

import com.blogrecette.utils.HibernateUtil;

/**
 * Servlet implementation class Categorie
 */
@WebServlet(name="Categorie", urlPatterns = {"/categorie"})
public class CategorieServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<Categorie> categories =new ArrayList<>();

		ArrayList<Recette> recettesCategorie1 =new ArrayList<>();
		
		try {

		
			CategorieService categorieservice= new CategorieService();

			RecetteService recetteservice = new RecetteService();

			

			categories = categorieservice.selectAllCategorie();

			session.setAttribute("categories", categories);

		

			recettesCategorie1 = recetteservice.getRecetteByCategorie(Integer.parseInt(request.getParameter("idCategorie")));

			session.setAttribute("recettesCategorie1", recettesCategorie1);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 this.getServletContext().getRequestDispatcher( "/WEB-INF/categorie.jsp" ).forward( request, response );
	}

		
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie.jsp").forward(request, response);//Return like
	}

}
