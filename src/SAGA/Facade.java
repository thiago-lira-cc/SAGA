package SAGA;

public class Facade {

	private ControllerCliente controleClientes;
	private ControllerFornecedorProduto controleFornecedoresProdutos;
	
	public Facade() {
		this.controleClientes = new ControllerCliente();
		this.controleFornecedoresProdutos = new ControllerFornecedorProduto();
	}

	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		return controleClientes.cadastrar(cpf, nome, email, localizacao);
	}
	
	public String retornaCliente(String cpf) {
		return controleClientes.retornar(cpf);
	}
	
	public String retornarClientes() {
		return controleClientes.retornarClientes();
	}
	
	public boolean editarCliente(String cpf, String nome, String email, String localizacao) {
		return controleClientes.editar(cpf, nome, email, localizacao);
	}
	
	public boolean removerCliente(String cpf) {
		return controleClientes.remover(cpf);
	}
	
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		return controleFornecedoresProdutos.cadastrarFornecedor(nome, email, telefone);
	}
	
	public String retornarFornecedor(String nome) {
		return controleFornecedoresProdutos.retornarFornecedor(nome);
	}
	
	public String retornarFornecedores() {
		return controleFornecedoresProdutos.retornarFornecedores();
	}
	
	public boolean editarFornecedor(String nome, String email, String telefone) {
		return controleFornecedoresProdutos.editarFornecedor(nome, email, telefone);
	}
	
	public boolean removerFornecedor(String nome) {
		return controleFornecedoresProdutos.removerFornecedor(nome);
	}
	
	public boolean cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, String precoProduto) {
		return controleFornecedoresProdutos.cadastrarProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String retornarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		return controleFornecedoresProdutos.retornarProduto(nomeFornecedor, nomeProduto, descricaoProduto);
	}
	
	public String retornarProdutosFornecedor(String nomeFornecedor) {
		return controleFornecedoresProdutos.retornarProdutosFornecedor(nomeFornecedor);
	}
	
	public String retornarProdutos() {
		return controleFornecedoresProdutos.retronarProdutos();
	}
	
	public boolean editarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, String precoProduto) {
		return controleFornecedoresProdutos.editarProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public boolean removerProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		return controleFornecedoresProdutos.removerProduto(nomeFornecedor, nomeProduto, descricaoProduto);
	}
}
