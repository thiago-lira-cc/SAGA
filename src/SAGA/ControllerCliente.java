package SAGA;

import java.util.HashMap;

public class ControllerCliente {

	private HashMap<String, Cliente> clientes;
	
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}

	public String cadastra(String cpf, String nome, String email, String localizacao) {
		String resultado = "Cliente já cadastrado!";
		if(!clientes.containsKey(cpf)) {
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			clientes.put(cpf, cliente);
			resultado = cpf;
		}
		return resultado;
	}

	public String retornar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String retornarTodos() {
		return null;
	}

	public boolean editar() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}

}
