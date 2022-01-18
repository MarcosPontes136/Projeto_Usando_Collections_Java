package Exemplo_Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExemploMap {
	public static void main(String[] args) {
		/*
		 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
		 modelo = gol - consumo = 14,4km/l
		 modelo = uno - consumo = 15,6 km/l
		 modelo = mobi - consumo = 16,1 km/l
		 modelo = hb20 - consumo = 14,5 km/l
		 modelo = kwid - consumo = 15,6 km/l
		 */

//		        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//		        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//		        HashMap<String, Double> carrosPopulares = new HashMap<>();
//		        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)
		
		
		 System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
		 Map<String, Double> carrosPopulares = new HashMap<>() {{
			 put("Gol", 14.4);
			 put("Uno", 15.6);
			 put("Mobi", 16.1);
			 put("Hb20", 14.5); 
			 put("Kwid", 15.6);
		 }}; 
		 System.out.println(carrosPopulares.toString());
		 
		 
		 System.out.println("\nSubstitua o consumo do gol por 15,2 km/l: ");
		 carrosPopulares.put("Gol", 15.2); //metodo de subistituir
		 System.out.println(carrosPopulares);
		
		 System.out.println("\nConfira se o modelo tucson está no dicionário:\n" + carrosPopulares.containsKey("Tucson")); //metodo de confirmação.
		 
	     System.out.println("\nExiba o consumo do Uno:\n" + carrosPopulares.get("Uno")); //metodo de busca.
	     
//	     System.out.println("\nExiba o terceiro modelo: "); //nao tem metodos para exibir um conteudo expecifico.

	     System.out.println("\nExiba os modelos:");
	     Set<String> modelos = carrosPopulares.keySet();         //metodo para exibir os conteudos.
	     System.out.println(modelos);
	     
	     System.out.println("\nExiba os consumos dos carros: ");
	     Collection<Double> consumos = carrosPopulares.values();  //metodo para exibir os consumos.
	     System.out.println(consumos);
	     
	     System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
	     
	     Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
	     Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
	     String modeloMaisEficiente = "";
	     
	     for(Map.Entry<String, Double> entry: entries) { 
	    	 if(entry.getValue().equals(consumoMaisEficiente)) { //Se(o valor dentro do meu Entry for igual ao ConsumoMaisEficiente, entao:
	    		 modeloMaisEficiente = entry.getKey();          //entao posso dizer que o modeloMaisEficiente é igual a key dentro do entry.
			     System.out.println("\t-----Modelo mais eficiente-----\t\n" + modeloMaisEficiente + " - " + consumoMaisEficiente );	 
	    	 }
	     }
	     
	     System.out.println("\nExiba o modelo menos econômico e seu consumo: " );
	     
	     Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
	     String modeloMenosEficiente = "";
	     for(Map.Entry<String, Double> entry: carrosPopulares.entrySet()) {
	    	 if(entry.getValue().equals(consumoMenosEficiente)) {       //Se(o valor dentro do meu Entry for igual ao ConsumoMenosEficiente, entao:
		    	 modeloMenosEficiente = entry.getKey();                //entao posso dizer que o modeloMenosEficiente é igual a key dentro do entry.
			     System.out.println("\t-----Modelo menos eficiente-----\t\n" + modeloMenosEficiente + " - " + consumoMenosEficiente );	 
	    	 } 
	     }
	     
	     Iterator<Double> iterator = carrosPopulares.values().iterator();
	     Double soma = 0d;
	     while(iterator.hasNext()) { //O iterator tem proximo:
	    	 soma += iterator.next(); //soma com iterator.next.
	     }
	     System.out.println("\nExiba a soma dos consumos:\n" + soma);

	     System.out.println("\nExiba a média dos consumos deste dicionário de carros:\n" + (soma/carrosPopulares.size()));

	     System.out.println("\nRemova os modelos com o consumo igual a 15,6 km/l: ");
	     Iterator<Double> iterator2 = carrosPopulares.values().iterator();
	     while(iterator2.hasNext()) {
	    	 if(iterator2.next().equals(15.6)) iterator2.remove(); //Se iterator2 enquanto for 15.6, então iterator2 remove da lista.
	     }
	     System.out.println(carrosPopulares);
	     
	     System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
		 Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{ //LinkedHashMap exibi na ordem que foi criado.
			 put("Gol", 14.4);
			 put("Uno", 15.6);
			 put("Mobi", 16.1);
			 put("Hb20", 14.5); 
			 put("Kwid", 15.6);
		 }}; 
		 System.out.println(carrosPopulares1.toString());
	     
	     System.out.println("\nExiba o dicionário ordenado pelo modelo: ");
		 Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1); //TreeMap ordena na ordem alfabetica.
		 System.out.println(carrosPopulares.toString());

	     System.out.println("\nApague o dicionario de carros: ");
	     carrosPopulares.clear();
  
	     System.out.println("\nConfira se o dicionário está vazio:\n" + carrosPopulares.isEmpty());

	}

}
