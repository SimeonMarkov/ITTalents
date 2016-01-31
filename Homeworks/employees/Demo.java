package employees;

public class Demo {
	
	public static void main(String[] args) {
		
		System.out.println("We need only 1 instance from current company,so we can use Singleton:");
		Company company = Company.getInstance("Telelink");
		Company company2 = Company.getInstance("Teletubbies");
		System.out.println(company.getName() + " " + company);
		System.out.println(company2.getName() + " " + company2);
		
		System.out.println("----------");
		
		Employee em1 = new Employee("gosho", 23, 2400.0);
		Employee em2 = new Employee("pesho", 28, 1400.0);
		Employee em3 = new Employee("grisho", 33, 800.0);
		Employee em4 = new Employee("pencho", 21, 800.0);
		Employee em5 = new Employee("pesho", 45, 2800.0);
		Employee em6 = new Employee("pancho", 22, 1900.0);
		Employee em7 = new Employee("pancho", 21, 1900.0); //em7 should not be added due to name and age coincidence with em6
		
		Employee boss1 = new Boss("misho", 35, 3_000.0, "Factory manager");
		
		System.out.println();
		
		System.out.println("Printing all employees in the company:\n" + Employee.employeesSet + "\n");
		
		Employee.sortOnName(); // sort employees in the whole company based on their name
		Employee.sortOnAge(); // sort employees in the whole company based on their age
		Employee.sortOnSalary(); // sort employees in the whole company based on their salary
		
		Department dep1 = new Department("Department1");
 		Department dep2 = new Department("Department2");
 		
		company.addWorkerInDepartment(em1, dep1);
		company.addWorkerInDepartment(em2, dep1);
		company.addWorkerInDepartment(em3, dep1);
		company.addWorkerInDepartment(em4, dep2);
		company.addWorkerInDepartment(em5, dep2);
		company.addWorkerInDepartment(em6, dep2);
		company.addWorkerInDepartment(em7, dep2); //em7 is a duplicate employee to em6,so he should not be added in the current department
		company.addWorkerInDepartment(boss1, dep1);
		company.addWorkerInDepartment(boss1, dep2);
		
		for(Department department : company.getWorkers().keySet()){
			System.out.println(department.getName() + ":");
			for(Employee worker : company.getWorkers().get(department)){
				System.out.println("\t" + worker.getID() + " " + worker.getName() + " " + (worker instanceof Boss ? ((Boss)worker).getTitle() + " " : " ") + worker.getSalary());
			}
			System.out.println("---------");
		}
		
		//prints workers from current department,sorted by name
		company.printWorkersFromDepartment(dep1);
		System.out.println();
		company.printWorkersFromDepartment(dep2);
		System.out.println();

		
		em1.printSalaryForEachMonth();
		em2.printSalaryForEachMonth();
		em3.printSalaryForEachMonth();
		em4.printSalaryForEachMonth();
		em5.printSalaryForEachMonth();
		em6.printSalaryForEachMonth();
		
		
	}

}
