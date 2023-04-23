package AppointmentService;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskService.Task;

public class AppointmentTest {
	protected String appointmentIdTest, appointmentDescriptionTest;
	protected Date appointmentDateTest;
	protected String tooLongAppointmentIdTest, tooLongAppointmentDescriptionTest;
	protected Date appointmentDateBefore;
	
	@BeforeEach
	void setUp() {
		appointmentIdTest = "MF6VOM9Z";
		appointmentDateTest = new Date(2025, 5, 9);
		appointmentDescriptionTest = "A task description";
		tooLongAppointmentIdTest = "123456789123456789";
		tooLongAppointmentDescriptionTest = "A too long task description A too long task description testing testing testing testing testing";
		appointmentDateBefore = new Date(2010, 7, 6);
	}
	
	@Test
	  void getAppointmentIdTest() {
		Appointment appointment = new Appointment(appointmentIdTest);
	    Assertions.assertEquals(appointmentIdTest, appointment.getAppointmentId());
	  }
	@Test
	  void getTaskNameTest() {
		Appointment appointment = new Appointment(appointmentIdTest, appointmentDateTest);
	    Assertions.assertEquals(appointmentDateTest, appointment.getAppointmentDate());
	  }
	
	@Test
	  void getDescriptionTest() {
		Appointment appointment = new Appointment(appointmentIdTest, appointmentDateTest, appointmentDescriptionTest);
	    Assertions.assertEquals(appointmentDescriptionTest, appointment.getAppointmentDescription());
	  }
	
	@Test
	  void updateIdTest() {
		Appointment appointment = new Appointment();
		appointment.updateAppointmentId(appointmentIdTest);
	    Assertions.assertEquals(appointmentIdTest, appointment.getAppointmentId());
	  }
	
	@Test
	  void updateDateTest() {
		Appointment appointment = new Appointment();
		appointment.updateAppointmentDate(appointmentDateTest);
	    Assertions.assertEquals(appointmentDateTest, appointment.getAppointmentDate());
	  }
		
	@Test
	  void updateDescriptionTest() {
		Appointment appointment = new Appointment();
		appointment.updateAppointmentDescription(appointmentDescriptionTest);
	    Assertions.assertEquals(appointmentDescriptionTest, appointment.getAppointmentDescription());
	  }
	

	  @Test
	  void updateTooLongIdTest() {
		Appointment appointment = new Appointment();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> appointment.updateAppointmentId(tooLongAppointmentIdTest));
	  }
	  
	  @Test
	  void updateBeforeDateTest() {
		Appointment appointment = new Appointment();
		Assertions.assertThrows(IllegalArgumentException.class, 
								() -> appointment.updateAppointmentDate(appointmentDateBefore));
	  }

	  @Test
	  void updateTooLongDescriptionTest() {
		Appointment appointment = new Appointment();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> appointment.updateAppointmentDescription(tooLongAppointmentDescriptionTest));
	  }

}
