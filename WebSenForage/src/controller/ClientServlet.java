package controller;

import java.io.IOException;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IClientLocal;
import com.dao.IUtilisateurLocal;
import com.dao.IVillageLocal;
import com.entities.Client;
import com.entities.Utilisateur;
import com.entities.Village;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(urlPatterns="/Client", name="client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IClientLocal clientdao;
	@EJB
    private IVillageLocal villagedao;
	@EJB
    private IUtilisateurLocal utilisateurdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getSession().getAttribute("user")==null){
            response.sendRedirect("/WebSenForage/");
        } else{
        	request.setAttribute("clients", clientdao.listClient());
        	request.setAttribute("villages", villagedao.listVillage());
    		request.getRequestDispatcher("WEB-INF/client/add.jsp").forward(request, response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nomFamille = request.getParameter("nomFamille").toString();
        String adresse = request.getParameter("adresse").toString();
        String telephone = request.getParameter("telephone").toString();
        String idvillage = request.getParameter("village").toString();
        Village villageRecu = villagedao.getVillageById(idvillage);

        HttpSession session = request.getSession(true);
        String idUser = (String) session.getAttribute("idUser");
        Utilisateur userRecu = utilisateurdao.getUserById(idUser);

        Client client = new Client();
        client.setNomFamille(nomFamille);
        client.setVillage(villageRecu);
        client.setUtilisateur(userRecu);
        client.setAdresse(adresse);
        client.setNumTel(telephone);


        int ok = clientdao.add(client);
        //resp.getWriter().println(ok);
        request.setAttribute("resultat", ok);
        doGet(request, response);
	}

}
