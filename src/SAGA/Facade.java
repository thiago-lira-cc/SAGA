package SAGA;

public class Facade {

	private ControllerCliente controleClientes;
	
	public Facade(ControllerCliente controlCli) {
		this.controleClientes = new ControllerCliente();
	}

	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		return controleClientes.cadastra(cpf, nome, email, localizacao);
	}
	
	public String retornaCliente(String cpf) {
		return controleClientes.retornar(cpf);
	}
	
	public boolean editaCliente() {
		return controleClientes.editar();
	}
	
	public boolean removeCliente() {
		return controleClientes.remove();
	}
	
}
