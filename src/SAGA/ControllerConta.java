package SAGA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsável pelas operações com Conta.
 * Adiciona compra
 * Exibe conta
 * Exibe todas as contas
 * @author Thiago Lira.
 *
 */
public class ControllerConta {
	private Excecao excecao;
	private ControllerCliente controlClientes;
	private ControllerFornecedor controlFornecedores;
	private String criterio;

	/**
	 * Construtor do controller.
	 * @param controlClientesFacade
	 * @param controlFornProdFacade
	 */
	public ControllerConta(ControllerCliente controlClientesFacade, ControllerFornecedor controlFornProdFacade) {
		this.excecao = new Excecao();
		this.controlClientes  = controlClientesFacade;
		this.controlFornecedores = controlFornProdFacade;
		this.criterio = null;

	}
	/**
	 * Adiciona uma compra ao sistema.
	 * Lança as mensagens de exceção do sistema. Os parâmetros recebidos não podem ser vazios ou nulos e, tanto o fornecedor quanto o cliente têm que existir.
	 * @param cpf
	 * @param fornecedor
	 * @param data
	 * @param nome_prod
	 * @param desc_prod
	 * @return
	 */
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
				ProdutoId produto = new ProdutoId(nome_prod, desc_prod);
				Cliente cliente = this.controlClientes.getClientes().get(cpf);
				return this.controlFornecedores.getFornecedores().get(fornecedor).adicionaCompra(cliente, data, nome_prod, desc_prod, this.controlFornecedores.getFornecedores().get(fornecedor).getPrecoProd(produto));	
			}else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}
		}else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}
	/**
	 * Método que retorna o débito do cliente
	 * 
	 * O débito é o somatório do preço de todas as compras, realizadas, ou seja, que estão anotados naquela conta. 
	 * 
	 */
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
	/**
	 * Exibe uma conta do sistema.
	 * Lança as mensagens de exceção do sistema. Os parâmetros recebidos não podem ser vazios ou nulos e, tanto o fornecedor quanto o cliente têm que existir.
	 * @param cpf o cpf 
	 * @param fornecedor o fornecedor.
	 * @return Retorna a representação String da conta desejada.
	 */
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
	/**
	 * Exibe as contas de um cliente.
	 * @param cpf o cpf do cliente
	 * @return retorna a representação String das contas do cliente.
	 */
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
	public boolean realizaPagamento(String cpf, String fornecedor) {
		excecao.verificaStringNula(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		excecao.verificaCpf(cpf, "Erro no pagamento de conta: cpf invalido.");
		excecao.verificaStringNula(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		if (controlFornecedores.getFornecedores().containsKey(fornecedor)) {
			if (controlClientes.getClientes().containsKey(cpf)) {
				return controlFornecedores.getFornecedores().get(fornecedor).realizaPagamento(controlClientes.getClientes().get(cpf));
			}
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		}
		throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
	}
	
	public void setCriterio(String criterio) {
		excecao.verificaStringNula(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		this.criterio = criterio;
	}

	public String getCriterio() {
		return this.criterio;
	}
	public String listarCompras() {
		String resultado = "";
		if (this.criterio==null) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}else if(this.criterio.equals("Cliente")){
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes.addAll(controlClientes.getClientes().values());
			
			Collections.sort(clientes);
			
			for (Cliente cliente : clientes) {
				resultado += cliente.getNome()+", ";
			}
			return resultado;
			
		}else {
			return null;
		}
		
	}
}
