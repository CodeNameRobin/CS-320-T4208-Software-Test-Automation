package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class TaskTest {
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
	
	@Test
	  void getTaskIdTest() {
	    Task task = new Task(taskId);
	    Assertions.assertEquals(taskId, task.getTaskId());
	  }
	@Test
	  void getTaskNameTest() {
	    Task task = new Task(taskId, taskNameTest);
	    Assertions.assertEquals(taskNameTest, task.getTaskName());
	  }
	
	@Test
	  void getDescriptionTest() {
	    Task task = new Task(taskId, taskNameTest, taskDescriptionTest);
	    Assertions.assertEquals(taskDescriptionTest, task.getTaskDescription());
	  }
	
	@Test
	  void updateNameTest() {
	    Task task = new Task();
	    task.updateTaskName(taskNameTest);
	    Assertions.assertEquals(taskNameTest, task.getTaskName());
	  }
	
	@Test
	  void updateDescriptionTest() {
	    Task task = new Task();
	    task.updateTaskDescription(taskDescriptionTest);
	    Assertions.assertEquals(taskDescriptionTest, task.getTaskDescription());
	  }
	

	  @Test
	  void updateTooLongNameTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.updateTaskName(tooLongTaskNameTest));
	  }

	  @Test
	  void updateTooLongDescriptionTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.updateTaskDescription(tooLongTaskDescriptionTest));
	  }


}
