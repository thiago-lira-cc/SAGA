package SAGA;

import java.util.Comparator;

public class ComparadorDeComprasPorData implements Comparator<Compra>{

	public int compare(Compra o1, Compra o2) {
	    return o1.compare(o2);
	}
}
