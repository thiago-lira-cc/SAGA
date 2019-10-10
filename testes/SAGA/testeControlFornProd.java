package SAGA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeControlFornProd {

private ControllerFornecedorProduto controlFornProd;
	
	@BeforeEach
	public void criaFachada() {
		controlFornProd = new ControllerFornecedorProduto();
		controlFornProd.cadastrarFornecedor("Inês Brasil", "inesxuxu@mail.com", "8954-3275");
		controlFornProd.cadastrarProduto("Inês Brasil", "Suco", "Suco de laranja", 1.50);
		
	}
	
	@Test
	public void testAdicionaFornecedor() {
		assertEquals("Birigim", controlFornProd.cadastrarFornecedor("Birigim", "birgim@mail.com", "9955-2314"));
		assertEquals("Fornecedor já cadastrado!", controlFornProd.cadastrarFornecedor("Inês Brasil", "deusa@mail.com", "6669-7778"));
	}
	
	@Test
	public void testRetornaFornecedor() {
		assertEquals("Inês Brasil - inesxuxu@mail.com - 8954-3275", controlFornProd.retornarFornecedor("Inês Brasil"));
		assertEquals("Fornecedor não cadastrado!", controlFornProd.retornarFornecedor("Irineu"));
	}
	
	@Test
	public void testRetornaFornecedores() {
		assertEquals("Inês Brasil - inesxuxu@mail.com - 8954-3275 | ", controlFornProd.retornarFornecedores());
	}
	
	@Test
	public void testEditarFornecedor() {
		assertEquals("Inês Brasil - inesxuxu@mail.com - 8954-3275", controlFornProd.retornarFornecedor("Inês Brasil"));
		assertEquals(true, controlFornProd.editarFornecedor("Inês Brasil", "inesbr@mail.com", "5689-7812"));
		assertEquals("Inês Brasil - inesbr@mail.com - 5689-7812", controlFornProd.retornarFornecedor("Inês Brasil"));
	}
	
	@Test
	public void testRemoveFornecedor() {
		assertEquals(true, controlFornProd.removerFornecedor("Inês Brasil"));
		assertEquals(false, controlFornProd.removerFornecedor("Inês Brasil"));
	}
	
	@Test
	public void testAdicionaProduto() {
		controlFornProd.cadastrarFornecedor("Inês Brasil", "inesxuxu@mail.com", "8954-3275");
		assertEquals(true, controlFornProd.cadastrarProduto("Inês Brasil", "Suco", "Suco de morango", 1.50));
		assertEquals(false, controlFornProd.cadastrarProduto("Clodovil", "Suco", "Suco de uva", 1.50));
		assertEquals(false, controlFornProd.cadastrarProduto("Inês Brasil", "Suco", "Suco de laranja", 1.50));
	}
	
	@Test
	public void testRetornaProduto() {
		assertEquals("Inês Brasil - Suco - Suco de laranja - 1.50", controlFornProd.retornarProduto("Inês Brasil", "Suco", "Suco de laranja"));
	}
	
	@Test
	public void testRetornaProdutosFornecedor() {
		assertEquals("Inês Brasil - Suco - Suco de laranja - 1.50 | ", controlFornProd.retornarProdutosFornecedor("Inês Brasil"));
		controlFornProd.cadastrarProduto("Inês Brasil", "Suco", "Suco de uva", 1.50);
		assertEquals("Inês Brasil - Suco - Suco de laranja - 1.50 | Suco - Suco de uva - 1.50 | ", controlFornProd.retornarProdutosFornecedor("Inês Brasil"));
	}
	
	@Test
	public void testRetornaProdutos() {
		controlFornProd.cadastrarFornecedor("Jurubinha", "jurubinhadoce@mail.com", "5684-7213");
		controlFornProd.cadastrarProduto("Jurubinha", "jujuba", "jujubas mistas", 1.00);
		assertEquals("Inês Brasil - Suco - Suco de laranja - 1.50 | Jurubinha - jujuba - jujubas mistas - 1,00 | ", controlFornProd.retronarProdutos());
	}
	
	@Test
	public void testEditarProduto() {
		assertEquals("Inês Brasil - Suco - Suco de laranja - 1.50", controlFornProd.retornarProduto("Inês Brasil", "Suco", "Suco de laranja"));
		assertEquals(true, controlFornProd.editarProduto("Inês Brasil", "Suco", "Suco de laranja", 2.00));
		assertEquals("Inês Brasil - Suco - Suco de laranja - 2.00", controlFornProd.retornarProduto("Inês Brasil", "Suco", "Suco de laranja"));
	}
	
	@Test
	public void testRemoveProduto() {
		assertEquals(true, controlFornProd.removerProduto("Inês Brasil", "Suco", "Suco de laranja"));
		assertEquals(false, controlFornProd.removerProduto("Inês Brasil", "Suco", "Suco de laranja"));
	}

}
