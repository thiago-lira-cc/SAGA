package SAGA;

import java.util.HashMap;
/*
 * Classe responsável pelas operações com Cliente
 * Adiciona cliente
 * Retorna cliente
 * Retorna todos os clientes
 * Edita cliente
 * Remove cliente
 */
public class ControllerCliente {

	/*
	 * Mapa de clientes identificados pelo cpf - chave-, que guarda objetos Cliente
	 */
	private HashMap<String, Cliente> clientes;
	private Excecao excessao;
	/*
	 * Construtor que inicia o mapa de clientes
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
		this.excessao  = new Excecao();
	}

	/*
	 * Método de cadastro de clientes
	 * Recebe cpf, nome, email e localização do cliente
	 * Se o cadastro foi realizado retorna o cpf do cliente
	 * 
	 * @param String cpf
	 * @param String nome
	 * @param String email
	 * @param String localizacao
	 * 
	 * @return String
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		//Verifica se o cliente já está cadastrado
		if(!clientes.containsKey(cpf)) {
			excessao.verificaCpfCadastro(cpf);
			//Se não, cria o cliente
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			//Adiciona no mapa
			clientes.put(cpf, cliente);
			//Retorna o cpf
			return cpf;
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
	}
	/*
	 * Método que retorna - mostra - um cliente pelo cpf
	 * 
	 * Verifica se o cliente está cadastrado e retorna a representação de Cliente
	 * 
	 * @param String cpf
	 * 
	 * @return String no format "Nome - Email - Localização"
	 */
	public String exibeCliente(String cpf) {
		String msg = "Erro na exibicao do cliente: cliente nao existe.";
		excessao.verificaCpf(cpf, "exibicao");
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}
		throw new IllegalArgumentException(msg);
	}
	
	/*
	 * Método que retorna todos os clientes cadastrados
	 * 
	 * Percorre o mapa de clientes e gera uma representação de cada Cliente
	 * 
	 * @return todos os clientes separados por " | "
	 */
	public String retornarClientes() {
		String resultado = "";
		for (String cliente : clientes.keySet()) {
			resultado += clientes.get(cliente).toString()+" | ";
		}
		return resultado;
	}
	/*
	 * Método que altera o nome, email e localização do Cliente pelo cpf
	 * 
	 * Verifica se o cliente está cadastrado e altera
	 * 
	 * @param String cpf
	 * @param String nome
	 * @param String email
	 * @param String loocalizacao
	 * 
	 * @return true ou false
	 */
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		boolean resultado = false;
		excessao.verificaCpf(cpf, "edicao");;
		if (clientes.containsKey(cpf)) {
			excessao.verificaEdita(atributo, novoValor);
			if (atributo.equals("nome")) {
				clientes.get(cpf).setNome(novoValor);
			}else
			if (atributo.equals("email")) {
				clientes.get(cpf).setEmail(novoValor);
			}else
			if (atributo.equals("localizacao")) {
				clientes.get(cpf).setLocalizacao(novoValor);
			}else{
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		return resultado;
	}
	/*
	 * Método que remove um cliente do mapa de clientes
	 * 
	 * Verifica se o cliente existe e remove
	 * 
	 * @param String cpf
	 * 
	 * @return true ou false
	 */
	public boolean remover(String cpf) {
		boolean resultado = false;
		excessao.verificaCpfRemove(cpf);
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}	
		return resultado;
	}

}
