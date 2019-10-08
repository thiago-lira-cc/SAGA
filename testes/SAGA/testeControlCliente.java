package SAGA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeControlCliente {
	
	private ControllerCliente controlCli;
	
	@BeforeEach
	public void criaFachada() {
		controlCli = new ControllerCliente();
		//controlCli.adicionar("123", "João Belo", "joao.belo@mail.com", "SPLAB");
	}
	
	@Test
	public void testAdicionaCliente() {
		//assertEquals("159", controlCli.adicionar("159", "João", "joao@mail.com", "SPLAB"));
		//assertEquals("Cliente já cadastrado!", controlCli.adicionar("123", "João Belo", "joao.belo@mail.com", "SPLAB"));
	}
	
	@Test
	public void testRetornaCliente() {
		assertEquals("João Belo - SPLAB - joao.belo@mail.com", controlCli.exibeCliente("123"));
		assertEquals("Cliente não encontrado!", controlCli.exibeCliente("789"));
	}
	
	@Test
	public void testRetornaClientes() {
		assertEquals("João Belo - SPLAB - joao.belo@mail.com | ", controlCli.retornarClientes());
	}
	
	@Test
	public void testEditarCliente() {
		assertEquals("João Belo - SPLAB - joao.belo@mail.com", controlCli.exibeCliente("123"));
		//assertEquals(true, controlCli.editar("123", "Roberval", "roberval@boll.com", "CX"));
		assertEquals("Roberval - CX - roberval@boll.com", controlCli.exibeCliente("123"));
	}
	
	@Test
	public void testRemoveCliente() {
		assertEquals(true, controlCli.remover("123"));
		assertEquals(false, controlCli.remover("753"));
	}

}
