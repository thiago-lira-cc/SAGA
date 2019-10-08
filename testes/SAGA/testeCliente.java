package SAGA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeCliente {

	private Cliente cliente;
	private Cliente cliente2;
	private Cliente cliente3;
	
	@BeforeEach
	public void criaCliente() {
		cliente = new Cliente("123", "Irineu", "vcnaosabe@nemeu.com", "LACAL");
		cliente2 = new Cliente("456", "Irineia", "vcnaosabe@eunaofacoideia.com", "SPLAB");
		cliente3 = new Cliente("123", "Valbeto", "vavazinho@ehmeiu.com", "IEEE");
	}
	
	@Test
	public void testToStringCliente() {
		assertEquals("Irineu - LACAL - vcnaosabe@nemeu.com", cliente.toString());
	}
	
	@Test
	public void testHasCodeCliente() {
		assertEquals(true, cliente.hashCode()==cliente3.hashCode());
		assertEquals(false, cliente.hashCode()==cliente2.hashCode());
	}
	
	@Test
	public void testEqualsCliente() {
		assertEquals(true, cliente.equals(cliente3));
		assertEquals(false, cliente.equals(cliente2));
	}

}
