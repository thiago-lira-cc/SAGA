package SAGA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeFornecedor {

	private Fornecedor fornecedor;
	private Fornecedor fornecedor2;
	private Fornecedor fornecedor3;
	
	@BeforeEach
	public void criaFornecedor() {
		fornecedor = new Fornecedor("Dona Benta", "dona@benta.com", "7894-1236");
		fornecedor2 = new Fornecedor("Jorginho", "jorginho@lokao.com", "5612-9832");
		fornecedor3 = new Fornecedor("Dona Benta", "bentinha@dela.com", "6578-1245");
		fornecedor.cadastraProduto("Farinha", "Farinha de trigo", 6.45);
	}
	
	@Test
	public void testToStringFornecedor() {
		assertEquals("Dona Benta - dona@benta.com - 7894-1236", fornecedor.toString());
	}
	
	@Test
	public void testHasCodeFornecedor() {
		assertEquals(true, fornecedor.hashCode()==fornecedor3.hashCode());
		assertEquals(false, fornecedor.hashCode()==fornecedor2.hashCode());
	}
	
	@Test
	public void testEqualsFornecedor() {
		assertEquals(true, fornecedor.equals(fornecedor3));
		assertEquals(false, fornecedor.equals(fornecedor2));
	}
	
	@Test
	public void testAlteraFornecedor() {
		assertEquals("Dona Benta - dona@benta.com - 7894-1236", fornecedor.toString());
		//fornecedor.alteraFornecedor("donabentinha@gmail.com", "4565-2312");
		assertEquals("Dona Benta - donabentinha@gmail.com - 4565-2312", fornecedor.toString());
	}
	
	@Test
	public void testCadastrarProduto() {
		//assertEquals(true, fornecedor.cadastraProduto("Farinha", "Farinha de trigo fementada", "6.45"));
		//assertEquals(false, fornecedor.cadastraProduto("Farinha", "Farinha de trigo", "6.45"));
	}
	
	@Test
	public void testContemProduto() {
		//Produto produto = new Produto("Farinha", "Farinha de trigo", "6.45");
		//assertEquals(true, fornecedor.contemProduto(produto));
		//Produto produto2 = new Produto("Arroz", "Arroz branco", "5.00");
		//assertEquals(false, fornecedor.contemProduto(produto2));
	}
	
	@Test
	public void testGetProduto() {
		ProdutoSimples produto = new ProdutoSimples("Farinha", "Farinha de trigo");
		assertEquals("Farinha - Farinha de trigo - 6.45", fornecedor.getProduto(produto));
	}
	
	@Test
	public void testRetornarProdutosFornecedor() {
		//fornecedor.cadastraProduto("Arroz", "Arroz branco", "4.00");
		assertEquals("Arroz - Arroz branco - 4.00 | Farinha - Farinha de trigo - 6.45 | ", fornecedor.retornaProdutosFornecedor());
	}
	
	@Test
	public void testEditarProduto() {
		ProdutoSimples produto = new ProdutoSimples("Farinha", "Farinha de trigo");
		assertEquals("Farinha - Farinha de trigo - 6.45", fornecedor.getProduto(produto));
		//assertEquals(true, fornecedor.editarProduto(produto, "5.00"));
		assertEquals("Farinha - Farinha de trigo - 5.00", fornecedor.getProduto(produto));
	}
	
	@Test
	public void testRemoverProduto() {
		ProdutoSimples produto = new ProdutoSimples("Farinha", "Farinha de trigo");
		assertEquals("Farinha - Farinha de trigo - 6.45", fornecedor.getProduto(produto));
		assertEquals(true, fornecedor.removerProduto(produto));
		assertEquals("", fornecedor.getProduto(produto));
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Dona Benta", fornecedor.getNome());
	}

}
