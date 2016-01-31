package employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Company {
	
	private static Company company;
	private String name;
	private static LinkedHashMap<Department, LinkedHashSet<Employee>> workers;

	private Company(String name){
		this.setName(name);
		Company.workers = new LinkedHashMap<Department, LinkedHashSet<Employee>>();
	}
	
	public static Company getInstance(String name){
		if(company == null){
			company = new Company(name);
		}
		
		return company;
	}

	public String getName(){
		return this.name;
	}
	
	private void setName(String name) {
		if(name != null){
			this.name = name;
		}
	}
	
	public HashMap<Department,LinkedHashSet<Employee>> getWorkers(){
		return workers;
	}
	
	public void createDepartmentInCompany(Department department){
		workers.put(department, new LinkedHashSet<Employee>());
	}
	
	public void addWorkerInDepartment(Employee employee, Department department){
		if(!workers.keySet().contains(department)){
			createDepartmentInCompany(department);
		}
		
		if(employee != null && department != null && Employee.getEmployeesSet().contains(employee) && Department.getDepartmentsSet().contains(department)){
			workers.get(department).add(employee);
		}
	}
	
	public void printWorkersFromDepartment(Department department){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.addAll(workers.get(department));
		Collections.sort(employees,(e1,e2) -> e1.getName().compareTo(e2.getName()));
		System.out.println("List of the employees in " + department.getName() + " department,sorted by their names:");
		System.out.println(employees);
	}
}
