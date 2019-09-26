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
	
	public boolean editaCliente(String cpf, String nome, String email, String localizacao) {
		return controleClientes.editar(cpf, nome, email, localizacao);
	}
	
	public boolean removeCliente(String cpf) {
		return controleClientes.remove(cpf);
	}
	
}
