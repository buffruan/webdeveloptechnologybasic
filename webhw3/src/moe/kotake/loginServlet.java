package moe.kotake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("user");
        String pswd=request.getParameter("password");
        HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        if(Objects.equals(user,"admin") && Objects.equals(pswd,"123456")){
            session.setAttribute("logedin",1);
            out.print("LOGED IN!");
        }
        else if(session.getAttribute("logedin") == null){
            out.print("WRONG PASSWORD/USERNAME!");
        }
        else if((int)session.getAttribute("logedin") == 1){
            out.print("WRONG PASSWORD/USERNAME!(but already loged in)");
        }
        else{
            session.setAttribute("logedin",0);
            out.print("WRONG PASSWORD/USERNAME!");
        }
    }
}
