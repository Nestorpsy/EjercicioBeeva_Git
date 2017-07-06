/**
 * 
 * @author Nestor Sandoval
 *
 */

package Java;
import java.util.Scanner;

public class principal {
	static int op = 0;
	static String nombre, apellido;
	
	public static void main(String[] args) {
		Banco banco = new Banco();		
		do{
			System.out.println("Que deceas hacer:\n"
					+ "1.-Nuevo cliente\n"
					+ "2.-Cuantos clientes existen\n"
					+ "3.-Ver un cliente por numero de cliente\n"
					+ "4.-Acceder a cuenta de Cuenta\n"
					+ "5.-Salir\n");
			op = extracted().nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Nombre: ");
				nombre = extracted().nextLine();
				System.out.println("Apellido: ");
				apellido = extracted().nextLine();
				CuentaAhorro ahorro = new CuentaAhorro(0.0);
				CuentaCheques cheques = new CuentaCheques(0.0);
				Cliente clientes = new Cliente(nombre, apellido, ahorro, cheques);
				banco.addCliente(clientes);
				break;				
			case 2:
				System.out.println(banco.getNClientes());
				break;
				
			case 3:
				System.out.println("# de Cliente que deseas consular");
				int numCliente=extracted().nextInt()-1;
				Cliente verCliente = banco.getCliente(numCliente);
				System.out.println("Nombre :"+verCliente.getNombre());
				break;
				
			case 4:
				System.out.println("A que # de cuenta desea acceder: ");
				int nCliente=extracted().nextInt()-1;				
				System.out.println("Bienvenido a tu cuenta "+banco.getCliente(nCliente).getNombre()+" "+banco.getCliente(nCliente).getApellido());
				System.out.println("A que cuenta desea entrar\n1.-Ahorro\n2.-Cheques");
				int cuenta = extracted().nextInt();
				do{
					System.out.println("Seleciona la operacion a realizar:");
					System.out.println("1.-Deposito\n2.-Retiro\n3.-Balance\n4.-Salir");
					op = extracted().nextInt();
					switch (op) {
		
					case 1:
						System.out.println("Cantidad a depositar:");				
						Double dep=extracted().nextDouble();
						if(cuenta==1){banco.getCliente(nCliente).getAhorro().deposito(dep);}
						if(cuenta==2){banco.getCliente(nCliente).getCheques().deposito(dep);}
						break;
		
					case 2:
						System.out.println("Cantidad a retirar:");
						Double ret=extracted().nextDouble();
						if(cuenta==1){if(banco.getCliente(nCliente).getAhorro().retiro(ret)){System.out.println("Correcto");}
						if(!banco.getCliente(nCliente).getAhorro().retiro(ret))System.out.println("No puedes retirar si: \nno tienes mas de $5000 en la cuenta");}
						if(cuenta==2){banco.getCliente(nCliente).getCheques().retiro(ret);}
						break;
		
					case 3:
						if(cuenta==1){System.out.println("Tu balance es de: "+banco.getCliente(nCliente).getAhorro().getBalance());}		
						if(cuenta==2){System.out.println("Tu balance es de: "+banco.getCliente(nCliente).getCheques().getBalance());}				
						break;
		
					case 4:
						System.out.println("Asta luego "+banco.getCliente(nCliente).getNombre()+" "+banco.getCliente(nCliente).getApellido());
						op=4;
						break;
		
					default:
						System.out.println("Opcion invalida");
						break;
					}
				}while(op!=4);				
				break;
				
			case 5:		
				System.out.println("Asta luego ");
				op=5;
				break;

			default:
				System.out.println("Opcion invalida");
				break;
			}	
		}while (op!=5);
	}
	private static Scanner extracted() {
		return new Scanner(System.in);
	}
}
