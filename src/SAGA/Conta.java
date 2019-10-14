package SAGA;

import java.util.ArrayList;

public class Conta {
	
	private ArrayList<Compra> compras;
	
	public Conta() {
		this.compras = new ArrayList<Compra>();
	}

	public void adicionaCompra(String data, String nome_prod, String desc_prod, double preco) {
		Compra compra = new Compra(data, nome_prod, desc_prod, preco);
		this.compras.add(compra);
	}

	public String getDebito() {
		double soma = 0;
		for (Compra compra : compras) {
			soma += compra.getPreco();
		}
		String resul = String.format("%.2f", soma);
		return resul.replace(",", ".");
	}

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
