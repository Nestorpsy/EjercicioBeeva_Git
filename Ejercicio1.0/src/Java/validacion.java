package Java;

public class validacion {
	public boolean isNumber(String numero){
		boolean esNumero = true;
		try {
			double x = Double.parseDouble(numero);
			System.out.println(x);
			return esNumero;
		} catch (Exception e) {
			System.out.println("No a insertado un numero");
			return esNumero = false;
		}		
	}
}
