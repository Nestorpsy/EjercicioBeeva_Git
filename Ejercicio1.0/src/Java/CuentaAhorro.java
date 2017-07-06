package Java;

public class CuentaAhorro extends Cuenta{
	
	public CuentaAhorro(Double balance){
		super(balance);
	}
	
	public boolean retiro(Double ret){
		boolean ok=false;
		if(balance>5000){
			balance=balance-ret;
			ok=true;					
		}
		return ok;
	}
}
