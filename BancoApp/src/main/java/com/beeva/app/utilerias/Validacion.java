package com.beeva.app.utilerias;

import java.util.Calendar;

public class Validacion {
	
	public boolean esDiaHabil(){
		boolean esHabil=true;
		Calendar hoy = Calendar.getInstance();
		int dia = hoy.get(Calendar.DAY_OF_WEEK);
		if(dia==1){esHabil=false;}
		if(dia==7){esHabil=false;}
		return esHabil;
	}

}
