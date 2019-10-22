package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe responsável pelas operações com Cliente
 * Adiciona cliente
 * Retorna cliente
 * Retorna todos os clientes
 * Edita cliente
 * Remove cliente
 */
public class ControllerCliente {

	/**
	 * Mapa de clientes identificados pelo cpf - chave-, que guarda objetos Cliente
	 */
	private HashMap<String, Cliente> clientes;
	private Excecao excecao;
	/**
	 * Construtor que inicia o mapa de clientes
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
		this.excecao  = new Excecao();
	}

	/**
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
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			//Adiciona no mapa
			clientes.put(cpf, cliente);
			//Retorna o cpf
			return cpf;
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
	}
	/**
	 * Método que retorna - mostra - um cliente pelo cpf
	 * 
	 * Verifica se o cliente está cadastrado e retorna a representação de Cliente
	 * 
	 * @param String cpf
	 * 
	 * @return String no format "Nome - Email - Localização"
	 */
	public String exibeCliente(String cpf) {
		excecao.verificaStringNula(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "cpf inválido.");
	
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Método que retorna todos os clientes cadastrados
	 * 
	 * Percorre o mapa de clientes e gera uma representação de cada Cliente
	 * 
	 * @return todos os clientes separados por " | "
	 */
	public String retornarClientes() {
		String resultado = "";
		List<Cliente> clientes = new ArrayList<>(this.clientes.values());
		Collections.sort(clientes);
		for (int i = 0; i < clientes.size(); i++) {
			if (i==clientes.size()-1) {
				resultado += clientes.get(i).toString();
			}else {
				resultado += clientes.get(i).toString()+" | ";
			}
		}
		return resultado;
	}
	/**
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
		excecao.verificaStringNula(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		if (clientes.containsKey(cpf)) {
			excecao.verificaStringNula(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
			if (atributo.equals("nome")) {
				clientes.get(cpf).setNome(novoValor);
			}else
			if (atributo.equals("email")) {
				clientes.get(cpf).setEmail(novoValor);
			}else
			if (atributo.equals("localizacao")) {
				clientes.get(cpf).setLocalizacao(novoValor);
			}else
			if(atributo.equals("cpf")){
				throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
			}else {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		return resultado;
	}
	/**
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
		excecao.verificaStringNula(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		excecao.verificaStringVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}	
		return resultado;
	}
	/**
	 * Método que retorna o mapa de clientes cadastrados
	 * 
	 */
	public Map<String, Cliente> getClientes() {
		return this.clientes;
	}

}
