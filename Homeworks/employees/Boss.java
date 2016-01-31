package employees;

public class Boss extends Employee{

	private String title;
	public Boss(String name, int age, Double salary,String title) {
		super(name, age, salary);
		this.setTitle(title);
	}
	
	private void setTitle(String title){
		if(title != null){
			this.title = title;
		}
	}
	
	public String getTitle(){
		return this.title;
	}

}
