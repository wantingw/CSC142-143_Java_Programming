package test;

import spacex.Customer;
import spacex.Date;
import spacex.Mission;
import spacex.Payload;
import spacex.Time;


public class TestBuilder {

	public static void main(String[] args) {
		Customer custom		= new Customer("ATSB", "Government", "Marshall Islands");
		Date date_01 		= new Date("07/14/2009");
		Payload payload		= new Payload("Raza", "Weather Satellite", 180, "Low Earth Orbit");
		Time time_01		= new Time("3:35:00 AM");

		
		Mission mission_01 	= new Mission.Builder()
				.setFlightNumber("F1-5")
				.setLaunchDate(date_01)
				.setLaunchTime(time_01)
				.setLaunchSite("Marshall Islands")
				.setPayload(payload)
				.setCustomer(custom)
				.setVehicleType("Falcon 1")
				.build();
		
		System.out.println(mission_01.getFlightNumber());
		System.out.println(mission_01.getVehicleType());
	
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println(mission_01);
		
	}

}
