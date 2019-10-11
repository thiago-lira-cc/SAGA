package SAGA;

import java.util.Comparator;

public class Comparador implements Comparator<Interface>{

	@Override
	public int compare(Interface i1, Interface i2) {
		return i1.getIdentificador().compareTo(i2.getIdentificador());
	}
}
