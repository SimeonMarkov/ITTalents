package student;

public class College {
	
	public static void main(String[] args) {
		Student pesho = new Student("Petur Petrov", "KN", 25);
		Student gosho = new Student("Georgi Gogov", "KN", 25);
		Student tosho = new Student("Todor Todorov", "KN", 25);
		tosho.grade = 5;
		Student misho = new Student("Mihail Filipov", "KN", 25);
		misho.grade = 6;
		Student grisho = new Student("Grigor Markov", "KN", 25);
		Student licho = new Student("Iliq Iliev", "KN", 25);
		
		//cs is Computer Science
		StudentGroup cs = new StudentGroup("KN");
		cs.addStudent(pesho);
		cs.addStudent(gosho);
		cs.addStudent(tosho);
		cs.addStudent(misho);
		cs.addStudent(grisho);
		cs.addStudent(licho);
		
		
		
		for(int i = 0; i < 4; i++){
			System.out.println("Table of students in " + cs.groupSubject + " for year " + (i + 1));
			cs.printStudentsInGroup();
			for(int j = 0; j < cs.students.length; j++){
				cs.students[j].receiveScholarShip(4, 80);
				cs.students[j].upYear();
			}
			System.out.println();
			System.out.println(cs.getTheBestStudent() + " has the best grade from all the students in " + cs.groupSubject + " for year " + (i + 1));
			
		}
		
		
		System.out.println();
		cs.emptyGroup();
		//se is Software Engineering
		StudentGroup se = new StudentGroup("SE");
		pesho = new Student("Petur Petrov", se.groupSubject, pesho.age);
		gosho = new Student("Georgi Gogov", se.groupSubject, gosho.age);
		tosho = new Student("Todor Todorov", se.groupSubject, tosho.age);
		tosho.grade = 5;
		misho = new Student("Mihail Filipov", se.groupSubject, misho.age);
		grisho = new Student("Grigor Markov", se.groupSubject, grisho.age);
		licho = new Student("Iliq Iliev", se.groupSubject, licho.age);
		
		se.addStudent(pesho);
		se.addStudent(gosho);
		se.addStudent(tosho);
		se.addStudent(misho);
		se.addStudent(grisho);
		se.addStudent(licho);
		
		
		for(int i = 0; i < 4; i++){
			System.out.println("Table of students in " + se.groupSubject + " for year " + (i + 1));
			se.printStudentsInGroup();
			for(int j = 0; j < se.students.length; j++){
				se.students[j].receiveScholarShip(4.5, 90);
				se.students[j].upYear();
			}
			System.out.println();
			System.out.println(se.getTheBestStudent() + " has the best grade from all the students in " + se.groupSubject + " for year " + (i + 1));
			
		}
		
		se.emptyGroup();
		
		
		
		
	}
}
