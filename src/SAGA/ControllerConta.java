package SAGA;

public class ControllerConta {
	private Excecao excecao;
	private ControllerCliente controlClientes;
	private ControllerFornecedor controlFornecedores;


	public ControllerConta(ControllerCliente controlClientesFacade, ControllerFornecedor controlFornProdFacade) {
		this.excecao = new Excecao();
		this.controlClientes  = controlClientesFacade;
		this.controlFornecedores = controlFornProdFacade;

	}
	
	public boolean adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		excecao.verificaStringNula(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		excecao.verificaStringNula(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		excecao.verificaData(data);
		excecao.verificaStringNula(nome_prod, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome_prod, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(desc_prod, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(desc_prod, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
	
		if (this.controlClientes.getClientes().containsKey(cpf)) {
			if (this.controlFornecedores.getFornecedores().containsKey(fornecedor)) {
				ProdutoSimples produto = new ProdutoSimples(nome_prod, desc_prod);
				Cliente cliente = this.controlClientes.getClientes().get(cpf);
				return this.controlFornecedores.getFornecedores().get(fornecedor).adicionaCompra(cliente, data, nome_prod, desc_prod, this.controlFornecedores.getFornecedores().get(fornecedor).getPrecoProd(produto));	
			}else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}
		}else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}

	public String getDebito(String cpf, String fornecedor) {
		excecao.verificaStringNula(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		excecao.verificaStringNula(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (this.controlFornecedores.getFornecedores().containsKey(fornecedor)) {
			if (this.controlClientes.getClientes().containsKey(cpf)) {
				return this.controlFornecedores.getFornecedores().get(fornecedor).getDebito(this.controlClientes.getClientes().get(cpf));
			}
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
	}

	public String exibeConta(String cpf, String fornecedor) {
		excecao.verificaStringNula(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		excecao.verificaStringNula(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if (this.controlFornecedores.getFornecedores().containsKey(fornecedor)) {
			if (this.controlClientes.getClientes().containsKey(cpf)) {
				return "Cliente: "+this.controlClientes.getClientes().get(cpf).getNome()+" | "+this.controlFornecedores.getFornecedores().get(fornecedor).getNome()+" | "+this.controlFornecedores.getFornecedores().get(fornecedor).exibeContas(this.controlClientes.getClientes().get(cpf));
			}
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
	}
	
	public String exibeContasClientes(String cpf) {
		excecao.verificaStringNula(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		boolean temContas = false;
		
		if (this.controlClientes.getClientes().containsKey(cpf)) {			
			String resultado = "Cliente: "+controlClientes.getClientes().get(cpf).getNome();
			for (String fornecedor : controlFornecedores.getChaves()) {
				if (controlFornecedores.getFornecedores().get(fornecedor).contemConta(controlClientes.getClientes().get(cpf))) {
					temContas = true;
					resultado += " | "+
							fornecedor +" | "+
							this.controlFornecedores.getFornecedores().get(fornecedor)
							.exibeContas(controlClientes.getClientes().get(cpf));
				}
			}
			if (temContas==false) {
				throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
			}else {
				return resultado;
			}
		}
		
		throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		
	}

}
