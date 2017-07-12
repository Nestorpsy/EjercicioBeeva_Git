package com.beeva.batchdemo.job.fileProcessor.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beeva.batchdemo.job.fileProcessor.model.Empleado;
import com.beeva.batchdemo.job.fileProcessor.model.User;

@Component
public  class FileProcess implements ItemProcessor <User,Empleado>{

	public Empleado process(User usr) throws Exception {
		Empleado emp = new Empleado();
		emp.setNombre(usr.getNombre());
		emp.setSitio(usr.getDireccion());
		return emp;
	}

}
