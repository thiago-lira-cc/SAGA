package SAGA;
/**
 * Representação de uma compra no sistema. Cada compra tem data, nome do produto, descrição do produto e preço do produto,
 * @author Thiago Lira.
 *
 */
public class Compra implements Comparable<Compra>{
	/**
	 * A data da compra.
	 */
	private String data;
	/**
	 * O nome do produto comprado.
	 */
	private String nome_prod;
	/**
	 * A descrição do produto.
	 */
	private String desc_prod;
	/**
	 * O preço do produto comprado.
	 */
	private double preco;
	/**
	 * Construtor da Compra
	 * @param data
	 * @param nome_prod
	 * @param desc_prod
	 * @param preco
	 */
	public Compra(String data, String nome_prod, String desc_prod, double preco) {
		this.data = data;
		this.nome_prod = nome_prod;
		this.desc_prod = desc_prod;
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getCompra() {
		return nome_prod +", "+data;
	}
	
	/**
	 * Representação textual de uma compra
	 */
	@Override
	public String toString() {		
		return nome_prod +" - "+data.replaceAll("/", "-");
	}

	@Override
	public int compareTo(Compra outraCompra) {
		return getCompra().compareTo(outraCompra.getCompra());
	}

}
