
public class CreditCard {
	
	private long creditCardNumber;

	public CreditCard(long creditCardNumber) {
		super();
		this.creditCardNumber = creditCardNumber;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	} 
	
	public boolean isValid(){
		int sum = 0;
        int count = 0;

        while (creditCardNumber > 0)
        {
        	count++;
            int digit = (int)(creditCardNumber % 10); 
            if (count%2 == 1) {
            	sum = sum + digit;
            } else if (digit < 5){
            	sum = sum + 2 * digit; 
            } else{
            	sum = sum + 2 * digit - 9; 
            }
            creditCardNumber = creditCardNumber/10;
        } 
                
        if (sum % 10 == 0) {
        	return true;
        } else {
        	return false;	
        }
	}
}
          
            
            
