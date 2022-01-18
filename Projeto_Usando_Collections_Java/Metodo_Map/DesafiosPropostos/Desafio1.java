package DesafiosPropostos;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

public class Desafio1 {
	public static void main(String[] args) {
		Map<String, Integer> estadosBr = new HashMap<>() {{
			 put("PE", 9616621 );
			 put("AL", 3351543 );
			 put("CE", 9187103 );
			 put("RN", 3534265 );
		}};
		System.out.println(estadosBr);
		
		//substituir um elemento
        System.out.println("\nSubstitua a população do estado RN por : 3.534.165\n");
        estadosBr.put("RN", 3534165);
        System.out.println(estadosBr);
        
        //confirmar se tem algum elemento
        System.out.println("\nConfira se o estado da Paraíba (PB) tucson está no dicionário, caso não, adicione " + "PB - 4.039.277:\n");
        estadosBr.put("PB", 4039277);
        System.out.println(estadosBr);
        
        System.out.println("\nExiba a população do estado PE:\n" + estadosBr.get("PE"));
        
        System.out.println("\nExiba todos os estados e suas populaçãos na ordem em que foram informados:\n");
		Map<String, Integer> estadosBr1 = new LinkedHashMap<>() {{
			 put("PE", 9616621 );
			 put("AL", 3351543 );
			 put("CE", 9187103 );
			 put("RN", 3534265 );
		}};
		System.out.println(estadosBr1);

		System.out.println("\nExiba todos os estados e suas populações na ordem alfabética:\n");
		Map<String, Integer> estadosBr2 = new TreeMap<>(estadosBr);
		System.out.println(estadosBr2);
		
		
		Collection<Integer> populacao = estadosBr.values();
		String estadoMenorPopulacao = " ";
		String estadoMaiorPupulacao = " ";
		
		//exibi o maior e menor estado em população
		for(Map.Entry<String, Integer> entry : estadosBr.entrySet()) {
			if(entry.getValue().equals(Collections.max(populacao))) estadoMaiorPupulacao = entry.getKey();
			if(entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();
		}
		
		System.out.printf("\nExiba o estado com o menor população (%s) e seu respectivo valor (%d)\n", estadoMenorPopulacao, Collections.min(populacao));
		
		System.out.printf("\nExiba o estado com a maior população (%s) e seu respectivo valor (%d)\n", estadoMaiorPupulacao, Collections.max(populacao));
		
		int soma = 0;
		Iterator<Integer> iterator = estadosBr.values().iterator();
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("\nExiba a soma da população desses estados:\n" + soma);
		
		System.out.println("\nExiba a média da população deste dicionário de estados:\n" + (soma/estadosBr.size()));
		
		 System.out.println("\nRemova os estados com a população menor que 4.000.000:\n");
		 Iterator<Integer> iterator2 = estadosBr.values().iterator();
		 while(iterator2.hasNext()) {
			 if(iterator2.next() <= 4000000) iterator2.remove();
		 }
			System.out.println(estadosBr);	
			
			System.out.println("\nApague o dicionario de estados com suas respectivas populações estimadas:\n");
			estadosBr.clear();
			System.out.println(estadosBr);
			
			 System.out.println("\nConfira se a lista está vazia:\n" + estadosBr.isEmpty());
	}

}

