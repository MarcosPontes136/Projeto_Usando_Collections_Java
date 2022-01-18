package Desafio_Proposto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.management.Query;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class Desafio1 {
	public static void main(String[] args) {
	System.out.println("Crie uma conjunto contendo as cores do arco-íris: ");
		Set<String> arcoIrisCores = new HashSet<>();
		arcoIrisCores.add("Violeta");
		arcoIrisCores.add("Anil");
		arcoIrisCores.add("Azul");
		arcoIrisCores.add("Verde");
		arcoIrisCores.add("Amarelo");
		arcoIrisCores.add("Laranja");
		arcoIrisCores.add("Vermelho");
		System.out.println(arcoIrisCores);
		
		//exibindo as cores
		System.out.println("\nExibindo as cores do Arco iris uma abaixo da outra: ");
		for(String cor : arcoIrisCores) {
			System.out.println(cor);
		}
		
		//exibir a quantidade de cores
		System.out.println("\nA quantidade de cores que o arco-íris tem:\n" + arcoIrisCores.size());
		
		System.out.println("\nExiba as cores em ordem alfabética\n");
		Set<String> arcoIrisCores1 =  new TreeSet<>(arcoIrisCores);
		System.out.println(arcoIrisCores1);
		
		
		//exibi na ordem inversa
        System.out.println("\nExiba as cores na ordem inversa da que foi informada\n");
        Set<String> arcoIrisCores2 = new LinkedHashSet<>();
		arcoIrisCores2.add("Violeta");
		arcoIrisCores2.add("Anil");
		arcoIrisCores2.add("Azul");
		arcoIrisCores2.add("Verde");
		arcoIrisCores2.add("Amarelo");
		arcoIrisCores2.add("Laranja");
		arcoIrisCores2.add("Vermelho");
		System.out.println(arcoIrisCores2);
	
		List<String> arcoIrisCoresList = new ArrayList<>(arcoIrisCores2);
		Collections.reverse(arcoIrisCoresList);
		System.out.println(arcoIrisCoresList);
		
		//exibir cores que começa com V
        System.out.println("\nExiba todas as cores que começam com a letra ”v”:\n");
        for(String corString : arcoIrisCores) {
        	if(corString.startsWith("V")) System.out.println(corString);
        }
        
        //remover cores que não tem V.
        System.out.println("\nRemova todas as cores que não começam com a letra “v”\n");
        Iterator<String> iterator2 = arcoIrisCores.iterator();
        while(iterator2.hasNext()) {
        	if(!iterator2.next().startsWith("V")) iterator2.remove(); //Se (diferente de V, então remove.) 
        }
        System.out.println(arcoIrisCores);

		//remover listas
        System.out.println("\nLimpe o conjunto:");
        arcoIrisCores.clear();
        
        System.out.println("\nConfira se o conjunto está vazio\n" + arcoIrisCores.isEmpty());  
	}

}
