package com.app.Autogen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class IPLTeamDAO {
	
	public static void main(String[] args) {
		
		IPLTeamDTO team=new IPLTeamDTO();
		team.setTeamName("RCB");
		team.setCaptainName("Virat Kohli");
		team.setJerseyColor("Red");
		team.setNoOfwins(0);
		
		SessionFactory sf=SingleTonUtil.getSf();
		
		Session sess=sf.openSession();
		
		sess.save(team);
		sess.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
	}
}
