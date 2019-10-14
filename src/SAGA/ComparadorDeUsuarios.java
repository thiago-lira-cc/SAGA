package SAGA;

import java.util.Comparator;

public class ComparadorDeUsuarios implements Comparator<InterfaceUsuarios>{

	@Override
	public int compare(InterfaceUsuarios i1, InterfaceUsuarios i2) {
		return i1.getIdentificador().compareTo(i2.getIdentificador());
	}
}
