package SAGA;

import easyaccept.EasyAccept;
/**
 * Classe responsável pelos testes de aceitação.
 * @author Thiago Lira.
 *
 */
public class Main {
	public static void main(String[] args) {
		args = new String[] {"SAGA.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt",
				"testes_aceitacao/use_case_4.txt", "testes_aceitacao/use_case_6.txt", "testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_7.txt", "testes_aceitacao/use_case_8.txt"};
		EasyAccept.main(args);
	}
}
