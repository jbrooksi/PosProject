import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Transaction {
	
	private Product item;
	private int quatity;
	
		
	public Transaction(Product item, int quatity) {
		super();
		this.item = item;
		this.quatity = quatity;
	}
	
	public double subTotal () {
		
		
		double tax = 0.06;
		
		double pr = item.getPrice();
		double subTotal =  quatity * (pr + tax * pr);
		subTotal = new BigDecimal(subTotal)
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
		return subTotal;
	}

	public int getQuatity() {
		return quatity;
	} 
	
	
}	
