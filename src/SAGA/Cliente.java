package SAGA;

public class Cliente {
	
	private Excessao excessao = new Excessao();
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	public Cliente(String cpf, String nome, String email, String localizacao) {
		excessao.verificaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		excessao.verificaStringVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		excessao.verificaStringVazia(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		excessao.verificaStringVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		excessao.verificaStringNula(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		excessao.verificaStringNula(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		excessao.verificaStringNula(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		excessao.verificaStringNula(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return nome + " - " + localizacao + " - " + email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public void altera(String nomeNovo, String emailNovo, String localizacaoNova) {
		this.nome = nomeNovo;
		this.email = emailNovo;
		this.localizacao = localizacaoNova;
		
	}

}
