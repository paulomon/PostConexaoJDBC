package pipeline.stream;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static List<Pessoa> gerarLista() {
		ArrayList<Pessoa> lista = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			lista.add(new Pessoa("Nome" + i, i));
		}
		return lista;
	}

	@Override
	public String toString() {
		return nome + " - " + idade;
	}	
}
