package SAGA;

import java.util.Comparator;

public class ComparadorDeFornecedoresPorString implements Comparator<Fornecedor> {

	@Override
	public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
		return fornecedor1.getNome().compareTo(fornecedor2.getNome());
	}

}
