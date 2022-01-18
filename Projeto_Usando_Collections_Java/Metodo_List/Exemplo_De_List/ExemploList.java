package Exemplo_De_List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ExemploList {
	public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

//      List notas = new ArrayList(); //antes do java 5
//      ArrayList<Double> notas = new ArrayList<>();
//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        /*List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(10d);
        System.out.println(notas);*/
        /*List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);*/
		
		
		System.out.println("Crie uma Lista e adicione as sete notas: ");
		List<Double> notas = new ArrayList<Double>(); //Generics(jdk 5) - Diamond Operator(jdk 7)
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		System.out.println(notas.toString());

		System.out.println("\nExiba a posição da nota 5.0: " + notas.indexOf(5d));
		
		System.out.println("\nAdicione na Lista a nota 8.0 na posição 4: ");
		notas.add(4, 8d);  //posição, novo valor de entrada.
		System.out.println(notas);
		
		System.out.println("\nSubistitua a nota 5.0 por 6.0: ");
		notas.set(notas.indexOf(5d), 6.0); //indexOf procura na lista o objeto.
		System.out.println(notas);
		
		System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5d)); // contains confirma se á algum elemento na lista, caso for verdade retorna "False"
		
		System.out.println("\nExiba todas as notas na ordem em que foram informadas: ");
		for (Double nota : notas)System.out.println(nota);                          //usa se FOR para imprimir toda a lista na ordem que foi colocado os objetos.
		
		System.out.println("\nExiba a terceira nota adicionada: " + notas.get(2)); //função GET busca o valor que está na posição atribuida.
		
		System.out.println("\nExiba a menor nota: " + Collections.min(notas)); //Collections.min tem uma implementação de comparação, no caso retorna o menor valor.
		
		System.out.println("\nExiba a maior nota: " + Collections.max(notas)); //mesma coisa que encima.
		
		
		Iterator<Double> iterator = notas.iterator();  //iterator ajuda interando dentro da lista, assim vai somando os valores.
		Double somaDouble = 0d;
		while(iterator.hasNext()) {                  //iterator tem o próximo (hasNext), caso tiver ele entra no loop.
			Double nextDouble = iterator.next();    //dentro do loop a variavel nextDouble recebe o valor da lista.
			somaDouble += nextDouble;              //após receber o valor, ele soma.
		}
		System.out.println("\nExiba a soma dos valores: " + somaDouble);
		
		System.out.println("\nExiba a media das notas: " + (somaDouble/notas.size())); //size verifica a quantidade de elementos que tem dentro da lista.
		
		System.out.println("\nRemova a nota 0.0: ");
		notas.remove(0d);
		System.out.println(notas);
		
		
		Iterator<Double> iterator2 = notas.iterator();
		while(iterator2.hasNext()) {
			Double nextDouble = iterator2.next();
			if(nextDouble < 7) iterator2.remove(); ///verifica se os numeros são menores que 7, se for ele remove.
		}
		System.out.println("\nRemova as notas menores que 7.0 e exiba a lista:\n" + notas);

		System.out.println("\nApague toda a lista: ");
		notas.clear();
		
		System.out.println("Confirmanda se a lista está fazia:");
		System.out.println(notas);
		                             //Ou podemos verificar de outra materia usando isEmpty();
		
		System.out.println("Confirmanda se a lista está fazia:" + notas.isEmpty()); //true é porque está vazia, false não está fazia.
		
		/*
		Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:
		        System.out.println("Crie uma lista chamada notas2 " +
		                "e coloque todos os elementos da list Arraylist nessa nova lista: ");
		        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: ");
		        System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
		*/

		
		List<Double> notas2 = new ArrayList<Double>();
		notas2.add(2.0);
		notas2.add(6.0);
		notas2.add(5.8);
		notas2.add(10.0);
		notas2.add(9.6);
		notas2.add(7.5);
		notas2.add(4.0);
		
		System.out.println("\nListas nova: " + notas2);
		
		System.out.println("\nExibir a primeira nota sem remover: " + notas2.get(0));
		
		System.out.println("\nPrimeira nota da Lista: " + notas2.get(0) + "\nRemovendo nota " + notas2.remove(0));
		
		System.out.println("\nConfirmação de remoção de nota:" + notas2);
		
		}

}
