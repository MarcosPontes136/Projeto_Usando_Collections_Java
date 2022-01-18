package DesafiosPropostos.Desafio3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

public class Desafio3 {
	public static void main(String[] args) {
		System.out.println("---\tOrdem aleatoria\t---\n");
		Map<Integer, Contato> contatos = new HashMap<>() {{
			put(1, new Contato("Simba", 2222));
			put(4, new Contato("Cami", 5555));
			put(3, new Contato("Jon", 1111));	
		}};
		for(Map.Entry<Integer, Contato> entry : contatos.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}
		
		System.out.println("\n---\tOrdem Inserção\t---\n");
		Map<Integer, Contato> contatos1 = new LinkedHashMap<>() {{
			put(1, new Contato("Simba", 2222));
			put(4, new Contato("Cami", 5555));
			put(3, new Contato("Jon", 1111));	
		}};
		for(Map.Entry<Integer, Contato> entry : contatos1.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}
		
		System.out.println("\n---\tOrdem ID\t---\n");
		Map<Integer, Contato> contatos2 =  new TreeMap<>(contatos);
		for(Map.Entry<Integer, Contato> entry : contatos2.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}

		System.out.println("\n---\tOrdem numero de telefone\t---\n");
		Set<Map.Entry<Integer, Contato>> set = new TreeSet(new ComparatorOrdemNumerica());
		set.addAll(contatos.entrySet());
		for(Map.Entry<Integer, Contato> entry : set) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}

		System.out.println("\n---\tOrdem por nome de contato\t---\n");
		Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(new ComparatorOrdemContato());
		set2.addAll(contatos.entrySet());
		for(Map.Entry<Integer, Contato> entry : set2) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}
	}
}

class ComparatorOrdemContato implements Comparator<Map.Entry<Integer, Contato>>{
	@Override
	public int compare(Map.Entry<Integer, Contato> cont1,Map.Entry<Integer, Contato> cont2) {
		return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
	}
}

class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>>{
	@Override
	public int compare(Map.Entry<Integer, Contato> cont1,Map.Entry<Integer, Contato> cont2) {
		return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
	}
}
