<%-- 
    Document   : index
    Created on : 1/10/2018, 08:10:10 AM
    Author     : Alumno
--%>

<%@page contentType="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            <button name="Boton1">Funciona</button>
        </form>
        <%
            if(request.getParameter("Boton1")!=null){
        %>
        <jsp:forward page="Registro.jsp"></jsp:forward>
        <%
            return;
        }
        %>
                
        
    </body>
</html>
