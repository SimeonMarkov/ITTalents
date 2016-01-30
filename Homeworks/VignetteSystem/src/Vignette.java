import java.time.LocalDate;
import java.time.Period;


public abstract class Vignette {
	private LocalDate date = LocalDate.now();
	private Period period;
	private Color color;
	
	public static final Period DAILY_VIGNETTE = Period.ofDays(1);
	public static final Period MONTH_VIGNETTE = Period.ofMonths(1);
	public static final Period YEAR_VIGNETTE = Period.ofYears(1);
	
	
	Vignette(Period period){
		this.setPeriod(period);
		this.setDeadline(period);
		this.setColor();
	}
	
	public Color getColor(){
		return this.color;
	}

	
	public LocalDate getDate(){
		return this.date;
	}
	
	public Period getPeriod(){
		return this.period;
	}
	
	public String printPeriod(){
		return this.period.getYears() + " years," + this.period.getMonths() + " months and " + this.period.getDays() + " days remaining";
	}
	
	private void setPeriod(Period period){
		if(period == null){
			this.period = DAILY_VIGNETTE;
		}
		this.period = period;
	}
	
	private void setDeadline(Period period){
		if(period == null){
			this.date.plus(DAILY_VIGNETTE); 
		}
		this.date.plus(period);
	}
	
	public void setColor(){
		if(this instanceof CarVignette){
			this.color = Color.RED;
		}
		else if(this instanceof TruckVignette){
			this.color = Color.GREEN;
		}
		else{
			this.color = Color.BLUE;
		}
	}
	
	
	
	public abstract double getPrice();
	
}
