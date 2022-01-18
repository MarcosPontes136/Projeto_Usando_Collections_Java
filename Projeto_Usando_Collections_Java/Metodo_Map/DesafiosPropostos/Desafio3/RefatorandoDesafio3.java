package DesafiosPropostos.Desafio3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RefatorandoDesafio3 {
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
		/*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>> () {
		@Override
		public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
			return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
		}
		});*/
	
		/*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
			@Override
			public Integer apply(Map.Entry<Integer, Contato> cont) {
				return cont.getValue().getNumero();
			}
		}));*/
		
		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero())); //metodo lambda
		set.addAll(contatos.entrySet());
		for(Map.Entry<Integer, Contato> entry : set) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}

		System.out.println("\n---\tOrdem por nome de contato\t---\n");
		Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome())); //metodo lambda
		set2.addAll(contatos.entrySet());
		for(Map.Entry<Integer, Contato> entry : set2) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}
	}
}