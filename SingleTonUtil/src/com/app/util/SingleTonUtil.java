package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTonUtil {

	private static SessionFactory sf;

	private SingleTonUtil() {
		// TODO Auto-generated constructor stub
	}

	public static SessionFactory getSf() {
		if(sf==null) {
			sf=new Configuration().configure().buildSessionFactory();
			return sf;
		}
		return sf;
	}

}
