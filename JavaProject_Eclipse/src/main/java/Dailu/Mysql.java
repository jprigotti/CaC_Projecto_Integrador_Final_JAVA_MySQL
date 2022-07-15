package Dailu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	// declaramos el atributo enum

	// declaramos el metodo constructor
	public Mysql() {
	}

	// declaramos el metodo getConnection
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// String url = "jdbc:mysql://localhost:3306/desafiobd?serverTimezone=UTC";
		String url = "jdbc:mysql://dailutb.com:3306/titojp20_desafiobd?serverTimezone=UTC";
		// String user = "user1";
		String user = "titojp20_user1";
		String password = "123456";
		return DriverManager.getConnection(url, user, password);
	}

}
