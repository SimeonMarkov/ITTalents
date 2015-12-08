import java.util.Scanner;


/*
 * Задача 12:
Да се създаде метод, който приема за входни данни число N и
връща масив от числа с дължина N, който съдържа всички числа
от 1 до N.

 */

public class Task12 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		
		//input validation
		do{
			System.out.println("Enter size for the array:");
			size = sc.nextInt();
		}
		while(size <= 0);
		
		//initializing an array with our method 
		int[] arrayFromOneToN = getOneToNArray(size);
		
		//printing the array
		for(int i = 0; i < arrayFromOneToN.length; i++){
			System.out.print(arrayFromOneToN[i] + " ");
		}
		System.out.println();
		sc.close();
	}
	
	//method to fill an array with values from 1 to size 
	static int[] getOneToNArray(int size){
		int[] array = new int[size];
		for(int i = 0; i < size; i++){
			array[i] = (i + 1);
		}
		return array;
	}
}
