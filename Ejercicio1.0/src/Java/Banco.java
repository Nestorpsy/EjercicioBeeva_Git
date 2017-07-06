package Java;

public class Banco {
	private Cliente[] clientes = new Cliente[10];
	private int nClientes=0;		
	

	public boolean addCliente(Cliente clientes){	
		this.clientes[getNClientes()]= clientes;
		nClientes++;
		return false;
	}


	public int getNClientes(){
		System.out.println(nClientes);
		return nClientes;
	}
	
	public Cliente getCliente(int nCliente){
		Cliente getcliente = clientes[nCliente];		
		return getcliente;
	}
}
