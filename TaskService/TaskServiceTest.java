package TaskService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	protected String taskId, taskNameTest, taskDescriptionTest;
	protected String tooLongTaskNameTest, tooLongTaskDescriptionTest;
	
	@BeforeEach
	void setUp() {
		taskId = "MF6VOM9Z";
		taskNameTest = "A Task Name";
		taskDescriptionTest = "A task description";
		tooLongTaskNameTest = "A To Long Task Name Tesinging";
		tooLongTaskDescriptionTest = "A too long task description A too long task description testing";
	}
	
	void newTaskTest() {
	    TaskService service = new TaskService();
	    service.newTask();
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
	    Assertions.assertNotEquals("TaskInfo", service.getTaskList().get(0).getTaskId());
	}
	
	@Test
	  void newTaskNameTest() {
	    TaskService service = new TaskService();
	    service.newTask(taskNameTest);
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskName());
	    Assertions.assertEquals(taskNameTest, service.getTaskList().get(0).getTaskName());
	  }

	  @Test
	  void newTaskDescriptionTest() {
	    TaskService service = new TaskService();
	    service.newTask(taskNameTest, taskDescriptionTest);
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskDescription());
	    Assertions.assertEquals(taskDescriptionTest,
	                            service.getTaskList().get(0).getTaskDescription());
	  }
	  
	  @Test
	  void newTaskTooLongNameTest() {
	    TaskService service = new TaskService();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> service.newTask(tooLongTaskNameTest));
	  }

	  @Test
	  void newTaskTooLongDescriptionTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(taskNameTest, tooLongTaskDescriptionTest));
	  }

	    
}
