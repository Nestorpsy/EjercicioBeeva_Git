package Java;

public class Cliente {
	private String Nombre,Apellido;
	//private Cuenta cuenta;
	private CuentaAhorro ahorro;
	private CuentaCheques cheques;
	

	public Cliente(String nombre, String apellido, CuentaAhorro ahorro,
			CuentaCheques cheques) {
		Nombre = nombre;
		Apellido = apellido;
		this.ahorro = ahorro;
		this.cheques = cheques;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public CuentaAhorro getAhorro() {
		return ahorro;
	}

	public void setAhorro(CuentaAhorro ahorro) {
		this.ahorro = ahorro;
	}

	public CuentaCheques getCheques() {
		return cheques;
	}

	public void setCheques(CuentaCheques cheques) {
		this.cheques = cheques;
	}	
}
