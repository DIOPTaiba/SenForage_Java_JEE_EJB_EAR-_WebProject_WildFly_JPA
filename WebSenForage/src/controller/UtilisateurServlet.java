package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IUtilisateurLocal;
import com.entities.Utilisateur;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/Utilisateur")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB
    private IUtilisateurLocal utilisateurdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*Utilisateur u = new Utilisateur();
		u.setIdUser("MD100");
		u.setNom("DIOP");
		u.setPrenom("Mor");
		u.setEmail("mor@gmail.com");
		u.setPassword("passer");
		u.setUrlPhoto("/public/");
		
		utilisateurdao.add(u);
		*/
		request.setAttribute("utilisateurs", utilisateurdao.listUtilisateur());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String idUser = request.getParameter("idUser").toString();
        String nom = request.getParameter("nom").toString();
        String prenom = request.getParameter("prenom").toString();
        String email = request.getParameter("email").toString();
        String password = request.getParameter("password").toString();
        String urlPhoto = request.getParameter("urlPhoto").toString();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser(idUser);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);
        utilisateur.setUrlPhoto(urlPhoto);

        int ok = utilisateurdao.add(utilisateur);
        //resp.getWriter().println(ok);
        request.setAttribute("resultat", ok);
        doGet(request, response);
	}

}
