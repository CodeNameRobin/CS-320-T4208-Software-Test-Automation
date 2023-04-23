package AppointmentService;

import java.util.Date;

public class Appointment {
	private int SHORT_LENGTH = 10;
	private int LONG_LENGTH = 50;
	private String INIT_STRING = "INITAL";
	private String INIT_NUM = "0123456789";
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDescription;
	
	Appointment() {
		Date currDate = new Date();
	    this.appointmentId = INIT_STRING;
	    this.appointmentDate = currDate;
	    this.appointmentDescription = INIT_STRING;
	}
	Appointment(String appointmentId) {
		Date currDate = new Date();
	    updateAppointmentId(appointmentId);
	    this.appointmentDate = currDate;
	    this.appointmentDescription = INIT_STRING;
	}
	
	Appointment(String appointmentId, Date appointmentDate) {
	    updateAppointmentId(appointmentId);
	    updateAppointmentDate(appointmentDate);
	    this.appointmentDescription = INIT_STRING;
	}
	
	Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
	    updateAppointmentId(appointmentId);
	    updateAppointmentDate(appointmentDate);
	    updateAppointmentDescription(appointmentDescription);
	}
	
	protected void updateAppointmentId(String appointmentId) {
		if (appointmentId == null) {
		      throw new IllegalArgumentException("Contact ID is empty!");
		    } else if (appointmentId.length() > SHORT_LENGTH) {
		      throw new IllegalArgumentException("Contact ID cannot exceed " +
		                                         SHORT_LENGTH + " characters");
		    } else {
		      this.appointmentId = appointmentId;
		    }
	}
	
	protected void updateAppointmentDate(Date appointmentDate) {
		Date currDate = new Date();
	    if (appointmentDate == null) {
	      throw new IllegalArgumentException("First name not entered!");
	    } else if (appointmentDate.before(currDate)) {
	      throw new IllegalArgumentException("Appointment date cannot be before today");
	    } else {
	      this.appointmentDate = appointmentDate;
	    }
	  }
	
	protected void updateAppointmentDescription(String appointmentDescription) {
	    if (appointmentDescription == null) {
	      throw new IllegalArgumentException("Last name not entered!");
	    } else if (appointmentDescription.length() > LONG_LENGTH) {
	      throw new IllegalArgumentException("Description cannot exceed " + LONG_LENGTH + " characters");
	    } else {
	      this.appointmentDescription = appointmentDescription;
	    }
	  }
	
	
	
	
	public final String getAppointmentId() { return appointmentId; }
	public final Date getAppointmentDate() { return appointmentDate; }
	public final String getAppointmentDescription() { return appointmentDescription; }

}
