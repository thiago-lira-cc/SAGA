package SAGA;

import java.util.ArrayList;
/**
 * Representação de uma conta no sistema. Cada compra possui um a arrayList de compras.
 * @author Thiago Lira.
 *
 */
public class Conta {
	/**
	 * arrayList de compras.
	 */
	private ArrayList<Compra> compras;
	/**
	 * Constrói uma conta no sistema.
	 */
	public Conta() {
		this.compras = new ArrayList<Compra>();
	}
	/**
	 * Cadastra uma compra na conta.
	 * 
	 * @param data a data da compra
	 * @param nome_prod o nome do produto comprado
	 * @param desc_prod a descrição do produto
	 * @param preco o preço do produto.
	 * @param cliente 
	 * @param fornecedor 
	 */
	public void adicionaCompra(String data, String nome_prod, String desc_prod, double preco, String fornecedor, String cliente) {
		Compra compra = new Compra(data, nome_prod, desc_prod, preco, fornecedor, cliente);
		this.compras.add(compra);
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	/**
	 * Retorna a soma do preço das contas cadastradas
	 * @return double
	 */
	public double getDebito() {
		double soma = 0;
		for (Compra compra : compras) {
			soma += compra.getPreco();
		}
		return soma;
	}
	/**
	 * Exibe as contas cadastrads no aiatema.
	 * @return retorna a representação String das contas.
	 */
	public String exibeContas() {
		String resultado = "";
		for (int i = 0; i < this.compras.size(); i++) {
			if (i==this.compras.size()-1) {
				resultado += this.compras.get(i).toString();
			}else {
				resultado += this.compras.get(i).toString() + " | ";
			}
		}
		return resultado;
	}

}
