package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ControllerFornecedor {
	
	private Map<String, Fornecedor> fornecedores;
	private Excecao excecao;

	public ControllerFornecedor() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.excecao = new Excecao(); 
	}

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if(!fornecedores.containsKey(nome)) {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
			return nome;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	public String retornarFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString(); 
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}

	public String retornarFornecedores() {
		String resultado = "";
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores, new ComparadorDeUsuarios());
		for (int i = 0; i < fornecedores.size(); i++) {
			if (i==fornecedores.size()-1) {
				resultado += fornecedores.get(i).toString();
			}else {
				resultado += fornecedores.get(i).toString()+" | ";
			}
		}
		return resultado;
	}

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

	public Map<String, Fornecedor> getFornecedores() {
		return this.fornecedores;
	}

	public List<String> getChaves() {
		List<String> lista = new ArrayList<String>();
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores, new ComparadorDeUsuarios());
		for (Fornecedor fornecedor : fornecedores) {
			lista.add(fornecedor.getNome());
		}
		return lista;
	}
}
