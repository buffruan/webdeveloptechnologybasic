package moe.kotake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;

@WebServlet(name = "doneServlet", urlPatterns = {"/doneServlet"})
public class doneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public boolean isNumber(String a) {
        if (a == null)
            return false;
        else {
            int i = 0;
            for (i = 0; i < a.length(); i++) {
                if (a.charAt(i) > '9' || a.charAt(i) < 0)
                    return false;
            }
        }
        return true;
    }

    public int changeNumber(String a){
        int temp = 0;
        int i=0;
        for(;i<a.length();i++){
            temp=temp*10+(int)a.charAt(i)-(int)'0';
        }
        return temp;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        if (!isNumber(a) || !isNumber(b)) {
            writer.print("Parameter Wrong!");
        }
        else{
            int _a = changeNumber(a);
            int _b=changeNumber(b);
            _a+=_b;
            writer.print("a + b is "+_a);

        }

    }
}
