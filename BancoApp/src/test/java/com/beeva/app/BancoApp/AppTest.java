package com.beeva.app.BancoApp;

import com.beeva.app.dao.Cliente;
import com.beeva.app.dao.Cuenta;
import com.beeva.app.dao.CuentaDAO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.beeva.app.dao.factory.CuentaFactory;
import com.beeva.app.utilerias.Validacion;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        System.out.println("Prueba para crear cliente y sus metodos");
        CuentaFactory cuentaFactory = new CuentaFactory();
        Cuenta cuenta = new Cuenta(0, "Cheques");        
        CuentaDAO cuentaMetodos = cuentaFactory.getImplCuenta(cuenta);           
        Cliente cliente = new Cliente("juan", "Alverto",cuenta);
        cuentaMetodos.deposito(cliente,156.65);
        System.out.println(cliente.getCuenta().getBalance()+"\n");
        Validacion val = new Validacion();
        System.out.println(val.esDiaHabil());
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
