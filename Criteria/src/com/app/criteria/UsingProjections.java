package com.app.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.app.util.SingleTonUtil;

public class UsingProjections {
	public static void main(String[] args) {
			
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		//step 1 create criteria
		Criteria crit=sess.createCriteria(NewsPaperDTO.class);
		/*//select average value
		Projection pro=Projections.avg("noOfPages");*/
		/*//selecting count of number of rows
		Projection pro=Projections.rowCount();*/
		//select sum of a column(property)
		Projection pro=Projections.sum("noOfPages");
		
		
		
/*		//select Maximum value 
		Projection pro=Projections.max("noOfPages");
*/		//relate criteria with projection 
		crit.setProjection(pro);
		long noOfPages=(long)crit.uniqueResult();
		System.out.println(noOfPages);
		
		
		
		
		
		
		
	}
}
