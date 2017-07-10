package com.beeva.app.pruevaJPA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.pruevaJPA.dao.UsuariosDAO;
import com.beeva.app.pruevaJPA.impl.UsuariosImpl;
import com.beeva.app.pruevaJPA.modelo.Usuario;

/**
 * Clase App principal
 *
 */
public class App 
{	
    public static void main( String[] args )
    {
        System.out.println( "Inicio de programa" );
        Usuario usuarios = new Usuario();
        ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
        UsuariosDAO dao = (UsuariosDAO) context.getBean(UsuariosImpl.class);   
        usuarios.setNombre("Juan");
        usuarios.setDireccion("muy lejos");
        //dao.save(usuarios);
        System.out.println(usuarios.toString());
    }
}
