package student;

public class StudentGroup {

	String groupSubject;
	Student[] students;
	int freePlaces;
	
	StudentGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	StudentGroup(String subject){
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student s){
		if(s!= null){
			if(s.subject.equals(this.groupSubject) && this.freePlaces > 0){
				this.students[students.length - freePlaces] = s;
				this.freePlaces--;
				System.out.println(s.name + " was added successfully in " + this.groupSubject);
			}
			else if(this.freePlaces == 0){
					System.out.println(this.groupSubject + " is full,which means " + s.name + " cannot be added this year!");
			}
		}
		else{
			System.out.println("You didn't fill your fields!");
		}
	}
	
	void emptyGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	String getTheBestStudent(){
		double maxGrade = this.students[0].grade;
		int studentIndex = 0;
		for(int i = 1; i < this.students.length; i++){
			if(this.students[i].grade > maxGrade){
				maxGrade = this.students[i].grade;
				studentIndex = i;
			}
		}
		return students[studentIndex].name;
	}
	
	void printStudentsInGroup(){
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Name           |Subject   |Grade    |Years in college     |Age     |Graduated     |Money     |");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(int i = 0; i < this.students.length; i++){
			System.out.print(this.students[i].name + "    " + this.students[i].subject + "           " + this.students[i].grade + "              " + this.students[i].yearsInCollege + "           " +  this.students[i].age + "        " +  this.students[i].isDegree + "           " + this.students[i].money + "     |\n");
			
		}
		System.out.println("----------------------------------------------------------------------------------------------");
	}
}
