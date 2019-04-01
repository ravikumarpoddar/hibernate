package com.app.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeletePoliceStationDAO {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(PoliceStationDTO.class);
		
		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.openSession();
		
		//load the object from the database
		
		PoliceStationDTO station=session.load(PoliceStationDTO.class, "Chamrajpet");
		
		//use delete method
		session.delete(station);

		session.beginTransaction().commit();
		/*Transaction tx=session.beginTransaction();
		tx.commit();*/

	}

}
