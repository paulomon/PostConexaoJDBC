package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.database.Conexao;
import projeto.model.Tarefa;

public class TarefaDAO {

	Connection conn;
	
	public TarefaDAO() throws SQLException {
		conn = Conexao.getConnection();
	}
	
	public Tarefa adiciona(Tarefa tarefa) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("insert into tarefa (titulo, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, tarefa.getTitulo());
		ps.setString(2, tarefa.getDescricao());
	
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		
		if(rs.next()){
			long id = rs.getLong(1);
			tarefa.setId(id);
			return tarefa;
		}
		return null;
	}
	
	public Tarefa encontraPeloTitulo(String titulo) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("select * from tarefa where titulo = ?");
		ps.setString(1, titulo);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			Tarefa tarefa = new Tarefa(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"));
			return tarefa;
		}
		
		return null;
	}
	
	public List<Tarefa> listar() throws SQLException{
		PreparedStatement ps = conn.prepareStatement("select * from tarefa");
		ResultSet rs = ps.executeQuery();
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		while(rs.next()){
			Tarefa tarefa = new Tarefa(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"));
			tarefas.add(tarefa);
		}
		
		return tarefas;
	}
	
	public void criaTabela() throws SQLException{
		PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS TAREFA(ID SERIAL PRIMARY KEY,TITULO VARCHAR(100), DESCRICAO TEXT)");
		ps.execute();
	}
	
}
