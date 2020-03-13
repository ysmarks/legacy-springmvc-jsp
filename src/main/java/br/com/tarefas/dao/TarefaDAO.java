package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.tarefas.modelo.Tarefa;

@Repository
public class TarefaDAO {

	private Connection connection;
	
	@Autowired
	public TarefaDAO(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void adiciona(Tarefa tarefa) {
		String sql  = "insert into tarefa(descricao, finalizada, dataFinalizacao) values(?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tarefa.getDescricao());
			statement.setBoolean(2, tarefa.isFinalizada());
			statement.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Tarefa> lista() {
		String sql = "select * from tarefa";
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizada(rs.getBoolean("finalizada"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
				
				tarefas.add(tarefa);	
			}
			pstm.close();
			rs.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remover(Tarefa tarefa) {
		String sql = "delete from tarefa where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public Tarefa buscaPorId(Long id) {
		String sql = "select * from tarefa where id = ?";
		Tarefa tarefa = new Tarefa();
		try {
			
			tarefa.setId(id);
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setLong(1, tarefa.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizada(rs.getBoolean("finalizada"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			}
			pstm.close();
			rs.close();
			return tarefa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void altera(Tarefa tarefa) {
		String sql = "update tarefa set descricao = ?, finalizada = ?, dataFinalizacao = ? where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setLong(1, tarefa.getId());
			pstm.setString(2, tarefa.getDescricao());
			pstm.setBoolean(3, tarefa.isFinalizada());
			pstm.setDate(4, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void finaliza(Long id) {
		String sql = "";
		
	}
}
