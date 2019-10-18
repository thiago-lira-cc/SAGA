package SAGA;

/**
 * Fachada do sistema. Dispõe de todos os seus métodos.
 * @author Thiago Lira
 *
 */
public class Facade {

	private ControllerCliente controleClientes;
	private ControllerFornecedor controleFornecedores;
	private ControllerProduto controleProdutos;
	private ControllerConta controlContas;

	/**
	 * Construtor que inicializa os controllers do sistema.
	 */
	public Facade() {
		this.controleClientes = new ControllerCliente();
		this.controleFornecedores = new ControllerFornecedor();
		this.controleProdutos = new ControllerProduto(controleFornecedores);
		this.controlContas = new ControllerConta(controleClientes, controleFornecedores);
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
		return controleFornecedores.cadastrarFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return controleFornecedores.retornarFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return controleFornecedores.retornarFornecedores();
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novoValor) {
		return controleFornecedores.editarFornecedor(nome, atributo, novoValor);
	}
	
	public boolean removeFornecedor(String nome) {
		return controleFornecedores.removerFornecedor(nome);
	}
	
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		return controleProdutos.cadastrarProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return controleProdutos.retornarProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
	
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return controleProdutos.retornarProdutosFornecedor(nomeFornecedor);
	}
	
	public String exibeProdutos() {
		return controleProdutos.retronarProdutos();
	}
	
	public boolean editaProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor,double novoPreco) {
		return controleProdutos.editarProduto(nomeProduto, descricaoProduto, nomeFornecedor, novoPreco);
	}
	
	public boolean removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		return controleProdutos.removerProduto(nomeProduto, descricaoProduto, nomeFornecedor);
	}
	
	public boolean adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		return controleProdutos.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public boolean adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		return controlContas.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return controlContas.getDebito(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return controlContas.exibeConta(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return controlContas.exibeContasClientes(cpf);
	}

}
