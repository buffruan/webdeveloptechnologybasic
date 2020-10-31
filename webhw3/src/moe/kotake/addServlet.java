package moe.kotake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "addServlet",urlPatterns = {"/addServlet"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int loged = 0;
        if(session.getAttribute("logedin")!=null) {
            loged = (Integer) session.getAttribute("logedin");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/login.html");
            return;
        }
        if(loged==0) {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
        else{
            request.getRequestDispatcher("/doneServlet").forward(request,response);
        }
    }
}
