import java.util.Scanner;


/*
 * Задача 14:
Да се състави метод, който приема за стойност число N и връща
стойността на N! (N факториел).
 */

public class Task14 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = 0;
		do{
			System.out.println("Enter a positive number");
			number = sc.nextInt();
		}
		while(number <= 0);
		
		System.out.println(number + "! = " + calculateFactorial(number));
		sc.close();
	}
	
	static int calculateFactorial(int number){
		int result = 1;
		for(int i = 2; i <= number; i++){
			result *= i;
		}
		
		return result;
	}
}
