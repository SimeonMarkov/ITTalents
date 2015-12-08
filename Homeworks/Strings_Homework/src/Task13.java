import java.util.Scanner;


/*
 * Задача 13:
Да се създаде метод, който приема два масива от числа и връща
масив, съдържащ всички елементи на подадените масиви, като в
първата част на масива са елементите на първия подаден масив,
а във втората част – тези на втория подаден масив.

 */

public class Task13 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int firstArraySize = 0;
		int secondArraySize = 0;
		
		//input validation
		do{
			System.out.println("Enter size for the first array:");
			firstArraySize = sc.nextInt();
			System.out.println("Enter size for the second array:");
			secondArraySize = sc.nextInt();
		}
		while(firstArraySize <= 0 || secondArraySize <= 0);
		
		int[] firstArray = new int[firstArraySize];
		int[] secondArray = new int[secondArraySize];
		
		//filling first array
		fillArray(firstArray);
		//filling second array
		fillArray(secondArray);
		
		int[] firstPlusSecondArray = concatArrays(firstArray, secondArray);
		
		for(int i = 0; i < firstPlusSecondArray.length; i++){
			System.out.print(firstPlusSecondArray[i] + " ");
		}
		System.out.println();
		
		
		
		sc.close();
		
	}
	
	@SuppressWarnings("resource")
	static void fillArray(int[] array){
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < array.length; i++){
			System.out.println("Enter an element in cell " + (i + 1));
			array[i] = sc.nextInt();
		}
		
	}
	
	static int[] concatArrays(int[] firstArray, int[] secondArray){
		
		//declare an array with size enough to hold both argument arrays
		int[] resultArray = new int[firstArray.length + secondArray.length];
		
		//filling the left part of the result array with the first argument array
		for(int i = 0; i < resultArray.length - secondArray.length; i++){
			resultArray[i] = firstArray[i];
		}
		
		//filling the right part of the result array with the second argument array

		for(int i = resultArray.length - secondArray.length, j = 0; i < resultArray.length; i++, j++){
			resultArray[i] = secondArray[j];
		}
		return resultArray;
	}
}
