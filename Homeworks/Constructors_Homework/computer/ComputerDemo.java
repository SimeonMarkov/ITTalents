package computer;

public class ComputerDemo {
	
	public static void main(String[] args) {
		Computer hp = new Computer();
		Computer asus = new Computer(2012, 970, 1000, 870);
		Computer lenovo = new Computer(2013, 1200, true, 1000, 900, "Windows 10");
		Computer toshiba = new Computer(2011, 970, 750, 600);
		
		System.out.println("This HP's operating system by default is " + hp.operationSystem);
		
		System.out.println(asus.comparePrice(toshiba));
		System.out.println(asus.comparePrice(lenovo));
		System.out.println(lenovo.comparePrice(toshiba));
	}
}
