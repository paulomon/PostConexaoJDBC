package pipeline.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Init {
	
	public void pipeline(List<Pessoa> pessoas){
		pessoas.stream()
		.filter((p) -> p.getIdade() > 5)
		.sorted((p1,p2) -> p1.getNome().compareTo(p2.getNome()))
		.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void peekFindAny(List<Pessoa> pessoas){
		Optional<Pessoa> findAny = pessoas.stream().peek(System.out::println).filter((p) -> p.getIdade() > 5).findAny();
	}
	
	public void peekAverage(List<Pessoa> pessoas){
		OptionalDouble average = pessoas.stream().mapToInt(Pessoa::getIdade).peek(System.out::println).filter(i -> i > 5).average();
	}
	
	public Init() {
		List<Pessoa> pessoas = Pessoa.gerarLista();
		pipeline(pessoas);
		peekFindAny(pessoas);
		peekAverage(pessoas);
	}
	
	public static void main(String[] args) {
		new Init();
	}
}
