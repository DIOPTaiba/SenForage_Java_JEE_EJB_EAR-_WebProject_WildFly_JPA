package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IUtilisateurLocal;
import com.dao.IVillageLocal;
import com.entities.Utilisateur;
import com.entities.Village;

/**
 * Servlet implementation class VillageServlet
 */
@WebServlet("/Village")
public class VillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IVillageLocal villagedao;
	@EJB
    private IUtilisateurLocal utilisateurdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VillageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("villages", villagedao.listVillage());
		request.getRequestDispatcher("/WEB-INF/village/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String idVillage = request.getParameter("idVillage").toString();
        String nomVillage = request.getParameter("nomVillage").toString();

        HttpSession session = request.getSession(true);
        String idUser = (String) session.getAttribute("idUser");
        Utilisateur userRecu = utilisateurdao.getUserById(idUser);

        Village village = new Village();
        village.setIdVillage(idVillage);
        village.setNom(nomVillage);
        village.setUtilisateur(userRecu);


        int ok = villagedao.add(village);
        //resp.getWriter().println(ok);
        request.setAttribute("resultat", ok);
        doGet(request, response);
	}

}
