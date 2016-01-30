import java.time.Period;


public class TruckVignette extends Vignette {

	
	private static final double DAILY_PRICE = 7;
	private static final double MONTH_PRICE = DAILY_PRICE * 10;
	private static final double YEAR_PRICE = DAILY_PRICE * 60;
	private static final int DURATION = 1;

	TruckVignette(Period period) {
		super(period);
	}
	
	public Color getColor(){
		return super.getColor();
	}
	
	public double getPrice() {
		return (this.getPeriod().getYears() == DURATION) ? YEAR_PRICE : ((this.getPeriod().getMonths() == DURATION) ? MONTH_PRICE : DAILY_PRICE);
	}
	
}
