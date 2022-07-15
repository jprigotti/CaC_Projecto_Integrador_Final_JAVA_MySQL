package Dailu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet5 extends HttpServlet {
	String message;

	public void init() throws ServletException {
		message = "Welcome to my project";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			RequestDispatcher dispatcher = null;
			EmpleadosQuery empleadosQuery = new EmpleadosQuery();
			List<Empleados> listaEmpleados = new ArrayList<Empleados>();

			listaEmpleados = empleadosQuery.searchByAllList();
			request.setAttribute("lista", listaEmpleados);
			dispatcher = request.getRequestDispatcher("file2.jsp");

			dispatcher.forward(request, response);

		} catch (ClassNotFoundException error) {
			error.printStackTrace();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}