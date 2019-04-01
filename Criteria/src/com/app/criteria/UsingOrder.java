package com.app.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.app.util.SingleTonUtil;

public class UsingOrder {
public static void main(String[] args) {

	SessionFactory sf=SingleTonUtil.getSf();
	Session sess=sf.openSession();
	
	
	Criteria crit=sess.createCriteria(NewsPaperDTO.class);
	Order ord=Order.asc("noOfPages");
	crit.addOrder(ord);
	List<NewsPaperDTO> papers=crit.list();
	for (NewsPaperDTO newsPaperDTO : papers) {
		System.out.println(newsPaperDTO.getNoOfPages());
	}
	
	
	
	
	
	
}
}
