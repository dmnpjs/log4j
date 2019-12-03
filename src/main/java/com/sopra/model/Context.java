package com.sopra.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Context {
	private static Logger LOGGER = LogManager.getLogger(Context.class.getName());

	private static Context instance;
	private EntityManagerFactory emf;
	
	
	
	
	private Context() {
		LOGGER.info("Creation d'un persistence context :contact");
		emf = Persistence.createEntityManagerFactory("contact");
	}

	
	
	
	public static Context getInstance() {
		if (instance == null) {
			instance = new Context()	;
			}	
		LOGGER.info("Creation d'un persistence context :contact");
		return instance;
	}
	
	public static void setInstance(Context instance) {
		Context.instance = instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
}
