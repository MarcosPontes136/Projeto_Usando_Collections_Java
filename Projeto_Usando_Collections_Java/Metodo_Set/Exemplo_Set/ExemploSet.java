package Exemplo_Set;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.print.attribute.standard.Media;

public class ExemploSet {
	public static void main(String[] args) {
		
		// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

//      Set notas = new HashSet();                 //antes do java 5
//      HashSet<Double> notas = new HashSet<>();
//      Set<Double> notas = new HashSet<>();      //Generics(jdk 5) - Diamont Operator(jdk 7)
/*      Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);
*/
		System.out.println("Crie um conjunto e adicione as notas: ");
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println(notas.toString());
		
		System.out.println("\nExiba a posição da nota 5.0: ");  //Não tem como exibir a posição usando SET.
		
		System.out.println("\nAdicione na lista a nota 8.0 na posição 4: "); //não tem como trabalhar com posições usando SET
		
		System.out.println("\nSubistitua a nota 5.0 pela nota 6.0: ");  //Não tem como subistituir um valor pelo outro, so usando umas List.
		
		System.out.println("\nConfira se a nota 5.0 esta no conjunto:\n"  + notas.contains(5d)); //se for verdade retorna true.
		
		System.out.println("\nExiba a terceira nota adicionada: "); //metedo SET não consegue passar valor, ele não tem o metodo GET.
		
		System.out.println("\nExiba a menor nota:\n" + Collections.min(notas));
		
		System.out.println("\nExiba a maior nota:\n" + Collections.max(notas));

		Iterator<Double> iterator = notas.iterator();
		Double somaDouble = 0.0;
		while(iterator.hasNext()) {
			Double next = iterator.next();
			somaDouble += next;
		}
		System.out.println("\nExibir a soma dos valores:\n" + somaDouble);

		System.out.println("\nExiba a media das notas:\n" + (somaDouble/notas.size()));
		
		System.out.println("\nRemova a nota 0.0:\n" + notas); //valor antes
		notas.remove(0.0);
		System.out.println(notas); //valor depois
		
		System.out.println("\nRemova as notas menores que 7 e exiba a lista:");
		Iterator<Double> iterator2 = notas.iterator();
				while(iterator2.hasNext()) {
					Double next = iterator2.next();
					if(next < 7 ) iterator2.remove();
				}
				System.out.println(notas);

		System.out.println("\nExiba todas as notas na ordem que foram informadas:");
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d);
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);

		
		System.out.println("\nExiba todas as notas na ordem crescente:");
		Set<Double> notas3 = new TreeSet<>(notas2); //TreeSet apresenta a lista em formato crescente, mas só funciona com Double.
		System.out.println(notas3);
		
		System.out.println("\nLimpar a lista: ");
		notas.clear();
		
		System.out.println("\nConfira se o conjunto está vazio:\n" + notas.isEmpty());
		
		System.out.println("\nConfira se o conjunto 2 está vazio:\n" + notas2.isEmpty());
		
		

	}

}
