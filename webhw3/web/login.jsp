<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = request.getParameter("inputUname");
    String pswd = request.getParameter("inputPswd");
    response.sendRedirect(request.getContextPath()+"/loginServlet?user="+name+"&password="+pswd);
%>


</body>
</html>