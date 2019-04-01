package com.app.por.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import org.hibernate.Session;

import com.app.util.SingleTonUtil;

public class OneToManyDAO {

	
	public static void main(String[] args) {
		//create an object of owner
		PersonDTO person=new PersonDTO();
		person.setName("Vijay mallya");
		person.setBankBalance(200000);
		person.setNationality("INDIAN");
		person.setQulalification("Bcom");
		
		
		
		
		//create multiple objects of problem
		
		
		
		ProblemDTO prob=new ProblemDTO();
		prob.setType("Loan");
		prob.setDuration(10);
		
		
		ProblemDTO prob2=new ProblemDTO();
		prob2.setType("Airlines");
		prob2.setDuration(15);
		
		//create collection of problems
		
		List<ProblemDTO> problems=new ArrayList<>();
		problems.add(prob);
		problems.add(prob2);
		
		//relate person with multiple problems
		person.setProbs(problems);
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		sess.save(person);
		sess.beginTransaction().commit();
		
		
		
		
	}
}
