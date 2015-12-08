import java.util.Scanner;


/*
 * Задача 11:
Да се създаде метод, който отпечатва масив в конзолата.
 */

public class Task11 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = 0;
		
		//input validation for sie of the array
		do{
			System.out.println("Enter a size for the array:");
			size = sc.nextInt();
		}
		while(size <= 0);
		
		int[] array = new int[size];
		
		//filling array
		for(int i = 0; i < array.length; i++){
			System.out.println("Enter a value in cell [" + (i + 1) + "]");
			array[i] = sc.nextInt();
		}
		printArray(array);
		sc.close();
	}
	
	static void printArray(int[] array){
		System.out.println("This is your array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
