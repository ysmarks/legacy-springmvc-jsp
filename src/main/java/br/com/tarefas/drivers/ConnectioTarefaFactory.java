package br.com.tarefas.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectioTarefaFactory {

	public static Connection getConnection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "senha2019");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
