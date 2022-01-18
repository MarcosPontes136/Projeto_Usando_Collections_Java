package Exemplo_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
*/

public class ExemploOrdenacaoSet {
	public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{ //entra na ordem aleatoria
        	add(new Serie("Got", "Fantasia", 60));
        	add(new Serie("Dark", "Drama", 60));
        	add(new Serie("that' 70s show", "Comedia", 25));
        }};
        for(Serie serie : minhasSeries)System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio() + "\n");
        	
        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{ //entra na ordem que foi criado
        	add(new Serie("Got", "Fantasia", 60));
        	add(new Serie("Dark", "Drama", 60));
        	add(new Serie("that' 70s show", "Comedia", 25));
        }};
        for(Serie serie : minhasSeries1)System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio() + "\n");
        	
        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhaSeries2 = new TreeSet<>(minhasSeries1);
        for(Serie serie : minhaSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio() + "\n" );

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhaSeries3 = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());
        minhaSeries3.addAll(minhasSeries);
        for(Serie serie : minhaSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio() + "\n" );

	}

}

class Serie implements Comparable<Serie>{
	private String nome;
	private String genero;
	private Integer tempoEpisodio;
	
	
	public Serie(String nome, String genero, Integer tempoEpisodio) {
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}


	public String getNome() {
		return nome;
	}


	public String getGenero() {
		return genero;
	}


	public Integer getTempoEpisodio() {
		return tempoEpisodio;
	}


	@Override
	public String toString() {
		return "Serie [nome=" + nome + ", genero=" + genero + ", tempoEpisodio=" + tempoEpisodio + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(genero, nome, tempoEpisodio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Serie other = (Serie) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome)
				&& Objects.equals(tempoEpisodio, other.tempoEpisodio);
	}
	
	@Override
	public int compareTo(Serie serie) {
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if(tempoEpisodio != 0) return tempoEpisodio;
		
		return this.getGenero().compareTo(serie.getGenero());
	}
}

class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie>{
	
	@Override
	public int compare(Serie s1, Serie s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if(nome != 0)return nome;
		
		int genero = s2.getGenero().compareTo(s2.getGenero());
		if(genero != 0) return genero;
		
		return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
	}
}
