package employees;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;

public class Employee {
	private String name;
	private int age;
	private Double salary;
	private int iD;
	private static int workersCount = 1;
	public static LinkedHashSet<Employee> employeesSet = new LinkedHashSet<Employee>();
	private LinkedHashMap<String,Integer> salariesForEachMonth = new LinkedHashMap<String, Integer>();
	
	public Employee(String name, int age, Double salary) {
		this.setName(name);
		this.setAge(age);
		this.setSalary(salary);
		this.setSalariesForAllMonths();
		this.iD = workersCount++;
		addEmployee(this);
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		if(name != null){
			this.name = name;
		}
		
	}
	public int getAge() {
		return age;
	}
	private void setAge(int age) {
		if(age >= 18){
			this.age = age;
		}
	}
	public Double getSalary() {
		return salary;
	}
	private void setSalary(Double salary) {
		if(salary >= 300){
			this.salary = salary;
			return;
		}
		this.salary = 300d;
		
	}
	
	public int getID(){
		return this.iD;
	}
	
	public static HashSet<Employee> getEmployeesSet(){
		return employeesSet;
	}
	
	private static void addEmployee(Employee employee){
		for(Employee employeeInSet : employeesSet){
			if(employee.getName().equals(employeeInSet.getName()) && employee.getAge() == employeeInSet.getAge()){
				return;
			}
		}
		employeesSet.add(employee);
	}
	
	private void setSalariesForAllMonths(){
		Random r = new Random();
		String[] allMonths = new DateFormatSymbols().getMonths();
	    for (int i = 0; i < allMonths.length - 1; i++) {
	        String month = allMonths[i];
	        salariesForEachMonth.put(month, r.nextInt(1200) + 300);
	    }
	    
	    
	}
	
	public static void sortOnName(){
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.addAll(employeesSet);
		System.out.println("Sorting all employees based on their names:");
		Collections.sort(emps, (e1,e2) -> e1.getName().compareTo(e2.getName()));
		System.out.println(emps + "\n");
	}
	
	public static void sortOnAge(){
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.addAll(employeesSet);
		System.out.println("Sorting all employees based on their age:");
		Collections.sort(emps, (e1,e2) -> e1.getAge() -e2.getAge());
		System.out.println(emps + "\n");
	}
	
	public static void sortOnSalary(){
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.addAll(employeesSet);
		System.out.println("Sorting all employees based on their salaries:");
		Collections.sort(emps, (e1,e2) -> e1.getSalary().compareTo(e2.getSalary()));
		System.out.println(emps + "\n");
	}
	
	public void printSalaryForEachMonth(){
		for(Map.Entry<String, Integer> salary : salariesForEachMonth.entrySet()){
	    	System.out.println(salary.getKey() + "->" + salary.getValue() + " BGN");
	    }
	}
	
	public String toString(){
		return this.iD + " " + this.name + " " + this.age + " " + this.salary;
	}
	
	
	
	
}
