package SAGA;

public interface InterfaceProdutos extends Comparable<InterfaceProdutos>{

	public String getIdentificador();

	public void setPreco(double novoPreco);

	public double getPreco();
	
	public String getTipo();

}
