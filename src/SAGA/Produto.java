package SAGA;

public interface Produto extends Comparable<Produto>{

	String getIdentificador();

	double getPreco();

	void setPreco(double novoValor);

	String getTipo();

	String getNome();
	
}
