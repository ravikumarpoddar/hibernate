package com.app.por;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class LoadOneToOneDAO {

	
	public static void main(String[] args) {
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		StateDTO state=sess.load(StateDTO.class, "KARNATAKA");
		System.out.println(state.getLanguage());
		System.out.println(state.getNoOfDistricts());
		System.out.println("obtaining cm from state");
		CMDTO cm=state.getCm();
		System.out.println(cm.getCmName());
		System.out.println(cm.getParty());
		
		
		
		
		
	}
}
