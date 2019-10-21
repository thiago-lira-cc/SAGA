package SAGA;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * Classe responsável por determinar as excecões do sistema.
 * @author Thiago Lira.
 *
 */
public class Excecao {
	/**
	 * Método responsável por verificar se uma String/parâmetro está vazia.
	 * Se a String for vazia, o método apresenta uma mensagem de erro.
	 * @param valor o valor que será comparado à uma String vazia.
	 * @param msg a mensagem de erro.
	 */
	public void verificaStringVazia(String valor, String msg) {
		if("".equals(valor)) {
			throw new IllegalArgumentException(msg);
		}
	}
	/**
	 * Método responsável por verificar se algum parâmetro/atributo está nulo.
	 * @param valor o valor a ser comparado à null
	 * @param msg a mensagemm de erro.
	 */
	public void verificaStringNula(String valor, String msg) {
		if(valor==null) {
			throw new NullPointerException(msg);
		}
	}
	/**
	 * Método responsável por verificar se o cpf é válido.
	 * Se o tamanho do cpf for diferente de 11 ele é inválido.
	 * 
	 * @param cpf o cpf a ser verificado.
	 * @param msg a mensagem de erro a sex exibida se ele for inválido.
	 */
	public void verificaCpf(String cpf, String msg) {
		if(cpf.length()!=11) {
			throw new IllegalArgumentException(msg);
		}
	}
	/**
	 * Método responsável por verificar o preço do produto.
	 * Se o preço for negativo, ele é inválido.
	 * 
	 * @param precoProduto o preço a ser verificado.
	 * @param msg a mensagem de erro a ser exibida se o preço for invalido.
	 */
	public void verificaPreco(double precoProduto, String msg) {
		if(precoProduto<0) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	/**
	 * Método responsável por verificar se a data é valida.
	 * @param data e mensagem de erro.
	 */
	public void verificaData(String data) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(data, formatter);    
	      } catch (DateTimeParseException e) {
	    	  throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
	      }   
	   }
	/**
	 * Método responsável por verificar se o fator é válido.
	 * @param fator e msg de erro.
	 */
	public void verificaFator(double fator, String msg) {
		if (fator<=0|fator>=1) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	
}
