package SAGA;

public class Facade {

	private ControllerCliente controleClientes;
	private ControllerFornecedorProduto controleFornecedoresProdutos;
	
	public Facade() {
		this.controleClientes = new ControllerCliente();
		this.controleFornecedoresProdutos = new ControllerFornecedorProduto();
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return controleClientes.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return controleClientes.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return controleClientes.retornarClientes();
	}
	
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		return controleClientes.editaCliente(cpf, atributo, novoValor);
	}
	
	public boolean removeCliente(String cpf) {
		return controleClientes.remover(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controleFornecedoresProdutos.cadastrarFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return controleFornecedoresProdutos.retornarFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return controleFornecedoresProdutos.retornarFornecedores();
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novoValor) {
		return controleFornecedoresProdutos.editarFornecedor(nome, atributo, novoValor);
	}
	
	public boolean removeFornecedor(String nome) {
		return controleFornecedoresProdutos.removerFornecedor(nome);
	}
	
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		return controleFornecedoresProdutos.cadastrarProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return controleFornecedoresProdutos.retornarProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
	
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return controleFornecedoresProdutos.retornarProdutosFornecedor(nomeFornecedor);
	}
	
	public String exibeProdutos() {
		return controleFornecedoresProdutos.retronarProdutos();
	}
	
	public boolean editaProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor,double novoPreco) {
		return controleFornecedoresProdutos.editarProduto(nomeProduto, descricaoProduto, nomeFornecedor, novoPreco);
	}
	
	public boolean removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return controleFornecedoresProdutos.removerProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}

}
