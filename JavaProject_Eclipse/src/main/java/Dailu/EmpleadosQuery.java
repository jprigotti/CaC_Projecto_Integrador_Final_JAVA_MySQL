package Dailu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosQuery {

	// ********** DECLARACION DE VARIABLES **********

	// Connection to database
	Connection mysqlConnection;

	// Table Fields
	private final String idEmpleado = "idEmpleado";
	private final String DNI = "DNI";
	private final String nombre = "nombre";
	private final String apellido = "apellido";
	private final String numeroDepartamento = "numeroDepartamento";

	// Queries
	private final String searchByAll = "SELECT * FROM empleados";
	private final String searchByIdEmpleado = "SELECT * FROM empleados WHERE idEmpleado = ?";
	// private final String searchByDNI = "SELECT * FROM empleados WHERE " + DNI + "
	// = ?";
	// private final String searchByName = "SELECT * FROM empleados WHERE " + nombre
	// + " = ?";
	// private final String searchByapellido = "SELECT * FROM empleados WHERE " +
	// apellido + " = ?";
	// private final String searchByNumeroDepartamento = "SELECT * FROM empleados
	// WHERE " + numeroDepartamento + " = ?";

	// ********** DECLARACION DE METODOS **********

	// Metodo constructor

	public EmpleadosQuery() throws ClassNotFoundException {
		try {
			mysqlConnection = new Mysql().getConnection();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}

	// Metodo searchByIdEmpleado
	public List<Empleados> searchByAllList() throws SQLException {
		List<Empleados> listaEmpleados = new ArrayList<>();
		PreparedStatement mysqlPrepStatement = mysqlConnection.prepareStatement(searchByAll);
		ResultSet searchResult = mysqlPrepStatement.executeQuery();
		while (searchResult.next()) {
			int rsid = searchResult.getInt(idEmpleado);
			int rsDNI = searchResult.getInt(DNI);
			String rsnombre = searchResult.getString(nombre);
			String rsapellido = searchResult.getString(apellido);
			int rsnumeroDepartamento = searchResult.getInt(numeroDepartamento);

			Empleados empleado = new Empleados(rsid, rsDNI, rsnombre, rsapellido, rsnumeroDepartamento);
			listaEmpleados.add(empleado);
		}

		return listaEmpleados;
	}

	public ResultSet searchByAll() throws SQLException {
		PreparedStatement mysqlPrepStatement = mysqlConnection.prepareStatement(searchByAll);
		ResultSet searchResult = mysqlPrepStatement.executeQuery();

		return searchResult;
	}

}
