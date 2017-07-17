package com.beeva.app.bancoapp_h;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.bancoapp_h.dao.BancoDAO;
import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.impl.BancoImpl;
import com.beeva.app.bancoapp_h.impl.ClienteImpl;
import com.beeva.app.bancoapp_h.modelo.Banco;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	ContexSingle single = ContexSingle.getInstance();		
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {     	
        super( testName );   
        single.setContext(new ClassPathXmlApplicationContext("context-core.xml"));
        //addUsuarios();      
        //addBanco();
        //getCliente();
        //addCliente();
        getAllBancos();
    }
    
    public void getAllBancos(){
    	System.out.println("Hola de prueba getAllBancos");
    	BancoDAO dao = (BancoImpl) single.getContext().getBean(BancoImpl.class);
    	List<Banco> list = dao.getAllBanco();
    	System.out.println(dao.getAllBanco());
    }
    
    public void addUsuarios(){
    	System.out.println("Hola de prueba Usuarios");
    	
    }
    public void addCliente(){    	
    	System.out.println("Hola de prueba addCliente");
    	Cliente cliente = new Cliente();
    	cliente.setApellido("Prueba");
    	cliente.setNombre("1");
    	ClienteDAO dao = (ClienteImpl) single.getContext().getBean(ClienteImpl.class);
    	dao.addCiente(cliente);
    }
    
    public void addBanco(){
    	System.out.println("Hola de prueba Banco");
    	Banco banco = new Banco();
    	BancoDAO dao = (BancoImpl) single.getContext().getBean(BancoImpl.class);
    	banco.setNombre("Bancomer");
    	dao.addBanco(banco);
    }
    
    public void getCliente(){
    	System.out.println("Hola de prueba getCliente");
    	ClienteDAO dao = (ClienteImpl) single.getContext().getBean(ClienteImpl.class);
    	Cliente cliente = dao.getCliente(1);
    	System.out.println("Nobre:"+ cliente.getNombre());
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
