package Exemplo_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExemploStreamAPI {
	public static <T> void main(String[] args) {
		List<String> numerosAleatorios = 
				Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
		
		System.out.println("Imprima todos os elementos dessa lista de String: ");
		numerosAleatorios.forEach(s -> System.out.println(s));
		
		System.out.println("\nPegue os 5 primeiros numerose coloque dentro de um Set: ");
		
		/*numerosAleatorios.stream()
		.limit(5)                        //limitei em 5 elementos
		.collect(Collectors.toSet())    //Coletei para dentro do toSet.
		.forEach(System.out::println);  //e imprimir
		
		//ou
*/
		Set<String> collectSet = numerosAleatorios.stream()  //metodo Set não aceita numero repetido.
				.limit(5)
				.collect(Collectors.toSet());
		System.out.println(collectSet);
				
		
		System.out.println("\nTransforme esta lista de String em uma lista de numeros inteiros: ");
		numerosAleatorios.stream()
		.map(s -> Integer.parseInt(s))
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		System.out.println("\nPegue os numeros pares e maiores que 2 e coloque em uma lista: ");
		numerosAleatorios.stream()
		.map(Integer::parseInt)
		.filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList()) //filter é um filtro usando o if para pegar numeros, no exemplo é numeros pares.
		.forEach(System.out::println);
		
		System.out.println("\nMedia dos numeros: ");
		numerosAleatorios.stream()
		.mapToInt(s -> Integer.parseInt(s))
		.average()                              //Ele retorna um OptionalDouble, nesse caso precisa usar uma das funções que é ifPresent
		.ifPresent(v ->System.out.println(v)); //ifPresent recebe um DoubleConsumer, e retorna um void
		
		System.out.println("\nRemova os numeros impares: ");
		List<Integer> numerosAleatoriosIntegers = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		numerosAleatoriosIntegers.removeIf(integer -> (integer % 2 != 0)); 
				System.out.println(numerosAleatoriosIntegers);
	}
}
