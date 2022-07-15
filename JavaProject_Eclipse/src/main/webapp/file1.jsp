<%-- 
    Document   : index
    Created on : 29 jun 2022, 13:14:36
    Author     : Dailu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dailu.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%-- Esto es un comentario --%>
        <h1>Aguante Javaaa!</h1>
        
         

<p>
Id Empleado: <%=request.getParameter("nombre")%>
ResultadoMultiplicacion <%= 9* 9%>
</p>


    <table>
    <tr>
        <th>ID Empleado</th>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Num Depto</th>
    </tr>
  
  <%
  try{
	  EmpleadosQuery empleadosQuery = new EmpleadosQuery();
  ResultSet searchResult = null;
  String idEmpleado = request.getParameter("nombre");
   
while(searchResult.next()){
	 %>
	    <tr>
	        <td><%= searchResult.getInt("idEmpleado") %></td>
	        <td><%= searchResult.getInt("DNI") %></td>
	        <td><%= searchResult.getString("nombre") %></td>
	        <td><%= searchResult.getString("apellido") %></td>
	        <td><%= searchResult.getInt("numeroDepartamento") %></td>
	    </tr>
	<%
}
	  
  }catch(Exception error){
	  error.printStackTrace();
  }
  
  %>



</table>  
       
            
    </body>
</html>
