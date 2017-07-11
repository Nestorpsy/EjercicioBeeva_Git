package com.beeva.app.BancoApp_H;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.BancoApp_H.impl.BancoImpl;
import com.beeva.app.BancoApp_H.modelo.Banco;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );        
        //usuarios();      
        banco();
    }
    
    public void usuarios(){
    	System.out.println("Hola de prueba Usuarios");
    	
    }
    
    public void banco(){
    	System.out.println("Hola de prueba Banco");
    	Banco banco = new Banco();
    	BancoImpl impl = (BancoImpl) context.getBean(BancoImpl.class);
    	banco.setNombre("Bancomer");
    	impl.addBanco(banco);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
