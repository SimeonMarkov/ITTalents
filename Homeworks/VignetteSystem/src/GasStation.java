import java.time.Period;
import java.util.Random;


public class GasStation {
	private Random r = new Random();
	private double cash;
	private Vignette[] vignettes = new Vignette[10_000];
	private int soldVignettes = 0;
	private static final int VIGNETTE_TYPE = 2;
	public GasStation(double cash) {
		super();
		this.cash = cash;
		for (int i = 0; i < this.vignettes.length; i++) {
			this.vignettes[i] = (r.nextInt(VIGNETTE_TYPE) == 0) ? new CarVignette(pickRandomVignetteDuration()) : ((r.nextInt(VIGNETTE_TYPE) == 1) ? new TruckVignette(pickRandomVignetteDuration()) : new BusVignette(pickRandomVignetteDuration()));
		}
	}
	
	public static Period pickRandomVignetteDuration(){
		Random r = new Random();
		if(r.nextInt(VIGNETTE_TYPE) == 0){
			return Vignette.DAILY_VIGNETTE;
		}
		else if(r.nextInt(VIGNETTE_TYPE) == 1){
			return Vignette.MONTH_VIGNETTE;
		}
		return Vignette.YEAR_VIGNETTE;
	}
	
	
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public Vignette[] getVignettes() {
		return vignettes;
	}
	public void setVignettes(Vignette[] vignettes) {
		this.vignettes = vignettes;
	}
	
	public void sortVignettesByPrice(){
		for(int i = 0; i < this.vignettes.length - soldVignettes; i++){
			for(int j = 0 ; j < this.vignettes.length - soldVignettes - i - 1; j++){
				if(this.vignettes[j].getPrice() > this.vignettes[j + 1].getPrice()){
					Vignette temp = this.vignettes[j];
					this.vignettes[j] = this.vignettes[j + 1];
					this.vignettes[j + 1] = temp;
				}
			}
		}
	}
	public void sellVignette(Vignette vignette) {
		if(soldVignettes < this.vignettes.length){
			if (vignette != null) {
				System.out.println("The price is " + vignette.getPrice());
				this.cash += vignette.getPrice();
				for(int i = 0; i < this.vignettes.length - soldVignettes; i++){
					if(this.vignettes[i].getClass().equals(vignette.getClass()) && this.vignettes[i].getPeriod().equals(vignette.getPeriod())){
						this.vignettes[i] = this.vignettes[this.vignettes.length - 1 - soldVignettes];
						this.vignettes[this.vignettes.length - 1 - soldVignettes++] = null;
						this.sortVignettesByPrice();
						return;
					}
					
				}
				System.out.println("Either no more vignettes of type " + vignette.getClass() + " or no vignette from type " + vignette.getClass() + " and period " + vignette.getPeriod());
				
			} 
			else {
				System.out.println("You didn't point what kind of vignette do you want!");
			}
		}
		else{
			System.out.println("We're out of vignettes!Sorry!");
		}
	}
	
	public int getAvailableVignettesCount(){
		if(this.vignettes.length >= soldVignettes){
			return this.vignettes.length - soldVignettes;
		}
		return 0;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < this.vignettes.length - 1; i++){
			sb.append(this.vignettes[i] + ",");
		}
		sb.append(this.vignettes[this.vignettes.length - 1] + "]");
		return sb.toString();
	}


	
}
