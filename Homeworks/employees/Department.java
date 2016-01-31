package employees;

import java.util.LinkedHashSet;

public class Department implements Comparable<Department>{
	
	private String name;
	private static LinkedHashSet<Department> departmentsSet = new LinkedHashSet<Department>();
	 
	Department(String name){
		this.setName(name);
		addDepartment(this);
	}

	public String getName(){
		return this.name;
	}
	
	private void setName(String name) {
		if(name != null){
			this.name = name;
		}
	}

	public static LinkedHashSet<Department> getDepartmentsSet(){
		return departmentsSet;
	}
	
	private static void addDepartment(Department department){
		if(department != null){
			departmentsSet.add(department);
		}
	}
	@Override
	public int compareTo(Department departmnet) {
		return name.compareTo(departmnet.name);
	}
}
