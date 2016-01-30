

public abstract class Vehicle {
	private String model;
	private Vignette currentVignetteOnWindow;
	private int year;
	
	public Vehicle(String model, int year) {
		this.model = model;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(model == null){
			this.model = "Vehicle_Model";
			return;
		}
		this.model = model;
	}
	
	public Vignette getCurrentVignetteOnWindow() {
		return currentVignetteOnWindow;
	}
	
	public void setCurrentVignetteOnWindow(Vignette vignette){
		this.currentVignetteOnWindow = vignette;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	public String toString(){
		return "[" + this.model + ";" + this.currentVignetteOnWindow + ";" + this.year + "]";
	}
}
