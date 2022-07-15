package Dailu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpleadosController
 */
public class EmpleadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			EmpleadosDAO empleadosDAO = new EmpleadosDAO(); // Al momento de crear el objeto, automaticamente se crea la
															// conexion a la database
			String action;
			RequestDispatcher dispatcher = null;

			action = request.getParameter("action");

			if (action == null || action.isEmpty()) {

				List<Empleados> listaEmpleados = new ArrayList<Empleados>();
				listaEmpleados = empleadosDAO.searchEmpleados();
				request.setAttribute("lista", listaEmpleados);
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			} else {

				switch (action) {
				case "new_jsp":
					dispatcher = request.getRequestDispatcher("new.jsp");
					dispatcher.forward(request, response);
					break;

				case "new_mysql":
					int DNI = Integer.parseInt(request.getParameter("DNI"));
					String nombre = request.getParameter("nombre");
					String apellido = request.getParameter("apellido");
					int numeroDepartamento = Integer.parseInt(request.getParameter("numeroDepartamento"));

					Empleados empleado = new Empleados(0, DNI, nombre, apellido, numeroDepartamento);
					empleadosDAO.insertEmpleados(empleado);
					List<Empleados> listaEmpleados = new ArrayList<Empleados>();
					listaEmpleados = empleadosDAO.searchEmpleados();
					request.setAttribute("lista", listaEmpleados);
					dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					break;

				case "update_jsp":

					int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
					empleado = empleadosDAO.searchEmpleados(idEmpleado);
					request.setAttribute("empleado", empleado);

					dispatcher = request.getRequestDispatcher("update.jsp");
					dispatcher.forward(request, response);
					break;

				case "update_mysql":

					idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
					DNI = Integer.parseInt(request.getParameter("DNI"));
					nombre = request.getParameter("nombre");
					apellido = request.getParameter("apellido");
					numeroDepartamento = Integer.parseInt(request.getParameter("numeroDepartamento"));

					empleado = new Empleados(idEmpleado, DNI, nombre, apellido, numeroDepartamento);
					empleadosDAO.updateEmpleados(empleado);
					listaEmpleados = new ArrayList<Empleados>();
					listaEmpleados = empleadosDAO.searchEmpleados();
					request.setAttribute("lista", listaEmpleados);
					dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					break;

				case "delete_mysql":

					idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

					empleadosDAO.deleteEmpleados(idEmpleado);
					listaEmpleados = new ArrayList<Empleados>();
					listaEmpleados = empleadosDAO.searchEmpleados();
					request.setAttribute("lista", listaEmpleados);
					dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					break;

				default:

					break;

				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

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
