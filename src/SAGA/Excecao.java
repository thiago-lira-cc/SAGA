package SAGA;

public class Excecao {

	public void verificaStringVazia(String valor, String msg) {
		if("".equals(valor)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void verificaStringNula(String valor, String msg) {
		if(valor==null) {
			throw new NullPointerException(msg);
		}
	}
	
	public void verificaCpfCadastro(String cpf) {
		if(cpf==null) {
			throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if(cpf.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if(cpf.length()!=11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
	}
	
	public void verificaCpf(String cpf, String funcao) {
		if(cpf==null) {
			throw new NullPointerException("Erro na "+funcao+" do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if(cpf.equals("")) {
			throw new IllegalArgumentException("Erro na "+funcao+" do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	public void verificaCpfRemove(String cpf) {
		if(cpf==null) {
			throw new NullPointerException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
		if(cpf.equals("")) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
	}
	
	public void verificaEdita(String atributo, String novoValor) {
		if (atributo==null) {
			throw new NullPointerException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}else
		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}else
		if (atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		
		if (novoValor==null) {
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}else
		if (novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	public void verificaNomeCadastro(String nome) {
		if(nome==null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}
	public void verificaNome(String nome, String funcao) {
		if(nome==null) {
			throw new NullPointerException("Erro na "+funcao+" do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(nome.equals("")) {
			throw new IllegalArgumentException("Erro na "+funcao+" do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}

	public void verificaFornecedor(String nome, String email, String telefone) {
		if (nome==null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email==null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone==null) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		if (telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}

	public static void veriEditaForn(String atributo, String novoValor) {
		// TODO Auto-generated method stub
		
	}

	public void verificaPreco(double precoProduto, String msg) {
		if(precoProduto<0) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	
}
