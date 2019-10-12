package SAGA;

public class ControllerConta {
	private Excecao excecao;
	private ControllerCliente controlClientes;
	private ControllerFornecedor controlFornProd;

	public ControllerConta(ControllerCliente controlClientesFacade, ControllerFornecedor controlFornProdFacade) {
		this.excecao = new Excecao();
		this.controlClientes  = controlClientesFacade;
		this.controlFornProd = controlFornProdFacade;
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
			if (this.controlFornProd.getFornecedores().containsKey(fornecedor)) {
				Produto produto = new Produto(nome_prod, desc_prod);
				if (this.controlFornProd.getFornecedores().get(fornecedor).getProdutos().contains(produto)) {
					return this.controlClientes.getClientes().get(cpf).adicionaConta(this.controlFornProd.getFornecedores().get(fornecedor), data, nome_prod, desc_prod);
				}else {
					throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
				}
			}else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}
		}else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}
	

}
