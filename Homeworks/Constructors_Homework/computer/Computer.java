package computer;

public class Computer {
	int year;
	double price;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operationSystem;
	
	Computer(){
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	
	Computer(int year, double price, int hardDiskMemory, int freeMemory){
		this();
		this.year = year;
		this.price = price;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
	}
	
	Computer(int year, double price, boolean isNotebook, int hardDiskMemory, int freeMemory, String operationSystem){
		this.year = year;
		this.price = price;
		this.isNotebook = isNotebook;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		this.operationSystem = operationSystem;
	}
	
	int comparePrice(Computer c){
		if(this.price == c.price){
			System.out.println("Both laptops have the same price!");
			return 0;
		}
		else if(this.price > c.price){
			System.out.println("First one is the more expensive one!");
			return -1;
		}
		else{
			System.out.println("Second one is the more expensive one!");
			return 1;
		}
		
	}
	
	void changeOperationSystem(String newOperationSystem){
		operationSystem = newOperationSystem;
	}
	
	void useMemory(int memory){
		if(freeMemory >= memory && memory >= 0){
			freeMemory -= memory;
		}
		else{
			System.out.println("Not enough free memory!");
		}
	}
	
	void printFields(){
		System.out.print("Year:" + year + "\nPrice:" + price + "\nNotebook:" + (isNotebook ? "yes" : "no") + "\nHDD:" + hardDiskMemory + " GB\nFree memory:" + freeMemory + " GB\nOS:" + operationSystem + "\n");
	}
	
}
