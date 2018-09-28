/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class ValidaReg extends HttpServlet {
    String Usuario;
    String Passw;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaReg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaReg at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario= request.getParameter("User");
        Passw= request.getParameter("Contra");
        
        Conexion cone= new Conexion();
        
        if(cone.Con(Usuario, Passw).equals("Oka")){
            String Rol= cone.Rol(Usuario, Passw);
            //Rol= "1";
            
            HttpSession sesion= request.getSession();
            sesion.setAttribute("Usuario", Usuario);
            sesion.setAttribute("contra", Passw);
            sesion.setAttribute("Rol", Rol);
            
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("¡Bienvenido!" + Rol +"<br>");
            out.println("<a href=\"/PracticaBD/Verificar\">Verifica tu Sesion</a>");
            out.println("<a href=\"/PracticaBD/index.html\"> Volver</a><br>");
            out.println("<br></body></html>");
        
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("Cuenta no Valida");
            out.println("<a href=\"/PracticaBD/index.html\"> Volver</a>");
            out.println("<br>");
            out.println("<br></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
