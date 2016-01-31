package braces;

import java.util.Stack;

public class Bracket {
	private static int methodCallCount = 1;
	public static void validateBrackets(String expression){
		Stack<Character> braces = new Stack<Character>();
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '{'){
				braces.push('{');
			}
			else if(expression.charAt(i) == '}'){
				if(!braces.isEmpty()){
					braces.pop();
				}
				else{
					System.out.println("Expression " + (methodCallCount++) + " is not valid!");
					return;
				}
			}
		}
		if(braces.isEmpty()){
			System.out.println("Expression " + (methodCallCount++) + " is valid!");
		}
		else{
			System.out.println("Expression " + (methodCallCount++) + " is not valid!");
		}
	}
}
