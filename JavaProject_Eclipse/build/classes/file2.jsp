<%-- 
    Document   : index
    Created on : 29 jun 2022, 13:14:36
    Author     : Dailu
--%>

<%@page import="org.apache.catalina.LifecycleState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dailu.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>




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
    

<!-- https://stackoverflow.com/questions/22419386/servlet-send-arraylist-to-jsp-as-request-attribute -->
<% 
List<Empleados> listaEmpleados = (ArrayList<Empleados>) request.getAttribute("lista");
out.println(listaEmpleados.get(0).nombre);

for (int i=0; i<listaEmpleados.size();i++){
	%>
	<tr>
	<td><% out.println(listaEmpleados.get(i).idEmpleado); %></td>
	<td><% out.println(listaEmpleados.get(i).DNI); %></td>
	<td><% out.println(listaEmpleados.get(i).nombre); %></td>
	<td><% out.println(listaEmpleados.get(i).apellido); %></td>
	<td><% out.println(listaEmpleados.get(i).numeroDepartamento); %></td>
</tr>

	
<%
}
%>

</table>
 

    </body>
</html>