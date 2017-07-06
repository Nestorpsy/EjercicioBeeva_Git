package Java;

public class Cuenta {
	protected Double balance;
	
	public Cuenta(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {			
		return balance;		
	}
	
	public void deposito(Double dep) {
		balance=balance+dep;
	}
	
	public boolean retiro(Double ret) {		
		boolean correcto=true;
		balance=balance-ret;
		if(balance<0){
			System.out.println("Retiro mayor al saldo en su cuenta");
			balance=balance+ret;	
			correcto=false;
		}
		return correcto;
	}	
	
}
