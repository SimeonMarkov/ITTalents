import java.util.Scanner;


/*
 * Задача 2:
Да се състави програма, чрез която от клавиатурата се въвеждат
последователно две думи с дължина 10-20 знака.
Програмата да размени първите им 5 знака и да изведе дължината на
по-дългата, както и новото им съдържание.
Пример: uchilishe uchenik
Изход: 9 uchenishe

 */

public class Task2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String firstWord = "";
		String secondWord = "";
		
		do{
			System.out.println("Please enter a word:");
			firstWord = sc.nextLine();
			System.out.println("Now,enter another word:");
			secondWord = sc.nextLine();
		}
		while(firstWord.length() < 10 || firstWord.length() > 20 || secondWord.length() < 10 || secondWord.length() > 20); 
		
		//with substring we take part from the string with length = k (k <= string.length)
		String swapWord = firstWord;
		firstWord = firstWord.replace(firstWord.substring(0,5), secondWord.substring(0,5));
		secondWord = secondWord.replace(secondWord.substring(0,5), swapWord.substring(0,5));

		if(firstWord.length() > secondWord.length()){
			System.out.print(firstWord.length() + " ");
			System.out.println(firstWord);
		}
		else{
			System.out.print(secondWord.length() + " ");
			System.out.println(secondWord);
		}
		sc.close();
	}

}
