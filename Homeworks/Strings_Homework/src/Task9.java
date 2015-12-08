import java.util.Scanner;

/*OLD
 * Задача 9:
 Да се състави програма, чрез която по въведен низ съдържащ букви,
 цифри, знак минус '-' се извежда сборът на въведените числа като се
 отчита знакът '-' пред съответното число.
 Вход: asd-12sdf45-56asdf100
 Изход:
 -12
 45
 -56
 100
 Сума = 77

 */

public class Task9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some string:");
		String expression = sc.nextLine();
		//from one string i need a few substrings,which can happen with splitting ,but not using " " as delimeter this time
		//but using a regular expression -> [^0-9]+ means split this string by every sequence that doesn't have digits and it and is has random length
		// from 12frow4grnoe55e we get as a result 12,4,55 , because frow,grnoe and e complete the condition of the regex above
		//Note! when we split by a delimeter,that means we get every sequence left from a delimeter,right from delimeter or between two delimeters
		String[] splittedExpression = expression.split("[^0-9]+");

		int sum = 0;
		//since I'm not allowed to use Integer.parseInt() method and we can't directly convert string to int,we need to convert every char from a string to int
		//we can just convert every char from all the numbers in the string to a legit digit by 
		//multiplying it with factor to the power of the position of the digit,e.g. 12 -> 2*factor,where factor is pow(10,0)
		//1*factor,where factor is changed to pow(10,1) and so on
		//why do we subtract 48? because the int value of '0' is not 0!-> it's 48,so '1' = 49 and so on,which means we can do '0' - 48 = 0,'2' - 48 = 2
		//(because the ASCII code of '2' is actually 50 etc.)
		int factor = 1; 
		for (int i = 0; i < splittedExpression.length; i++) {
			if (!splittedExpression[i].equals("")) {
				for (int j = splittedExpression[i].length() - 1; j >= 0; j--) {
					//we check if the string start with a number itself,but if it starts with -(number) ,we need to to checks
					if ((expression.indexOf(splittedExpression[i]) > 0)) {
						if(expression.charAt(expression.indexOf(splittedExpression[i]) - 1) == '-'){
							sum -= (splittedExpression[i].charAt(j) - 48) * factor;
							factor *= 10;
						}
						else{
							sum += (splittedExpression[i].charAt(j) - 48) * factor;
							factor *= 10;
						}
					}
					else{
						sum += (splittedExpression[i].charAt(j) - 48) * factor;
						factor *= 10;
					}
				
				}
				expression = expression.replace(expression, expression.substring(expression.indexOf(splittedExpression[i]) + splittedExpression[i].length() ,expression.length()));
			}
			else{
				continue;
			}
			factor = 1;
		}
				
			

		// TODO: figure out how to convert string to int without using
		// parseInt() method !!!!!

		System.out.println("The sum of all numbers in the string is " + sum);
		sc.close();
	}
}
