package SAGA;

import java.util.Comparator;

public class ComparadorDeProdutosPorString implements Comparator<Produto>{

	@Override
	public int compare(Produto produto1, Produto produto2) {
		return produto1.getNomeEDescricao().compareTo(produto2.getNomeEDescricao());
	}
	
}
