import java.time.Period;


public class CarVignette extends Vignette{

	private static final double DAILY_PRICE = 5;
	private static final double MONTH_PRICE = DAILY_PRICE * 10;
	private static final double YEAR_PRICE = DAILY_PRICE * 60;
	
	CarVignette(Period period) {
		super(period);
		
	}

	public Color getColor(){
		return super.getColor();
	}
	

	public double getPrice() {
		return (this.getPeriod().getYears() == 1) ? YEAR_PRICE : ((this.getPeriod().getMonths() == 1) ? MONTH_PRICE : DAILY_PRICE);
	}


}
