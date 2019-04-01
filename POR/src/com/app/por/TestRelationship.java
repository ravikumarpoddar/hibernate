package com.app.por;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class TestRelationship {

	public static void main(String[] args) {
		
		//create obj of state
		
		StateDTO state=new StateDTO();
		state.setName("Bihar");
		state.setLanguage("Bhojpuri");
		state.setNoOfDistricts(38);

		//create obj of CM
		CMDTO CM=new CMDTO();
		CM.setCmName("Nitesh Kumar");
		CM.setParty("JDU");
		CM.setSalary(215000);
		CM.setPhNo(22251654);
		
		//relate owner with associated obj
		state.setCm(CM);
		CM.setState(state);
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		sess.save(CM);
		sess.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
	}
}
