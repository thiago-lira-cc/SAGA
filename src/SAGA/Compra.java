package SAGA;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	private String fornecedor;
	private String cliente;
	
	/**
	 * Construtor da Compra
	 * @param data
	 * @param nome_prod
	 * @param desc_prod
	 * @param preco
	 * @param cliente 
	 * @param fornecedor 
	 */
	public Compra(String data, String nome_prod, String desc_prod, double preco, String fornecedor, String cliente) {
		this.data = data;
		this.nome_prod = nome_prod;
		this.desc_prod = desc_prod;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.cliente = cliente;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public String getCliente() {
		return cliente;
	}

	public LocalDate getDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d = LocalDate.parse(data, formatter);
		return d;
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
		return desc_prod +", "+data;
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

	public int compare(Compra o2) {
		if (getDate().isBefore(o2.getDate())) {
			return -1;
		}else if (getDate().isEqual(o2.getDate())) {
			return (getCliente()+","+getFornecedor()+","+getDesc_prod()).compareTo(o2.getCliente()+","+o2.getFornecedor()+","+o2.getDesc_prod());
		}else{
			return 1;
		}
	}

}
