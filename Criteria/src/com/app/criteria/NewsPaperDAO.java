package com.app.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class NewsPaperDAO {

	public static void main(String[] args) {
		
		NewsPaperDTO paper=new NewsPaperDTO();
		paper.setLanguage("Kannada");
		paper.setNewsPaperName("Vijaya Karnataka");
		paper.setNoOfPages(22);
		paper.setRecentNews("Aadhar");
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		sess.save(paper);
		
		sess.beginTransaction().commit();
	}
}
