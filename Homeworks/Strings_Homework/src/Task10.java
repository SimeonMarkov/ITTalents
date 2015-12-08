import java.util.Scanner;


/*
 * Задача 10:
Да се състави програма, която по даден низ връща друг,
символите, на който са получени като към всеки код на символ
от ASCII таблицата е добавеното числото 5 и е записан
новополучения символ.
Пример :
Вход: Hello
Изход: Mjqqt
 */

public class Task10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String initialString = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < initialString.length(); i++){
			sb.append((char)(initialString.charAt(i) + 5)); //when we add 5,we add int to char,which means we add this int to the ascii code of the char ,so at the end we need to convert this sum back to char and append it in the StringBuilder
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
