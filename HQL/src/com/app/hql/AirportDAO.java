package com.app.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AirportDAO {
	public static void main(String[] args) {
		
		//step 1 create obj of DTO and populate the values
		AirportDTO airport=new AirportDTO();
		airport.setAirPortName("Hosur Aerodrome");
		airport.setLocation("Hosur");
		airport.setNumPlane(10);
		airport.setType("Domestic");
		
		//components of hibernate
		Configuration config=new Configuration();
		config.configure();
		
		SessionFactory sf=config.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		sess.save(airport);
		
		sess.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
