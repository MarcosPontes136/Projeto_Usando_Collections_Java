package Exemplo_Map;

import java.security.PublicKey;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);
Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
*/

public class ExemploOrdenacaoMap {
	public static void main(String[] args) {
		
		System.out.println("--\tOrdem aleatoria\t--\n");
		
		Map<String, Livro> meusLivros = new HashMap<>() {{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		for(Map.Entry<String, Livro> livro : meusLivros.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " +livro.getValue().getPaginas());
		
		System.out.println("\n--\tOrdem Inserção\t--\n");
		Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		for(Map.Entry<String, Livro> livro : meusLivros1.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " +livro.getValue().getPaginas());
		
		System.out.println("\n--\tOrdem dos Autores\t--\n");
		Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for(Map.Entry<String, Livro> livro : meusLivros2.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " +livro.getValue().getPaginas());

		System.out.println("\n--\tOrdem alfabetica dos livros\t--\n");
		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		meusLivros3.addAll(meusLivros.entrySet());
		for(Map.Entry<String, Livro> livro : meusLivros3)
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " +livro.getValue().getPaginas());
		
		System.out.println("\n--\tOrdem por paginas\t--\n");
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
		meusLivros4.addAll(meusLivros.entrySet());
		for(Map.Entry<String, Livro> livro : meusLivros4)
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " +livro.getValue().getPaginas());
		
	}

}

class Livro{
	private String nome;
	private Integer paginas;

	public Livro(String nome, Integer paginas) {
		this.nome = nome;
		this.paginas = paginas;
	}
	
	public String getNome() {
		return nome;
	}
	public Integer getPaginas() {
		return paginas;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
	
	@Override
	public int compare(Map.Entry<String, Livro> L1, Map.Entry<String, Livro> L2) {
		return L1.getValue().getNome().compareToIgnoreCase(L2.getValue().getNome());
	}
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{
	
	@Override
	public int compare(Map.Entry<String, Livro> P1, Map.Entry<String, Livro> P2) {
		return Integer.compare(P1.getValue().getPaginas(), P2.getValue().getPaginas());
	}
}


