package Desafios_Propostos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
 * Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
 * Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média, e em que mês elas ocorreram 
 * (mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc.
 */

public class Desafio1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Double> temperaturas = new ArrayList<Double>();
		
		//Adiciona a temperatura na lista
		int count = 0;
		while(true) {
			if(count == 6) break;
			
			System.out.println("Digite uma temperatura: ");
			double temp = scanner.nextDouble();
			temperaturas.add(temp);
			count ++;
		}
		System.out.println("-----------------");
		
		//Exibir todas as temperaturas
		System.out.println("Todas as temperaturas: ");
		temperaturas.forEach(t -> System.out.println(t + " ")); //metodo lambda
		
		//calculando e exibindo a média das temperaturas:
		double media = temperaturas.stream()
				.mapToDouble(Double::doubleValue)
				.average()
				.orElse(0d);
		System.out.printf("\nMedia das temperaturas: %.1f\n", media);
		
        //exibindo as temperaturas acima da média
		System.out.println("Temperaturas acima da media: ");
		temperaturas.stream()
		.filter(t -> t > media)
		.forEach(t -> System.out.printf("%.1f\t", t));
		
        //exibindo o mês das temperaturas acima da média por extenso:
		System.out.println("\n\nMeses das temperaturas acima da media: ");
		Iterator<Double> iterator = temperaturas.iterator();
		
		count = 0;
		while(iterator.hasNext()) {
			Double tempDouble = iterator.next();
			if(tempDouble > media) {
				switch (count) {
				case (0):
					System.out.printf("1 - janeiro: %.1f\n", tempDouble);
				break;
				
				case (1):
					System.out.printf("2 - Fevereiro: %.1f\n", tempDouble);
				break;
				
				case (2):
					System.out.printf("3 - Março: %.1f\n", tempDouble);
				break;
				
				case (3):
					System.out.printf("4 - Abril: %.1f\n", tempDouble);
				break;
				
				case (4):
					System.out.printf("5 - Maio: %.1f\n", tempDouble);
				break;
				
				case (5):
					System.out.printf("6 - Junho: %.1f\n", tempDouble);
				break;
				
				default:
					System.out.println("Não houve temperatura acima da media.");
				}
			}
			count ++;
		}

	}
}
