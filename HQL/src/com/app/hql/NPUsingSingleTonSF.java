package com.app.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class NPUsingSingleTonSF {
	
	public static void main(String[] args) {
		
		SessionFactory sf=SingleTonUtil.getSf();
		
		Session sess=sf.openSession();
		
		
		//step1 create the query
		
		String hql="from AirportDTO where location=:loc";
		
		
		Query qry=sess.createQuery(hql);
		
		qry.setParameter("loc", "Hosur");
		
		
		//step 2 process the result
		
		
		AirportDTO airport=(AirportDTO)qry.uniqueResult();
		System.out.println(airport.getAirPortName());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
