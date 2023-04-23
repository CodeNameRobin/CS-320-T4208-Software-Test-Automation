package AppointmentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	private static String uniqueId = null;
	private List<Appointment> appointmentList = new ArrayList<>();
	
	public void newAppointment() {
		Appointment appointment = new Appointment(newUniqueId());
		appointmentList.add(appointment);
	}

	public void newAppointment(String appointmentId) { 
		Appointment appointment = new Appointment(appointmentId); 
		appointmentList.add(appointment);
	}
	
	public void newAppointment(String appointmentId, Date appointmentDate) { 
		Appointment appointment = new Appointment(appointmentId, appointmentDate); 
		appointmentList.add(appointment);
	}
	
	public void newAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) { 
		Appointment appointment = new Appointment(appointmentId, appointmentDate, appointmentDescription); 
		appointmentList.add(appointment);
	}
	
	private String newUniqueId() {
		
		if(uniqueId == null) {
			uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
			uniqueId = uniqueId.replace("-", "");
		}
		for(int i = 0; i < appointmentList.size(); i++) {
			if(uniqueId.equals(getAppointmentList().get(i).getAppointmentId())){
				uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
				uniqueId = uniqueId.replace("-", "");
				i = 0;
			}
		}
	    System.out.println(uniqueId);
    	
	    return uniqueId;	
	  }
	
	private int searchForAppointment(String appointmentId) throws Exception {
		int currIndex = 0;
		while(currIndex < getAppointmentList().size()) {
			for(currIndex = 0; currIndex < getAppointmentList().size(); currIndex++) {
				if(appointmentId.equals(getAppointmentList().get(currIndex).getAppointmentId())) {
					return currIndex;
				}
			}
		}
		throw new Exception("That appointment does not exist!");
	}
	
	public void deleteAppointment(String appointmentId) throws Exception {
	    appointmentList.remove(searchForAppointment(appointmentId));
	  }
	
	
	protected List<Appointment> getAppointmentList() { return appointmentList; }

}
