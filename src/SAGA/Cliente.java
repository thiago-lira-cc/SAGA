package SAGA;
/**
 * Representação de um cliente no sistema. Cada cliente possui cpf, nome, email e localização
 * @author Thiago Lira.
 *
 */
public class Cliente implements Comparable<Cliente> {
	
	private Excecao excecao = new Excecao();
	/**
	 * cpf do cliente
	 */
	private String cpf;
	/**
	 * nome do cliente
	 */
	private String nome;
	/**
	 * email do cliente
	 */
	private String email;
	/**
	 * localização do cliente
	 */
	private String localizacao;
	/**
	 * Constrói um cliente se nenhum dos parametros forem vazzzzi ou nulo
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		excecao.verificaStringNula(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		excecao.verificaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getNome() {
		return nome;
	}
	/**
	 * Representação textual do cliente no formato "nome - localização - email"
	 */
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

	@Override
	public int compareTo(Cliente outroCliente) {
		// TODO Auto-generated method stub
		return this.nome.compareTo(outroCliente.getNome());
	}

}
