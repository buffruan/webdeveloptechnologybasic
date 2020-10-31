package moe.kotake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logoutServlet",urlPatterns = {"/logoutServlet"})
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        if(session.getAttribute("logedin")!=null) {
            if((int)session.getAttribute("logedin")==1) {
                session.setAttribute("logedin", 0);
                out.print("LOGED OUT!");
            }
            else{
                out.print("NOT LOGED IN!");
            }
        }
        else{
            out.print("NOT LOGED IN!(no session)");
        }
    }
}
