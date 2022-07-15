<%-- 
    Document   : index
    Created on : 29 jun 2022, 13:14:36
    Author     : Dailu
--%>

<%@page import="org.apache.catalina.LifecycleState"%>
<%@page import="Dailu.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



    <section class="contactForm" id="contactanos">
        <div class="forContainer">
            <div class="content">
                <h2>Empleados</h2>
                <div class="separator"></div>
                <h5>Completa y agrega un nuevo empleado</h5>
            </div>

            <div>
            <% 
            Empleados empleado = (Empleados) request.getAttribute("empleado");
            %>
            
                 <form action="EmpleadosController?action=update_mysql" method="POST" class="ajax">
                 <input type="text" class="input inputIdEmpleado" name="idEmpleado" value=<%= Integer.toString(empleado.getIdEmpleado())%>>
                 <input type="text" class="input inputDNI" name="DNI" value=<%= Integer.toString(empleado.getDNI())%>>
                 <input type="text" class="input inputNombre" name="nombre" value=<%= empleado.getNombre()%>>
                 <input type="text" class="input inputApellido" name="apellido" value=<%= empleado.getApellido()%>>
                 <input type="text" class="input inputNumeroDepartamento" name="numeroDepartamento" value=<%= Integer.toString(empleado.getNumeroDepartamento())%>>
                 <input id="formSubmit" class="btnSolid" type="submit" value="Modificar">
                </form>
            </div>

        </div>
    </section>
    
    
</body>
</html>