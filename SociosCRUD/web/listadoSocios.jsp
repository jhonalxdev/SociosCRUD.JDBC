<%-- 
    Document   : listadoSocios
    Created on : 28/12/2017, 06:16:14 PM
    Author     : Jhon Alex
--%>

<%@page import="conn.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTADO SOCIOS</title>
    </head>
    <body>
        <h1>Listado de personas registradas como socios</h1>
        
        
        <% 
            /* Rc: copiar los import tal cual  */
// 		Class.forName("com.mysql.jdbc.Driver"); 
//                String url = "jdbc:mysql://localhost:3306/baloncesto";
//                String login = "alex"; 
//                String pass = "alex";
//                
// 		Connection conexion = DriverManager.getConnection(url, login, pass);
                
                DbConnection conexion = new DbConnection ();
//              Statement s = bdc.getConnectionBD().createStatement();  
//		ResultSet listado = s.executeQuery ("SELECT * FROM socio"); 

		ResultSet listado = conexion.listadoTabla("socio");
		 
		while (listado.next()) { 
	        out.println(listado.getString("socioID") + " " + listado.getString ("nombre") + "<br>"); 
                } 
 		 
		conexion.desconectar();

	%>  

        
        
        
    </body>
</html>
