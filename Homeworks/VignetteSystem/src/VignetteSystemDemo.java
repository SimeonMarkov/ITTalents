import java.time.LocalDate;
import java.time.Period;
import java.util.Random;


public class VignetteSystemDemo {
	private static LocalDate date = LocalDate.now();
	public static void main(String[] args) {
		Random r = new Random();
		
		//1.create a gas station
		GasStation gasStation = new GasStation(1_000);
		
		
		//2.create 20 drivers
		Driver[] drivers = new Driver[20];
		for(int i = 0; i < drivers.length; i++){
			drivers[i] = new Driver("Driver " + (i + 1), 1_200, gasStation);
		}
		
		
		//3.create 200 vehicles
		Vehicle[] vehicles = new Vehicle[200];
		for(int i = 0; i < vehicles.length; i++){
			vehicles[i] = (r.nextInt(2) == 0) ? new Car("Car " + (i + 1), 2007) : ((r.nextInt(2) == 1) ? new Truck("Truck " + (i + 1), 2005) : new Bus("Bus " + (i + 1), 2002));
		}
		
		//distributing all the vehicles amongst the drivers
		int k = 0;
		for(int i = 0; i < drivers.length; i++){
			for(int j = 0; j < drivers[i].getVehicles().length; j++){
				drivers[i].getVehicles()[j] = vehicles[k++];
			}
		}
		
		//print all vignettes in the gas station
		for(int i = 0; i < gasStation.getVignettes().length; i++){
			System.out.println(gasStation.getVignettes()[i] + " " + gasStation.getVignettes()[i].getColor() + " " + gasStation.getVignettes()[i].getPrice());
		}
		
		
		System.out.println("---------");
		//sort the vignettes in the gas station by price and then print them again
		gasStation.sortVignettesByPrice();
		
		for(int i = 0; i < gasStation.getVignettes().length; i++){
			System.out.println(gasStation.getVignettes()[i] + " " + gasStation.getVignettes()[i].getColor() + " " + gasStation.getVignettes()[i].getPrice());
		}
		
		//each 3rd driver should buy for some of his vehicles 5 vignettes each
		//for the other drivers - they should buy vignettes for all their vehicles
		//in both cases,generate random deadline for each vignette
		for(int i = 0; i < drivers.length; i++){
			if(i % 3 == 2){
				for(int j = 0; j < drivers[i].getVehicles().length; j++){
					if(r.nextBoolean()){
						for(int m = 0; m < 5; m++){
							drivers[i].buyVignette(drivers[i].getVehicles()[j], GasStation.pickRandomVignetteDuration());
						
						}
					}
				}
			}
			else{
				drivers[i].buyVignette();
			}
		}
		
		//let's change date in order to make some vignettes expired
		date = date.plus(Period.ofYears(5));
		
		System.out.println("--------");
		
		drivers[0].buyVignette(drivers[0].getVehicles()[0],Vignette.MONTH_VIGNETTE);
		
		
		//print info for all drivers - how many CARS do they have;how many of their vehicles have expired vignettes(just count them);print each driver's cash
		for(int i = 0; i < drivers.length; i++){
			int expiredVignettesCount = 0;
			int carsDriven = 0;
			System.out.println(drivers[i].getName() + " " + drivers[i].getCash());
			for(int j = 0; j < drivers[i].getVehicles().length; j++){
				if(drivers[i].getVehicles()[j] instanceof Car){
					carsDriven++;
				}
				if(drivers[i].getVehicles()[j].getCurrentVignetteOnWindow() != null && drivers[i].getVehicles()[j].getCurrentVignetteOnWindow().getDate().isBefore(date)){
					expiredVignettesCount++;
				}
			}
			System.out.println("Total cars driven:" + carsDriven);
			System.out.println("Total vehicles with expited vignettes:" + expiredVignettesCount);
		}
		
		System.out.println(gasStation);
		
		//if truck's current vignette's deadline is smaller(before) than current date,this means it has expired
		for(int i = 0; i < vehicles.length; i++){
			if(vehicles[i]instanceof Truck && vehicles[i].getCurrentVignetteOnWindow() != null && vehicles[i].getCurrentVignetteOnWindow().getDate().isBefore(date)){
				System.out.println(vehicles[i]);
			}
		}
		
		System.out.println(date);
		
		
		
	}
}
