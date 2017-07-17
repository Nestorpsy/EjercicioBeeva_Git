package com.beeva.app.bancoapp_h.utilidades;

import org.springframework.context.ApplicationContext;

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
