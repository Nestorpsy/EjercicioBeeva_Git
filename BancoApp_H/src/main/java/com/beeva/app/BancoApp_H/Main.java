package com.beeva.app.bancoapp_h;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.bancoapp_h.gui.Principal;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

/**
 * Hello world!
 *
 */
public class Main 
{	
    public static void main( String[] args )
    {		

    	ContexSingle single = ContexSingle.getInstance();
	    single.setContext(new ClassPathXmlApplicationContext("context-core.xml"));
        System.out.println( "Iniciando App!" );
        Principal.main(null);
    }
}
