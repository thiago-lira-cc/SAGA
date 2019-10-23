package SAGA;
/**
 * Interface para reuso dos tipos Produto Simples e Produto Combo
 * @author Thiago Lira
 *
 */
public interface Produto extends Comparable<Produto>{
	/**
	 * 
	 * @return identificador de um produto "Nome + descrição"
	 */
	String getIdentificador();
	/**
	 * 
	 * @return preço de um produto
	 */
	double getPreco();
	/**
	 * Muda o preço ou fator de um produto
	 * @param novoValor
	 */
	void setPreco(double novoValor);
	/**
	 * 
	 * @return tipo de um produto
	 */
	String getTipo();
	/**
	 * 
	 * @return nome de um produto
	 */
	String getNome();
	
}
