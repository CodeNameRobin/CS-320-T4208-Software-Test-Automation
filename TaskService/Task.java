package TaskService;

public class Task {
	private int TASK_ID_LEN = 10;
	private int TASK_NAME_LEN = 20;
	private int TASK_DESCRIPTION_LEN = 50;
	private String taskId;
	private String taskName;
	private String taskDescription;
	private String INIT_STRING = "TaskInfo";
	
	Task(){
		this.taskId = INIT_STRING;
		this.taskName = INIT_STRING;
		this.taskDescription = INIT_STRING;
	}
	Task(String taskId){
		updateTaskId(taskId);
		this.taskName = INIT_STRING;
		this.taskDescription = INIT_STRING;
	}

	Task(String taskId, String taskName){
		updateTaskId(taskId);
		updateTaskName(taskName);
		this.taskDescription = INIT_STRING;
	}
	
	Task(String taskId, String taskName, String taskDescription){
		updateTaskId(taskId);
		updateTaskName(taskName);
		updateTaskDescription(taskDescription);
	}
	
	protected void updateTaskId(String taskId) {
		if (taskId == null) {
		      throw new IllegalArgumentException("Task ID is empty!");
		    } else if (taskId.length() > TASK_ID_LEN) {
		      throw new IllegalArgumentException("Contact ID cannot exceed " +
		                                         TASK_ID_LEN + " characters");
		    } else {
		      this.taskId = taskId;
		    }
	}
	
	protected void updateTaskName(String taskName) {
		if (taskName == null) {
		      throw new IllegalArgumentException("Task name is empty!");
		    } else if (taskName.length() > TASK_NAME_LEN) {
		      throw new IllegalArgumentException("Contact name cannot exceed " +
		                                         TASK_NAME_LEN + " characters");
		    } else {
		      this.taskName = taskName;
		    }
	}
	
	protected void updateTaskDescription(String taskDescription) {
		if (taskDescription == null) {
		      throw new IllegalArgumentException("Task description is empty!");
		    } else if (taskDescription.length() > TASK_DESCRIPTION_LEN) {
		      throw new IllegalArgumentException("Contact description cannot exceed " +
		                                         TASK_DESCRIPTION_LEN + " characters");
		    } else {
		      this.taskDescription = taskDescription;
		    }
	}
	
	public final String getTaskId() { return taskId; }
	public final String getTaskName() { return taskName; }
	public final String getTaskDescription() { return taskDescription; }

}
