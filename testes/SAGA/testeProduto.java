package SAGA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeProduto {

	private ProdutoSimples produto;
	private ProdutoSimples produto2;
	private ProdutoSimples produto3;
	
	@BeforeEach
	public void criaProduto() {
		//produto = new Produto("Suco", "Suco de laranja", "2.50");
		//produto2 = new Produto("Doce", "Doce de banana", "4.00");
		produto3 = new ProdutoSimples("Suco", "Suco de laranja");
	}
	
	@Test
	public void testToStringProduto() {
		assertEquals("Suco - Suco de laranja - 2.50", produto.toString());
	}
	
	@Test
	public void testHasCodeProduto() {
		assertEquals(true, produto.hashCode()==produto3.hashCode());
		assertEquals(false, produto.hashCode()==produto2.hashCode());
	}
	
	@Test
	public void testEqualsProduto() {
		assertEquals(true, produto.equals(produto3));
		assertEquals(false, produto.equals(produto2));
	}
	
	@Test
	public void testSetPreco() {
		assertEquals("Suco - Suco de laranja - 2.50", produto.toString());
		//produto.setPreco("1.50");
		assertEquals("Suco - Suco de laranja - 1.50", produto.toString());
	}


}
