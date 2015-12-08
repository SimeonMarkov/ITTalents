import java.util.Scanner;

/*
 *Задача 3:
 Да се състави програма, чрез която се въвеждат последователно две
 редици от символи без интервали.
 Програмата да извежда съобщение за резултата от сравнението им по
 позиции.
 Пример: хипопотам, хипопотук
 Изход:
 Двата низа са с равна дължина.
 Разлика по позиции:
 8 а-у
 9 м-к 
 */

public class Task3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word:");
		String firstString = sc.nextLine();
		System.out.println("Please enter another word:");
		String secondString = sc.nextLine();

		boolean isSubstring = true;
		
		//if the two strings have different length,we make a variable with value equal to the length of the shorter word
		if (!firstString.equals(secondString)) {
			int shorterWordLength = ((firstString.length() <= secondString.length()) ? firstString.length() : secondString.length());
			for (int i = 0; i < shorterWordLength; i++) {
				if(firstString.charAt(i) != secondString.charAt(i)){
					isSubstring = false;
					System.out.println((i + 1) + " " + firstString.charAt(i) + "-" + secondString.charAt(i));
				}
			}
		}
		//if equals() is true,both strings have the same content(which means the same length) for sure
		else {
			System.out.println("Both words are the same!");
		}

		
		if(isSubstring){
			System.out.println("One of the words is a substring to the other!");
		}
		sc.close();
	}
}
