package controller;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IUtilisateurLocal;
import com.entities.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/Login", name="login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IUtilisateurLocal utilisateurdao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	if (req.getSession().getAttribute("user")==null){
            resp.sendRedirect("/WebSenForage/");
        } else{
        	req.getRequestDispatcher("accueil.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //Le message à envoyer
        PrintWriter message = resp.getWriter();

        String email = req.getParameter("email").toString();
        String password = req.getParameter("password").toString();

        Utilisateur userRecu = utilisateurdao.getUserByLogin(email, password);

        //doGet(req, resp);
        if (userRecu != null){
        // Si la connexion réuissit on met la session à true
            HttpSession session = req.getSession(true);
        // on recupère le nom et prénom
            session.setAttribute("user", userRecu);
            session.setAttribute("prenom", userRecu.getPrenom());
            session.setAttribute("nom", userRecu.getNom());
            session.setAttribute("urlPhoto", userRecu.getUrlPhoto());
            session.setAttribute("idUser", userRecu.getIdUser());
        //ici on peut déconnecter le user si il reste 60 secondes inactif
            session.setMaxInactiveInterval(60);
            resp.sendRedirect("Accueil");
        }
        else {
        //Si la connexion ne réussit pas on le redirige sur la page authentification
            RequestDispatcher redirige = req.getRequestDispatcher("index.jsp");
            message.println("<font color=red>Login et/ou mot de passe incorrects.</font>");
            redirige.include(req, resp);

        }

    }
}
