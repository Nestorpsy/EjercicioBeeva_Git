package com.beeva.app.utilerias;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.dao.Cuenta;



public class BeansUtil {
	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	public Cuenta Ciente() {
		Cuenta cuenta = (Cuenta) context.getBean("cuenta");
		return cuenta;	
	}
	@Test
	public void testCuenta() {
		System.out.println(Ciente().getBalance());
	}
}
