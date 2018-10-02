<%-- 
    Document   : Registro
    Created on : 1/10/2018, 07:48:18 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="Clases.Usuario" id="Usuario" scope="page"> </jsp:useBean>
<%--<jsp:setProperty name="Contraseña" property="Karol"></jsp:setProperty>
<jsp:getProperty name="Contraseña" property="Usuario_nombre"></jsp:getProperty>--%>
    ${Usuario.setNombre("KAROL")}
    ${Usuario.nombre}
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
