package com.app.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.app.util.SingleTonUtil;

public class LoadNewsPaperDAO {
	
	public static void main(String[] args) {
		
		SessionFactory sf=SingleTonUtil.getSf();
		
		Session sess=sf.openSession();

//selecting a record based on multiple conditions
Criteria crit=sess.createCriteria(NewsPaperDTO.class);
Criterion criterion=Restrictions.eq("noOfPages",14);
Criterion criterion2=Restrictions.eq("recentNews","Aadhar");
LogicalExpression exp=Restrictions.or(criterion, criterion2);
crit.add(exp);


List<NewsPaperDTO> papers=crit.list();
		System.out.println(papers.size());
		for (NewsPaperDTO newsPaperDTO : papers) {
			System.out.println("------------");
			System.out.println(newsPaperDTO.getLanguage());
		}
		
		
		
		
		
		
		
		
		
		
		/*//Select one record from DB
		//step1 create critera
		
Criteria crit=sess.createCriteria(NewsPaperDTO.class);
	
	//add condition NumberOfPages >14
	Criterion criterion=
			Restrictions.gt("noOfPages", 14);
	//add condition numOfPages <= 22
	Criterion criterion=Restrictions.le("noOfPages", 22);
		crit.add(criterion);

		List<NewsPaperDTO> papers=crit.list();
		
		for (NewsPaperDTO newsPaperDTO : papers) {
			System.out.println(newsPaperDTO.getNewsPaperName());
			
		}
		*/
		
		
		
/*		NewsPaperDTO paper=(NewsPaperDTO)crit.uniqueResult();
		System.out.println(paper.getLanguage());
*/		
		
		
		
		
		
		
		
	/*	//step1 create criteria
Criteria crit=sess.createCriteria(NewsPaperDTO.class);
		//add the conditions
Criterion criterion=
Restrictions.eq("language", "Kannada");
crit.add(criterion);
		//step 2 process the result

		NewsPaperDTO paper=(NewsPaperDTO)crit.uniqueResult();
		System.out.println(paper.getNewsPaperName());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		// select all the records from DB
		//use criteria
		//step1 
//sql:select * from Newspaper_table
//hql : from NewsPaperDTO
Criteria crit=sess.createCriteria(NewsPaperDTO.class);
	//step2 process the result
	List<NewsPaperDTO> newsPapers=crit.list();
	
	for (NewsPaperDTO newsPaperDTO : newsPapers) {
		System.out.println(newsPaperDTO.getLanguage());
	}
	
*/


		
		
		
		
		
		
		
		
		
		
		
	}
}
