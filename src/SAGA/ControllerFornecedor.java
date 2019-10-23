package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pelas operações com Fornecedor
 * Adiciona fornecedor
 * Retorna fornecedor
 * Retorna todos os fornecedores
 * Editafornecedor
 * Remove fornecedor
 */
public class ControllerFornecedor {
	/**
	 * Mapa de fornecedores.
	 */
	private Map<String, Fornecedor> fornecedores;
	/**
	 * Classe de exceções
	 */
	private Excecao excecao;

	/**
	 * Construtor que inicializa o mapa de fornecedores.
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.excecao = new Excecao(); 
	}
	/**
	 * Método de cadastro de fornecedores.
	 * Recebe nome, email e telefone do fornecedor.
	 * Se o cadastro foi realizado retorna o nome do fornecedor.
	 * 
	 * @param nome o nome do fornecedor.
	 * @param email o email do fornecedor.
	 * @param telefone o telefone do fornecedor.
	 * 
	 * @return String
	 */
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if(!fornecedores.containsKey(nome)) {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
			return nome;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	/**
	 * Método que retorna - mostra - um fornecedor pelo nome.
	 * 
	 * Verifica se o fornecedor está cadastrado e retorna a representação de Fornecedor
	 * 
	 * @param String nome
	 * 
	 * @return String no format "Nome - Email - Telefone"
	 */
	public String retornarFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString(); 
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	/**
	 * 
	 * Método que retorna todos os fornecedores cadastrados
	 * 
	 * Percorre o mapa de fornecedores e gera uma representação de cada Fornecedor
	 * 
	 * @return todos os fornecedores separados por " | "
	 */
	public String retornarFornecedores() {
		String resultado = "";
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores);
		for (int i = 0; i < fornecedores.size(); i++) {
			if (i==fornecedores.size()-1) {
				resultado += fornecedores.get(i).toString();
			}else {
				resultado += fornecedores.get(i).toString()+" | ";
			}
		}
		return resultado;
	}
	/**
	 * /*
	 * Método que altera email e telefone do Fornecedor pelo nome
	 * 
	 * Verifica se o fornecedor está cadastrado e altera
	 * 
	 * @param String nome o oome do fornecedor (não pode ser alterado.)
	 * @param String atributo o atributo a ser alterado ( email ou telefone)
	 * @param String novoValor novo valor a ser atribuído.
	 * 
	 * @return true ou false
	 */
	public boolean editarFornecedor(String nome, String atributo, String novoValor) {
		boolean resultado = false;
		excecao.verificaStringNula(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nome)) {
			excecao.verificaStringNula(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			if(atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			}else
			if(atributo.equals("telefone")) {
				fornecedores.get(nome).setTelefone(novoValor);
			}else
			if(atributo.equals("email")) {
				fornecedores.get(nome).setEmail(novoValor);
			}else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		return resultado;
	}
	/**
	 * 
	 * Método que remove um fornecedor do mapa de fornecedores
	 * 
	 * Verifica se o cliente existe e remove
	 * 
	 * @param String nome
	 * 
	 * @return true ou false
	 */
	public boolean removerFornecedor(String nome) {
		boolean resultado = false;
		excecao.verificaStringNula(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		return resultado;
	}
	/**
	 * Método que retorna um mapa de fornnecedores
	 * @return Map
	 */
	public Map<String, Fornecedor> getFornecedores() {
		return this.fornecedores;
	}
	/**
	 * Método que retorna uma lista com os nomes dos fornecedores
	 * @return List
	 */
	public List<String> getChaves() {
		List<String> lista = new ArrayList<String>();
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores);
		for (Fornecedor fornecedor : fornecedores) {
			lista.add(fornecedor.getNome());
		}
		return lista;
	}
}
