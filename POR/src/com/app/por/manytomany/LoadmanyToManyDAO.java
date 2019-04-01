package com.app.por.manytomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.util.SingleTonUtil;

public class LoadmanyToManyDAO {

	public static void main(String[] args) {

		SessionFactory sf = SingleTonUtil.getSf();
		Session sess = sf.openSession();

		/*
		 * //fetch bus fromDB BusDTO bus1=sess.load(BusDTO.class, 2);
		 * 
		 * System.out.println(bus1.getNumber());
		 * 
		 * 
		 * //obtain passensgers fro bus List<PassengerDTO>
		 * passengers=(List<PassengerDTO>)bus1.getPassengers(); for (PassengerDTO
		 * passengerDTO : passengers) { System.out.println(passengerDTO.getTicketNo());
		 * }
		 */

		// obtain passenger
		PassengerDTO pass = sess.load(PassengerDTO.class, 5468);
		System.out.println(pass.getType());

		// obtain buses from passenger

		List<BusDTO> buses = (List<BusDTO>) pass.getBuses();
		for (BusDTO busDTO : buses) {
			System.out.println(busDTO.getNumber());
		}

	}
}
