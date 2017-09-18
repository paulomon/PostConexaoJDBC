package projeto.app;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.dao.TarefaDAO;
import projeto.model.Tarefa;

public class Init {
	
	private TarefaDAO dao;
	
	public Init() {
		try {
			dao = new TarefaDAO();
			dao.criaTabela();
			iniciar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Init();
	}
	
	private void iniciar() throws SQLException{
		String op = "";
		
		while(op.compareTo("0") != 0){
			op = JOptionPane.showInputDialog("Escolha uma operação: \n"
					+ "1 - Adicionar uma nova terefa \n"
					+ "2 - Buscar terefa \n"
					+ "3 - Litar terefas \n"
					+ "0 - Sair");
			
			if(op.compareTo("1") == 0){
				String titulo = JOptionPane.showInputDialog("Titulo: ");
				String descricao = JOptionPane.showInputDialog("Descrição: ");
				
				Tarefa tarefa = new Tarefa(titulo, descricao);
				
				Tarefa tarefaAdicionada = dao.adiciona(tarefa);
				JOptionPane.showMessageDialog(null, tarefaAdicionada.toString());
			}else if(op.compareTo("2") == 0){
				String titulo = JOptionPane.showInputDialog("Titulo: ");
				Tarefa tarefa = dao.encontraPeloTitulo(titulo);
				
				if(tarefa == null){
					JOptionPane.showMessageDialog(null, "Tarefa não encontrada");
					continue;
				}
				
				JOptionPane.showMessageDialog(null, "Tarefa encontrada: \n" + tarefa.toString());
			}else if(op.compareTo("3") == 0){
				List<Tarefa> tarefas = dao.listar();
				
				if(tarefas.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não existe tarefas cadastradas");
					continue;
				}
			
				JOptionPane.showMessageDialog(null, "Tarefas cadastradas: \n" + tarefas);
			}else{
				continue;
			}
		}
	}
	
}
