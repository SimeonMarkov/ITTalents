import java.util.Scanner;


/*
 * Задача 8:
Да се състави програма, чрез която се въвежда ред от символи
(стринг, низ).
Програмата да изведе на екрана дали въведения стринг е палиндром,
т.е. дали четен отляво-надясно и отдясно-наляво е един и същ.
Вход: капак
Изход: да.
Вход: тенджера
Изход: не.
 */

public class Task8 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some string:");
		String str = sc.nextLine();
		
		boolean isStringPalindrome = true;
		for(int i = 0; i < str.length(); i++){
			//we did this for ints already
			if(str.charAt(i) != str.charAt(str.length() - i - 1)){
				isStringPalindrome = false;
				break;
			}
		}
		if(isStringPalindrome){
			System.out.println(str + " is a palindrome!");
		}
		else{
			System.out.println(str + " is not a palindrome!");
		}
		
		sc.close();
	}
}
