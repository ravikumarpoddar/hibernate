package com.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatePoliceStationDAO {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(PoliceStationDTO.class);
		SessionFactory sf = config.buildSessionFactory();
		Session sess = sf.openSession();

		// two steps to update

		// step 1 load the object from the database
		PoliceStationDTO station = sess.load(PoliceStationDTO.class, "Basavanagudi");
		System.out.println(station.getNoOfCells());
		// step 2 use setters method and use update method
		station.setNoOfCells(6);

		sess.update(station);

		Transaction tx = sess.beginTransaction();

		tx.commit();

	}
}
