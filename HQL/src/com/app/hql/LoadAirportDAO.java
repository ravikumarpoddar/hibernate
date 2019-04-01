package com.app.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadAirportDAO {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("configuration/Configuration.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session sess = sf.openSession();
		
String hql="select numPlane,airPortName from "
		+ "AirportDTO ";

	Query qry=sess.createQuery(hql);
	List<Object[]> list=qry.list();
			for (Object[] objects : list) {
				System.out.println(objects[0]);
				System.out.println(objects[1]);
				System.out.println("--------");
			}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*
		//select multiple columns from the table
		//create the query
		
		String hql="select numPlane,airPortName from "
+ "AirportDTO where location='Shamshabad'";
		Query qry=sess.createQuery(hql);
		
		//process the result
		Object[] airport=(Object[])qry.uniqueResult();
		System.out.println(airport[0]);
		System.out.println(airport[1]);
		
		
		
		
		
		
		*/
		
		
		
		
		
		
		
		
		
	/*	// Selecting one property(column) from the DB
		// step 1 Create the query

		// SQL:select airport_name from airport_table where no_of_planes=60;
String hql = "select numPlane from "
		+ "AirportDTO where location='Devanahalli'";
		Query qry = sess.createQuery(hql);
		// step 2 process the result
int numOfPlanes = (int) qry.uniqueResult();
System.out.println(numOfPlanes);*/
		
		
		
		
		
		
		
		
		
		

		// use hql to fetch

		// step 1 create the query
		// select * from airport_table where airport_name='KIA'
		// from

		// select single record from DB
		/*
		 * String hql="from AirportDTO where airPortName='KIA'"; Query
		 * qry=sess.createQuery(hql); //step 2 process the result AirportDTO
		 * airport=(AirportDTO)qry.uniqueResult();
		 * System.out.println(airport.getLocation());
		 * System.out.println(airport.getNumPlane());
		 * System.out.println(airport.getType());
		 */

		// select all the records from the database
		// create the query
		// select * from Airport_table
		/*
		 * String hql="from AirportDTO"; Query qry=sess.createQuery(hql);
		 * 
		 * //process the result
		 * 
		 * List<AirportDTO> airpots=qry.list(); for (AirportDTO airportDTO : airpots) {
		 * System.out.println(airportDTO.getAirPortName());
		 * System.out.println(airportDTO.getLocation()); }
		 */

	}
}
