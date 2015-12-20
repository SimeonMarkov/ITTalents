package encapsulation;

public class WorkDemo {
	public static void main(String[] args) {
		Employee pesho = new Employee("Petur Petrov");
		Task ruinHouse = new Task("Ruin a house", 5);
		Task buildHouse = new Task("Build a house", 6);
		Task paintWall = new Task("Wall painting", 10);
		Task putWindows = new Task("Putting windows", 1);
		pesho.setHoursLeft(8);
		pesho.setCurrentTask(ruinHouse);
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.setCurrentTask(buildHouse);
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.setCurrentTask(paintWall);
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		pesho.setCurrentTask(putWindows);
		pesho.showReport();
		pesho.work();
		pesho.showReport();
		Employee gosho = new Employee("Georgi Georgiev");
		gosho.setHoursLeft(8);
		gosho.setCurrentTask(buildHouse);
		gosho.showReport();
		gosho.work();
		gosho.showReport();
		gosho.work();
		gosho.showReport();
		
		
	}
}
