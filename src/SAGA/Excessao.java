package SAGA;

public class Excessao {

	public void verificaStringVazia(String valor, String msg) {
		if("".equals(valor)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void verificaStringNula(String valor, String msg) {
		if(valor==null) {
			throw new NullPointerException(msg);
		}
	}
	
}
