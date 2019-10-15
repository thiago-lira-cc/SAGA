package SAGA;

import java.util.Comparator;
/**
 * Classe responsável por comparar os produtos no sitema.
 * @author Thiago Lira.
 *
 */
public class ComparadorDeProdutos implements Comparator<InterfaceProdutos>{

	@Override
	public int compare(InterfaceProdutos i1, InterfaceProdutos i2) {
		return i1.getIdentificador().compareTo(i2.getIdentificador());
	}
}
