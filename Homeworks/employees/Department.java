package employees;

import java.util.HashSet;

public class Department implements Comparable<Department>{
	
	private String name;
	private static HashSet<Department> departmentsSet = new HashSet<Department>();
	 
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

	public static HashSet<Department> getDepartmentsSet(){
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
