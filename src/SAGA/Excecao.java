package SAGA;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Excecao {

	public void verificaStringVazia(String valor, String msg) {
		if("".equals(valor)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void verificaStringNula(String valor, String msg) {
		if(valor==null) {
			throw new NullPointerException(msg);
		}
	}

	public void verificaCpf(String cpf, String msg) {
		if(cpf.length()!=11) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void verificaPreco(double precoProduto, String msg) {
		if(precoProduto<0) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	
	public void verificaData(String data) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(data, formatter);    
	      } catch (DateTimeParseException e) {
	    	  throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
	      }   
	   }

	public void verificaFator(double fator, String msg) {
		if (fator<0|fator>=1) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	
}
