import java.util.Scanner;


/*
 * Задача 1:
Да се състави програма, чрез която се въвеждат два низа съдържащи
до 40 главни и малки букви.
Като резултат на екрана да се извеждат низовете само с главни и само
с малки букви.
Пример: Abcd Efgh
Изход: ABCD abcd EFGH efgh

 */

public class Task1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String firstWord = "";
		String secondWord = "";
		
		//validate if the words length is 40 at the most
		do{
			System.out.println("Please enter a word:");
			firstWord = sc.nextLine();
			System.out.println("Now,enter another word:");
			secondWord = sc.nextLine();
		}
		while(firstWord.length() > 40 || secondWord.length() > 40); // using .length() method to find the length of a String
		
		//we use uppercase() and lowercase() methods for the transformation Abcd -> ABCD and Abcd -> abcd
		System.out.println("These are the two words transformed to uppercase and lowercase each:");
		System.out.print(firstWord.toUpperCase() + " " + firstWord.toLowerCase() + " " + secondWord.toUpperCase() + " " + secondWord.toLowerCase());
		
		sc.close();
	}
}
