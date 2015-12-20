package encapsulation;

public class Employee {
	private String name;
	private Task currentTask;
	private int hoursLeft;
	private int day;
	boolean isTaskMadeByAnother = false;

	public Employee(String name) {
		setName(name);
		day = 1;	//for each new Employee,his career starts from day 1
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	
	public void setCurrentTask(Task currentTask) {
		if(currentTask != null){
			if(!currentTask.getName().equals("")){
				this.currentTask = currentTask;
				this.getCurrentTask().setWorkingHours(currentTask.getWorkingHours());
			}
			if(currentTask.getWorkingHours() == 0){
				isTaskMadeByAnother = true;
			}
		}
		
	}
	
	public void checkTaskAsFinished(){
		this.currentTask = null;
	}

	public int getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		this.hoursLeft = hoursLeft;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.equals("")) {
			this.name = name;
		}
	}

	void work() {
		if (this.getCurrentTask() != null) {
			if (this.getCurrentTask().getWorkingHours() > 0 && this.getHoursLeft() > 0) {
				System.out.println(this.getName() + " is working...");
				if (this.getHoursLeft() > this.getCurrentTask().getWorkingHours()) {
					this.setHoursLeft(this.getHoursLeft()- this.getCurrentTask().getWorkingHours());
					this.getCurrentTask().setWorkingHours(0);
				} 
				else if (this.getHoursLeft() < this.getCurrentTask().getWorkingHours()) {
					this.getCurrentTask().setWorkingHours(this.getCurrentTask().getWorkingHours() - this.getHoursLeft());
					this.setHoursLeft(0);
				}
			} 
			else if (this.getHoursLeft() == 0) {
				this.setHoursLeft(8);
				day++;
			}
		}
	}

	void showReport() {
		if(this.currentTask != null){
			if (this.getCurrentTask().getWorkingHours() > 0 && this.getHoursLeft() > 0) {
				System.out.print("Name:" + this.getName() + "\nDay:" + day + "\nCurrent task:" + this.getCurrentTask().getName()	+ "\nTime to get the task done:" + this.getCurrentTask().getWorkingHours() + "\nRemaining working time:" + this.getHoursLeft() + "\n");
				System.out.println();
			}
			else if (this.getCurrentTask().getWorkingHours() == 0) {
				if(!isTaskMadeByAnother){
					System.out.println("Day:" + day + "\n" + this.getName() + " completed the \"" + this.getCurrentTask().getName() + "\" task!");
					this.checkTaskAsFinished();
					System.out.println();
				}
				else{
					System.out.println(this.getCurrentTask().getName() + " for the current object was already finished by another worker!");
					this.checkTaskAsFinished();
				}
			} 
			else {
				System.out.print("Name:" + this.getName() + "\nDay:" + day + "\nCurrent task:" + this.getCurrentTask().getName() + "\nTime to get the task done:" + this.getCurrentTask().getWorkingHours() + "\nRemaining working time:" + this.getHoursLeft() + "\n");
				System.out.println();
			}
		}
		else{
			System.out.println(this.getName() + " has no current task to do!");
			System.out.println();
		}
		
	}

}
