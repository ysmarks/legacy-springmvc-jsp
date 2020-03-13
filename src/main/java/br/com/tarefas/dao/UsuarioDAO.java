package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tarefas.drivers.ConnectioTarefaFactory;
import br.com.tarefas.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO() {
		connection = ConnectioTarefaFactory.getConnection();
	}

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		String sql = "select login from usuario where login = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				usuario.setLogin(rs.getString("login"));
				existe = true;
			}
			pstm.close();
			rs.close();
			return existe;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
