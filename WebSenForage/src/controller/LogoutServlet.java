package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//import java.io.PrintWriter;

@WebServlet(value = "/Logout", name = "logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //PrintWriter out = resp.getWriter();
        //out.println("thanq you!!, Your session was destroyed successfully!!");
        HttpSession session = req.getSession(false);
        //session.setAttribute("prenom", null);
        //session.invalidate();
        session.removeAttribute("user");
        session.getMaxInactiveInterval();
        //resp.sendRedirect("index.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
