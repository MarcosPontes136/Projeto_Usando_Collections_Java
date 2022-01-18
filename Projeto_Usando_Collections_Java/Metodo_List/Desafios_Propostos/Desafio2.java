package Desafios_Propostos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Utilizando listas, faça um programa que pergunte para uma pessoa sobre um crime. As Perguntas são:
 * 1. "Telefonou para a vítima?"
 * 2. "Esteve no local do crime?"
 * 3. "Mora perto da vítima?"
 * 4. "Devia para a vítima?" 
 * 5. "Já trabalhou com a vítima?"
 * 
 * Se a pessoa responder positivamente a 2 questões ela é classificada como SUSPEITA!, entre 3 e 4 como CÚMPLICE!, e 5 como ASSASSINA.
 * Caso contrario, ela é classificada como INOCENTE.
 */



public class Desafio2 {
	public static void main(String[] args) {
		List<String> respostas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("----\tPerguntas\t----");
		
		System.out.println("Telefonou para a vítima?");
		String resposta = scanner.next();
		respostas.add(resposta.toLowerCase());
		
		System.out.println("Esteve no local do crime?");
		resposta = scanner.next();
		respostas.add(resposta.toLowerCase());

		
		System.out.println("Mora perto da vítima?");
		resposta = scanner.next();
		respostas.add(resposta.toLowerCase());

		
		System.out.println("Devia para a vítima?");
		resposta = scanner.next();
		respostas.add(resposta.toLowerCase());

		
		System.out.println("Já trabalhou com a vítima?");
		resposta = scanner.next();
		respostas.add(resposta.toLowerCase());

		
		System.out.println(respostas);
		
		int count = 0;
		Iterator<String> contador = respostas.iterator();
		while(contador.hasNext()) {
			String resp = contador.next();
			if(resp.contains("s")) {
				count ++;
			}
		}
		
		switch(count) {
		case 2: 
			System.out.println(">> SUSPEITA <<"); break;
			
		case 3:
		case 4:
			System.out.println(">> CÚMPLICE <<"); break;
			
		case 5: 
			System.out.println(">> ASSASSINA <<"); break;
			
			default:
				System.out.println(">> INOCENTE <<"); break;
		}	
	}
}
