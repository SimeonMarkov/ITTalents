import java.time.LocalDate;
import java.time.Period;


public class Driver {
	
	private String name;
	private Vehicle[] vehicles = new Vehicle[10];
	private double cash;
	private GasStation currentGasStation;
	public Driver(String name, double cash, GasStation currentGasStation) {
		this.name = name;
		this.cash = cash;
		this.currentGasStation = currentGasStation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getExpiredVignetteVehicles(LocalDate expiringDate){
		for(int i = 0; i < this.vehicles.length; i++){
			if(this.vehicles[i].getCurrentVignetteOnWindow() != null && this.vehicles[i].getCurrentVignetteOnWindow().getDate().isAfter(expiringDate)){
				System.out.println(this.vehicles[i]);
			}
		}
	}
	
	public Vehicle[] getVehicles() {
		return vehicles;
	}
	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public GasStation getCurrentGasStation() {
		return currentGasStation;
	}
	public void setCurrentGasStation(GasStation currentGasStation) {
		this.currentGasStation = currentGasStation;
	}
	
	
	
	
	public boolean hasMoneyForVignette(Vignette vignette){
		return this.cash >= vignette.getPrice();
	}
	
	public void putVignetteOnWindow(Vignette vignette, Vehicle vehicle){
		if(vignette != null){
			if(vehicle.getCurrentVignetteOnWindow() == null || vehicle.getCurrentVignetteOnWindow().getDate().isAfter( LocalDate.now())){
				vehicle.setCurrentVignetteOnWindow(vignette);
			}
		}
		
	}
	
	public void buyVignette(){
		
		if(this.currentGasStation.getVignettes()[0] == null){
			System.out.println("We're out of vignettes!");
		}
		else{
			System.out.println(this.getName() + " is buying some vignettes...");
			for(int i = 0; i < this.vehicles.length; i++){
				boolean isThereVignetteOfCurrentType = false;
				Vignette vignette = (this.vehicles[i] instanceof Car) ? new CarVignette(GasStation.pickRandomVignetteDuration()) : ((this.vehicles[i] instanceof Truck) ? new TruckVignette(GasStation.pickRandomVignetteDuration()) : new BusVignette(GasStation.pickRandomVignetteDuration()));
				for(int j = 0; j < this.currentGasStation.getAvailableVignettesCount(); j++){
					if(this.currentGasStation.getVignettes()[j] != null && vignette.getClass().equals(this.currentGasStation.getVignettes()[j].getClass())){
						isThereVignetteOfCurrentType = true;
						if(hasMoneyForVignette(vignette)){
							this.currentGasStation.sellVignette(vignette);
							System.out.println(vignette.getPeriod() + " " + vignette.getClass() + " vignette bought!");
							this.cash -= vignette.getPrice();
							this.putVignetteOnWindow(vignette,vehicles[i]);
							break;
						}
						else{
							System.out.println("Sorry,but you have less than " + vignette.getPrice() + ",so you can't afford a (" + vignette.getClass() + ")" + vignette.getPeriod() + " vignette!");
						}
						
					}
					
				}
				if(!isThereVignetteOfCurrentType){
					System.out.println("We're out of (" + vignette.getClass() + ") vignettes!");
				}
			}
		}
	}
	
	
	
	public void buyVignette(Vehicle vehicle, Period period){
		if(this.currentGasStation.getVignettes()[0] == null){
			System.out.println("We're out of vignettes!");
		}
		else{
			boolean isThereVignetteOfCurrentType = false;
			Vignette vignette = (vehicle instanceof Car) ? new CarVignette(period) : ((vehicle instanceof Truck) ? new TruckVignette(period) : new BusVignette(period));
			for(int i = 0; i < this.currentGasStation.getAvailableVignettesCount(); i++){
				if(this.currentGasStation.getVignettes()[i] != null && vignette.getClass().equals(this.currentGasStation.getVignettes()[i].getClass())){
					System.out.println(this.getName() + " is buying some vignettes...");
					isThereVignetteOfCurrentType = true;
					if(hasMoneyForVignette(vignette)){
						this.currentGasStation.sellVignette(vignette);
						this.cash -= vignette.getPrice();
						for(int j = 0; j < this.vehicles.length; j++){
							if(vehicles[j].getCurrentVignetteOnWindow() == null){
								this.putVignetteOnWindow(vignette,vehicles[j]);
								break;
							}
						}
						break;
					}
					else{
						System.out.println("Sorry,but you have less than " + vignette.getPrice() + ",so you can't afford a (" + vignette.getClass() + ")" + vignette.getPeriod() + " vignette!");
					}
				}
			}
			if(!isThereVignetteOfCurrentType){
				System.out.println("We're out of " + vignette.getClass() + " vignettes!");
			}
		}
		

	}
	
	
	
	public void printVehiclesWithOutOfDateVignettes(LocalDate date){
		if(date != null){
			for(int i = 0; i < this.vehicles.length; i++){
				if(this.vehicles[i].getCurrentVignetteOnWindow().getDate().isAfter(date)){
					System.out.println(this.vehicles[i]);
				}
			}
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < this.vehicles.length; i++){
			sb.append(this.getName() + " " + this.vehicles[i].getModel() + "," + this.vehicles[i].getCurrentVignetteOnWindow() + ";");
		}
		sb.append("]");
		return sb.toString();
		
	}
}
