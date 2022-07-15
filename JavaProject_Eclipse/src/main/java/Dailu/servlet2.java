package Dailu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet2 extends HttpServlet {
	String message;

	public void init() throws ServletException {
		message = "Welcome to my project";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			EmpleadosQuery empleadosQuery = new EmpleadosQuery();
			ResultSet searchResult;
			searchResult = empleadosQuery.searchByAll();

			try (PrintWriter out = response.getWriter()) {
				while (searchResult.next()) {

					out.print("Nombre: " + searchResult.getString("nombre"));
					out.println("  Apellido: " + searchResult.getString("apellido"));
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