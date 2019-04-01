package com.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavePoliceStationDAO {
	public static void main(String[] args) {

		// create an object of DTO and populate the values
		PoliceStationDTO station = new PoliceStationDTO();
		station.setLocation("Basavanagudi");
		station.setNoOfCells(6);
		station.setNoOfPrisoners(12);

		// 3 components and save obj to db
		// obtain configuration
		Configuration config = new Configuration();
		// load the cfg file
		config.configure("configuration/Configuration.xml");
		//config.addAnnotatedClass(PoliceStationDTO.class);
		// 2nd component connect to DB
		SessionFactory sf = config.buildSessionFactory();
		// 3rd component
		Session sess = sf.openSession();
		// use the session to perform CRUD operations
		sess.save(station);
		// to commit the data we have to use transaction
		Transaction tx = sess.beginTransaction();
		tx.commit();

	}
}
