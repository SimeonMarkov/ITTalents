package student;

public class Student {
	String name;
	String subject;
	float grade;
	byte yearsInCollege;
	int age;
	boolean isDegree;
	double money;
	
	Student(){
		this.grade = 4;
		this.yearsInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	Student(String name, String subject, int age){
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	
	void upYear(){
		if(!this.isDegree){
			System.out.println(this.name + " passed year " + this.yearsInCollege + " in college!");
			this.yearsInCollege++;
			this.age++;
			if(this.yearsInCollege == 4){
				isDegree = true;
			}
		}
		else{
			System.out.println(this.name + " has already graduated in " + this.subject);
			this.age++;
		}
	}
	
	double receiveScholarShip(double min, double amount){
		if(this.grade >= min && this.age < 30){
			this.money += amount;
		}
		return this.money;
	}
	
}
