
public class ComputerDemo {
	
	public static void main(String[] args) {
		
		Computer asus = new Computer();
		asus.year = 2012;
		asus.price = 1050;
		asus.hardDiskMemory = 1000;
		asus.freeMemory = 900;
		asus.operationSystem = "Windows 8.1";
		
		
		
		Computer dell = new Computer();
		dell.year = 2009;
		dell.price = 890;
		dell.hardDiskMemory = 750;
		dell.freeMemory = 500;
		dell.operationSystem = "Windows 7 Ultimate";
		
		
		asus.isNotebook = true; //let one of the computers be laptop(notebook)
		dell.useMemory(100); //using 100 GB of one of the computers' free memory
		asus.changeOperationSystem("Windows 10"); //setting new operation system to the other computer
		
		
		System.out.println("Asus' parametres:" );
		asus.printFields();
		System.out.println();
		System.out.println("Dell's parametres:" );
		dell.printFields();
	}
}
