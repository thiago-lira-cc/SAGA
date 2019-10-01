package SAGA;

import java.util.HashMap;

public class ControllerCliente {

	private HashMap<String, Cliente> clientes;
	
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}

	public String adicionar(String cpf, String nome, String email, String localizacao) {
		String resultado = "Cliente já cadastrado!";
		if(nome==null) {
			resultado = "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.";
		}else if(nome.equals("")) {
			resultado = "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.";
		}else if(!clientes.containsKey(cpf)) {
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			clientes.put(cpf, cliente);
			resultado = cpf;
		}
		return resultado;
	}

	public String retornar(String cpf) {
		String resultado = "Cliente não encontrado!";
		if (clientes.containsKey(cpf)) {
			resultado = clientes.get(cpf).toString();
		}
		return resultado;
	}
	
	public String retornarClientes() {
		String resultado = "";
		for (String cliente : clientes.keySet()) {
			resultado += clientes.get(cliente).toString()+" | ";
		}
		return resultado;
	}

	public boolean editar(String cpf, String nome, String email, String localizacao) {
		boolean resultado = false;
		if (clientes.containsKey(cpf)) {
			clientes.get(cpf).altera(nome, email, localizacao);
			resultado = true;
		}
		return resultado;
	}

	public boolean remover(String cpf) {
		boolean resultado = false;
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			resultado = true;
		}
		return resultado;
	}

}
