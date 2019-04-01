package com.app.por.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class LoadOneTOManyDAO {

	public static void main(String[] args) {
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		//loadperson from the database
		PersonDTO person=sess.load(PersonDTO.class, 1l);
		System.out.println(person.getName());
		System.out.println(person.getBankBalance());
		
		//using person obtain the problems
		
		List<ProblemDTO> problems=(List<ProblemDTO>)person.getProbs();
		
		
		for (ProblemDTO problemDTO : problems) {
			System.out.println(problemDTO.getType());
		}
		
		
		
		
		
		
		
		
	}
}
