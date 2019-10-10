package SAGA;

public class Excecao {

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

	public void verificaPreco(double precoProduto, String msg) {
		if(precoProduto<0) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	
}
