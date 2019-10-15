package SAGA;

import java.util.Comparator;
/**
 * Classe responsável por comparar os usuáros no sistema.
 * @author Thiago Lira.
 *
 */
public class ComparadorDeUsuarios implements Comparator<InterfaceUsuarios>{

	@Override
	public int compare(InterfaceUsuarios i1, InterfaceUsuarios i2) {
		return i1.getIdentificador().compareTo(i2.getIdentificador());
	}
}
