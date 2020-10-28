package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//import java.io.PrintWriter;

@WebServlet(urlPatterns="/Logout", name="logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


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
        //PrintWriter out = resp.getWriter();
        //out.println("thanq you!!, Your session was destroyed successfully!!");
        HttpSession session = req.getSession(false);
        //session.setAttribute("prenom", null);
        //session.invalidate();
        session.removeAttribute("user");
        //resp.sendRedirect("index.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
