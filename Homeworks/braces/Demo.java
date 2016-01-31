package braces;


public class Demo {
	
	public static void main(String[] args) {
		
		Bracket.validateBrackets(new String("{{}{{}{}}"));
		Bracket.validateBrackets(new String("{}{}"));
		Bracket.validateBrackets(new String("{{}}"));
	}
}
