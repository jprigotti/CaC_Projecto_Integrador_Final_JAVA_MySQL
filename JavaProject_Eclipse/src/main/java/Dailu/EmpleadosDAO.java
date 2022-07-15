package Dailu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {

	// ********** DECLARACION DE VARIABLES **********

	// Connection to database
	Connection mysqlConnection;

	// Creamos el metodo constructor EmpleadosDAO
	public EmpleadosDAO() throws ClassNotFoundException {
		try {
			mysqlConnection = new Mysql().getConnection();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}

	// Creamos el método searchEmpleados() que se invoca haciendo
	// EmpleadosDAO.searchEmpleados() y retorna un array de objeto Empleados
	public List<Empleados> searchEmpleados() {

		// Declaracion variables
		PreparedStatement ps;
		ResultSet rs;
		List<Empleados> listaEmpleados = new ArrayList<>();
		String query = "SELECT * FROM empleados";

		try {

			ps = mysqlConnection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int rsid = rs.getInt("idEmpleado");
				int rsDNI = rs.getInt("DNI");
				String rsnombre = rs.getString("nombre");
				String rsapellido = rs.getString("apellido");
				int rsnumeroDepartamento = rs.getInt("numeroDepartamento");

				Empleados empleado = new Empleados(rsid, rsDNI, rsnombre, rsapellido, rsnumeroDepartamento);
				listaEmpleados.add(empleado);

			}

			return listaEmpleados;

		} catch (SQLException error) {
			error.printStackTrace();
			return null;
		}

	}

	// Creamos el método searchEmpleados(int id) que se invoca haciendo
	// EmpleadosDAO.searchEmpleados(numero de id) y retorna un objeto Empleados
	public Empleados searchEmpleados(int id) {

		// Declaracion variables
		PreparedStatement ps;
		ResultSet rs;
		Empleados empleado = null;
		String query = "SELECT * FROM empleados WHERE idEmpleado = ?";

		try {

			ps = mysqlConnection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int rsid = rs.getInt("idEmpleado");
				int rsDNI = rs.getInt("DNI");
				String rsnombre = rs.getString("nombre");
				String rsapellido = rs.getString("apellido");
				int rsnumeroDepartamento = rs.getInt("numeroDepartamento");

				empleado = new Empleados(rsid, rsDNI, rsnombre, rsapellido, rsnumeroDepartamento);

			}

			return empleado;

		} catch (SQLException error) {
			error.printStackTrace();
			return null;
		}

	}

	// Creamos el método insertEmpleados(Empleados empleado) que se invoca haciendo
	// EmpleadosDAO.insertEmpleados(empleado) y retorna un boolean si el registro se
	// inserto correctamente en la tabla

	public boolean insertEmpleados(Empleados empleado) {

		// Declaracion variables
		PreparedStatement ps;
		String query = "INSERT INTO empleados (DNI, nombre, apellido, numeroDepartamento) VALUES (?,?,?,?)";

		try {

			ps = mysqlConnection.prepareStatement(query);
			ps.setInt(1, empleado.getDNI());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellido());
			ps.setInt(4, empleado.getNumeroDepartamento());
			ps.execute();

			return true;

		} catch (SQLException error) {
			error.printStackTrace();
			return false;
		}

	}

	public boolean updateEmpleados(Empleados empleado) {

		// Declaracion variables
		PreparedStatement ps;
		String query = "UPDATE empleados SET DNI = ?, nombre = ?, apellido = ?, numeroDepartamento = ? WHERE idEmpleado = ?";

		try {

			ps = mysqlConnection.prepareStatement(query);
			ps.setInt(1, empleado.getDNI());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellido());
			ps.setInt(4, empleado.getNumeroDepartamento());
			ps.setInt(5, empleado.getIdEmpleado());
			ps.execute();

			return true;

		} catch (SQLException error) {
			error.printStackTrace();
			return false;
		}

	}

	public boolean deleteEmpleados(int idEmpleados) {

		// Declaracion variables
		PreparedStatement ps;
		String query = "DELETE FROM empleados WHERE idEmpleado = ?";

		try {

			ps = mysqlConnection.prepareStatement(query);
			ps.setInt(1, idEmpleados);
			ps.execute();

			return true;

		} catch (SQLException error) {
			error.printStackTrace();
			return false;
		}

	}

}
