package AppointmentService;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskService.TaskService;

public class AppointmentServiceTest {
	protected String appointmentIdTest, appointmentDescriptionTest;
	protected Date appointmentDateTest;
	protected String tooLongAppointmentIdTest, tooLongAppointmentDescriptionTest;
	protected Date appointmentDateBeforeTest;
	
	@BeforeEach
	void setUp() {
		appointmentIdTest = "MF6VOM9Z";
		appointmentDateTest = new Date(2025, 5, 9);
		appointmentDescriptionTest = "A task description";
		tooLongAppointmentIdTest = "123456789123456789";
		tooLongAppointmentDescriptionTest = "A too long task description A too long task description testing testing testing testing testing";
		appointmentDateBeforeTest = new Date(2010, 7, 6);
	}
	
	@Test
	void newAppointmentTest() {
	    AppointmentService service = new AppointmentService();
	    service.newAppointment();
	    Assertions.assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
	    Assertions.assertNotEquals("TaskInfo", service.getAppointmentList().get(0).getAppointmentId());
	}
	
	@Test
	  void newAppointmentIdTest() {
		AppointmentService service = new AppointmentService();
	    service.newAppointment(appointmentIdTest);
	    Assertions.assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
	    Assertions.assertEquals(appointmentIdTest, service.getAppointmentList().get(0).getAppointmentId());
	  }
	
	@Test
	  void newAppointmentDateTest() {
		AppointmentService service = new AppointmentService();
	    service.newAppointment(appointmentIdTest, appointmentDateTest);
	    Assertions.assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
	    Assertions.assertEquals(appointmentIdTest, service.getAppointmentList().get(0).getAppointmentId());
	  }
	
	@Test
	  void newAppointmentDescriptionTest() {
		AppointmentService service = new AppointmentService();
	    service.newAppointment(appointmentIdTest, appointmentDateTest, appointmentDescriptionTest);
	    Assertions.assertNotNull(service.getAppointmentList().get(0).getAppointmentDescription());
	    Assertions.assertEquals(appointmentDescriptionTest,
	                            service.getAppointmentList().get(0).getAppointmentDescription());
	  }
	
	@Test
	  void newAppointmentTooLongIdTest() {
		AppointmentService service = new AppointmentService();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> service.newAppointment(tooLongAppointmentIdTest));
	  }
	
	@Test
	  void newAppointmentBeforeDateTest() {
		AppointmentService service = new AppointmentService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newAppointment(appointmentIdTest, appointmentDateBeforeTest));
	  }
	@Test
	  void newAppointmentTooLongDescriptionTest() {
		AppointmentService service = new AppointmentService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newAppointment(appointmentIdTest, appointmentDateTest, tooLongAppointmentDescriptionTest));
	  }

}
