/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;


/**
 *
 * @author Alumno
 */
public class Conexion {
    String url;
    String User;
    String Pass;
    Connection con;
    Statement sta;
    ResultSet res;
    
    public Conexion(){
        url="jdbc:mysql://localhost/Usuarios";
        User="root";
        Pass="n0m3l0";
    }
    
    public String Con(String nombre, String contra){
        String ok="No";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where usuario='"+nombre+"' and contraseña='"+contra+"';");
            if(res.next()){
                ok="Oka";
            }
            else{
                ok="Falso";
            }
        }
        
        catch(Exception e){
            ok=e.getMessage();
            System.out.println(e.getMessage());
        }
         
        return ok;
    }
    
    
    public String Rol(String Email, String Contra){
        String Rol="No hay rol";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where usuario='"+Email+"' and contraseña='"+Contra+"';");
            if(res.next()){
                Rol=res.getString("idrol");
            }
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
         
        return Rol;
    }
    
    public String Insert(String Usu,String Contra, String Cor, String Nom, String Ap, String Am, String tel, int idrol){
        String ok="No funciona esta cosa";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            sta.executeUpdate("insert into Usuario values('10','"+Usu+"','"+Contra+"','"+Cor+"','"+Nom+"','"+Ap+"','"+Am+"','"+tel+"','"+idrol+"');");
            ok="Usuario Dado de alta";
        }
        
        catch(Exception e){
            ok=e.getMessage();
            System.out.println(e.getMessage());
        }
        return ok;
    }
}

