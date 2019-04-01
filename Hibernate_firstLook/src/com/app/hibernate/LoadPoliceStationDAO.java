package com.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadPoliceStationDAO {
	public static void main(String[] args) {
		
		//obtain configuration
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(PoliceStationDTO.class);
		
		//obtain SessionFactory
		SessionFactory sf=config.buildSessionFactory();
		
		//obtain a session
		
		Session sess=sf.openSession();
		
		
		//load the data from DB
		PoliceStationDTO policeStation=sess.load(PoliceStationDTO.class, "Basavanagudi");
		
		
		
		System.out.println(policeStation.getLocation());

		System.out.println(policeStation.getNoOfCells());

		System.out.println(policeStation.getNoOfPrisoners());
		
		
		
// select * from PoliceStation_table 
	//	where location='Basavanagudi';
		
		//Result set
		// int noOfCells= rs.getInt("no_Of_cells")
		//String loc= rs.getString("location")
		//int noOfPrisoners= rs.getInt("no_Of_prisoners")
		/*PoliceStationDTO station=new PoliceStationDTO();
		station.setLocation(loc);
		station.setNoOfCells(noOfCells);
		station.setNoOfPrisoners(noOfPrisoners);
		*/
		
	}
}
