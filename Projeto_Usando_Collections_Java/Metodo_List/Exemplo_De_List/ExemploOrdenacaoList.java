package Exemplo_De_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Dadas as seguintes informa��es sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

public class ExemploOrdenacaoList {
	public static void main(String[] args) {
		List<Gato> meusGatos = new ArrayList<>() {{
			add(new Gato("Julhi", 18 ,"Preto"));
			add(new Gato("Simba", 6 ,"Tigrado"));
			add(new Gato("Jon", 12 ,"Amarelo"));
		}};
		
		System.out.println("--\tOrdem de Inser��o\t---");
		System.out.println(meusGatos);
		
		System.out.println("\n--\tOrdem de Aleatoria\t---");
		Collections.shuffle(meusGatos); //metodo usado para deixar em ordem aleatoria "shuffle".
		System.out.println(meusGatos);
		
		System.out.println("\n--\tOrdem de Natural (Nome)\t---");
		Collections.sort(meusGatos);  //Fun��o que compara
		System.out.println(meusGatos);
		
		System.out.println("\n--\tOrdem Idade\t---");
//		Collections.sort(meusGatos, new ComparatorIdade());
		meusGatos.sort(new ComparatorIdade());
		System.out.println(meusGatos);
		
		System.out.println("\n--\tOrdem Cor\t---");
//		Collections.sort(meusGatos, new ComparatorCor());
		meusGatos.sort(new ComparatorCor());
		System.out.println(meusGatos);
		
		System.out.println("\n--\tOrdem Nome/Cor/Idade\t---");
//		Collections.sort(meusGatos, new ComparatorNomeCorIdade());
		meusGatos.sort(new ComparatorNomeCorIdade());
		System.out.println(meusGatos);

	}
}

class Gato implements Comparable<Gato>{
	private String nome;
	private Integer idade;
	private String cor;
	
	public Gato(String nome, Integer idade, String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "Gato [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
	}

	@Override
	public int compareTo(Gato gato) {		
		return this.getNome().compareToIgnoreCase(gato.getNome()); //fun��o que verifica as compara��es
	}

}

class ComparatorIdade implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2){
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}
	
}
class ComparatorCor implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2){
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
}
class ComparatorNomeCorIdade implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome()); //Primeiro criterio de verifica��o
		if(nome !=0) return nome; 
		
		int cor = g1.getCor().compareToIgnoreCase(g2.getCor()); //Segundo criterio de verifica��o
		if(cor !=0) return cor;
		
		return Integer.compare(g1.getIdade(), g2.getIdade()); 
		
	}
}