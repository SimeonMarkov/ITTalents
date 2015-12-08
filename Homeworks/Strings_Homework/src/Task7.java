import java.util.Scanner;


/*
 * Задача 7:
Да се състави програма, която чете набор от думи разделени с
интервал.
Като резултат да се извеждат броя на въведените думи, както и броя
знаци в най-дългата дума.
Пример: asd fg hjkl
Изход: 3 думи, най-дългата е с 4 символа.

 */

public class Task7 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter some words separated with intervals:");
		String wordsString = sc.nextLine();
		//splitting the string with split() by " " as a delimeter so that I can count every separated word
		String[] splittedWordsString = wordsString.split(" ");
		System.out.println("The number of the words inputed is " + splittedWordsString.length);
		
		//from all the separated words i get the one with maximum length(i need to set maxLength = firstWord.length or something like that,because a length of a string can be 0 at the worst case
		int maxLength = 0;
		for(int i = 0; i < splittedWordsString.length; i++){
			if(splittedWordsString[i].length() > maxLength){
				maxLength = splittedWordsString[i].length();
			}
		}
		
		// printing how long is the longest word
		System.out.println("The longest from the words has length " + maxLength);
		sc.close();
		
	}
}
