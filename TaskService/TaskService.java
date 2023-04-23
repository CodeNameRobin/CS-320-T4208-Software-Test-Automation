package TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {

	private static String uniqueId = null;
	private List<Task> taskList = new ArrayList<>();
	
	public void newTask() {
	    Task task = new Task(newUniqueId());
	    taskList.add(task);
	}
	
	public void newTask(String taskName) { 
		Task task = new Task(newUniqueId(), taskName); 
		taskList.add(task);
	}
	
	public void newTask(String taskName, String taskDescription) { 
		Task task = new Task(newUniqueId(), taskName, taskDescription); 
		taskList.add(task);
	}
	
	private String newUniqueId() {
		
		if(uniqueId == null) {
			uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
			uniqueId = uniqueId.replace("-", "");
		}
		for(int i = 0; i < taskList.size(); i++) {
			if(uniqueId.equals(getTaskList().get(i).getTaskId())){
				uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
				uniqueId = uniqueId.replace("-", "");
				i = 0;
			}
		}
	    System.out.println(uniqueId);
    	
	    return uniqueId;	
	  }
	
	public void deleteTask(String taskId) throws Exception {
	    taskList.remove(searchForTask(taskId));
	  }
	
	private int searchForTask(String taskId) throws Exception {
		int currIndex = 0;
		while(currIndex < getTaskList().size()) {
			for(currIndex = 0; currIndex < getTaskList().size(); currIndex++) {
				if(taskId.equals(getTaskList().get(currIndex).getTaskId())) {
					return currIndex;
				}
			}
		}
		throw new Exception("That contact does not exist!");
	}
	
	protected List<Task> getTaskList() { return taskList; }

}
