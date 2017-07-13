package com.beeva.app.BancoApp_H.utilidades;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContexSingle {
	private static ContexSingle instance;
	private ApplicationContext context;
	
	private ContexSingle() {		
	}

	public static ContexSingle getInstance(){
		if (instance==null) {
			instance = new ContexSingle();			
		}
		return instance;
	}
	
	public ApplicationContext getContext() {
		return context ;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	
}
