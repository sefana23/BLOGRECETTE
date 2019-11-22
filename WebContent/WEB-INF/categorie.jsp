<%@page import="com.blogrecette.model.Categorie"%>

<%@ include file = 'header.jsp' %>



	<div id="global">

		<div id="categorie">

			<ul>

			<!-- Id et nom de la catégorie

				 Ajouter class="selected" sur le li de la catégorie sélectionnée 

					Faire une boucle pour afficher toutes les catégories. 

					

					

					<li class="selected"><a href="categorie?idCategorie=">Entrée</a></li>					

					<li><a href="categorie?idCategorie=">Plat principal</a></li> -->

					

					

				

				<c:forEach var="categorie" items="${categories}">

               		 <li class="select"><a href="categorie?idCategorie=${categorie.id}">${categorie.nom}</a> 

              				

                	</li>

            	</c:forEach>

			</ul>

		</div>

		

		<article>

		<c:forEach var="recette" items="${recettesCategorie1}"> 

			<header>

				

	

					

					<a href="recette?id=${recette.id}">

					

					

					<h1 class="titreRecette">${recette.titre} </h1>



					

				</a>

				<time>${recette.dateCreation} </time>

					<!-- Date création de la recette -->

					

			</header>

			<p>${recette.description }</p>

				<!-- Description de la recette 

					Faire une boucle pour afficher toutes les recettes de la categories

				-->

				</c:forEach>

		</article>

		

		<hr />

		

	</div>



	<footer id="piedBlog"> Blog réalisé par  </footer>



</body>