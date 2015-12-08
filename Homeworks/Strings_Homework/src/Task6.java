import java.util.Scanner;


/*
 * Задача 6:
Да се състави програма, чрез която се въвежда изречение с отделни
думи.
Като резултат на екрана да се извежда същия текст, но всяка отделна
дума да започва с главна буква, а следващите я букви да са малки.
Пример: супер яката задача
Изход: Супер Яката Задача

 */

public class Task6 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		String sentence = sc.nextLine();
		
		//we split the sentence with split() by " " as delimeter so we can access a single word from the whole string
		String[] splittedSentence = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < splittedSentence.length; i++){
			
			//for each word,replace its first letter with the same letter but uppercased(because of the replace and uppercase methods I use substring instead charAt)
			splittedSentence[i] = splittedSentence[i].replace(splittedSentence[i].substring(0,1), splittedSentence[i].substring(0,1).toUpperCase());
			sb.append(splittedSentence[i] + " ");//concatenating with StringBuilder recommended
		}
		System.out.println("This is the new sentence:");
		System.out.println(sb.toString());
		
		sc.close();
	}
}
