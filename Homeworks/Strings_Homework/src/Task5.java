import java.util.Scanner;


/*
 * Задача 5:
Да се състави програма, чрез която се въвеждат 2 редици от знаци
(думи).
Ако в двете редици участва един и същи знак, да се изведе на екрана
първата редица хоризонтално, а втората вертикално, така че да се
пресичат в общия си знак.
Ако редиците нямат общ знак да се изведе само уведомително
съобщение.
Пример :
м
а
шапка
и
н
а
 */

public class Task5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first word(it will be printed horizontally):");
		String firstWord = sc.nextLine();
		System.out.println("Enter second word(it will be printed vertically):");
		String secondWord = sc.nextLine();
		int rows = 0,cols = 0;
		
		boolean isLetterCommon = false;
		for(int i = 0; i < firstWord.length(); i++){
			for(int j = 0; j < secondWord.length(); j++){
				if(firstWord.charAt(i) == secondWord.charAt(j)){
					rows = j; //before breaking the loops,we should know how much right and how much down to print the words;ofc that depends on the incides of the common letter
					cols = i;
					isLetterCommon = true;
					break;
				}
			}
			if(isLetterCommon){
				break;
			}
		}
		char[][] crossWords = new char[secondWord.length()][firstWord.length()];	//the two words actually look like words in a crossword,that's why for the printing we fill 2d array
		for(int i = 0; i < crossWords.length; i++){
			for(int j = 0; j < crossWords[i].length; j++){
				if(i == rows){	//when we get to row with index = rows,which was remembered by us,on this whole row we print the first(horizontal) word by filling each cell of the row
					crossWords[i][j] = firstWord.charAt(j);
				}
				else if(j == cols){	//same logic as the rows
					crossWords[i][j] = secondWord.charAt(i);
				}
				else{	//for every other cell in the 2d array,we could fill it just with ' '
					crossWords[i][j] = ' ';
				}
					
			}
		}
		
		//print the crossword
		for(int i = 0; i < crossWords.length; i++){
			for(int j = 0; j < crossWords[0].length; j++){
				System.out.print(crossWords[i][j] + " ");
				
			}
			System.out.println();
		}

		sc.close();
	}
}
