package computer;

public class Computer {
	
	int year;
	double price;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operationSystem;
	
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
