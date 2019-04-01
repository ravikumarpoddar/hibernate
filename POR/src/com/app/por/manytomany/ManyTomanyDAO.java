package com.app.por.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class ManyTomanyDAO {

	public static void main(String[] args) {
		
		
		//create multiple bus objects
		BusDTO bus=new BusDTO();
		bus.setColor("Blue");
		bus.setNumber("45G");
		bus.setDestination("KBS");
		bus.setNoOfSeats(52);

		BusDTO bus2=new BusDTO();
		bus2.setColor("Green");
		bus2.setNumber("60A");
		bus2.setDestination("jayanagar");
		bus2.setNoOfSeats(52);
		
		//create multiple obejcts of passengers
		PassengerDTO passenger1=new PassengerDTO();
		passenger1.setType("Senior");
		passenger1.setTicketNo(1234);
		
		PassengerDTO passenger2=new PassengerDTO();
		passenger2.setType("Adult");
		passenger2.setTicketNo(5468);

		//create collection of passengers
		List<PassengerDTO> passengers=new ArrayList<>();
		passengers.add(passenger1);
		passengers.add(passenger2);
		
		
		//relate 45G with 2 passengers
		bus.setPassengers(passengers);
		
		//relate 60A with 2 passengers
		bus2.setPassengers(passengers);
		
		//create a collection of buses
		List<BusDTO> buses =new ArrayList<>();
		buses.add(bus);
		buses.add(bus2);
		
		
		//relate each passenger with collection of Buses
		
		passenger1.setBuses(buses);
		passenger2.setBuses(buses);
		
		
		
		SessionFactory sf=SingleTonUtil.getSf();
		Session sess=sf.openSession();
		
		
		sess.save(bus);
		sess.save(bus2);
		sess.save(passenger1);
		sess.save(passenger2);
		
		
		sess.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
