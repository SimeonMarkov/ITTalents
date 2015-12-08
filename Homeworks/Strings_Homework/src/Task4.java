import java.util.Scanner;


/*
 * Задача 4:
Да се състави програма, чрез която по въведени трите имена на двама
човека разделени със запетая, се извежда чие име има по-голям сбор
от ASCII кодовете на съставящите името букви.
Пример: Anna Dosewa Asenowa, Iwo Peew Peew
Изход: Anna Dosewa Asenowa

 */

public class Task4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first person's names:");
		String firstPerson = sc.nextLine();
		System.out.println("Enter second person's names:");
		String secondPerson = sc.nextLine();
		
		
		String biggerASCIIName = (asciiSum(firstPerson) > asciiSum(secondPerson) ? firstPerson : secondPerson);
		System.out.println(biggerASCIIName);
		sc.close();
	}
	
	//we cant just use compareTo- it shows the subtraction of the first two different symbols on position i;
	//we need the sum of ascii of all symbols for the first and the second string
	static int asciiSum(String personName){
		int sum = 0;
		for(int i = 0; i < personName.length(); i++){
			sum += personName.charAt(i);
		}
		
		return sum;
	}
}
