package Dailu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet3 extends HttpServlet {
	String message;

	public void init() throws ServletException {
		message = "Welcome to my project";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputIdEmpleado = request.getParameter("inputIdEmpleado");

		try {
			EmpleadosQueryList empleadosQueryList = new EmpleadosQueryList();
			List<Empleados> listaEmpleados = new ArrayList<>();
			listaEmpleados = empleadosQueryList.searchByIdEmpleado(inputIdEmpleado);

			try (PrintWriter out = response.getWriter()) {
				for (int i = 0; i < listaEmpleados.size(); i++) {
					out.println("Apellido: " + listaEmpleados.get(i).apellido);
				}
			}

		} catch (Exception error) {
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