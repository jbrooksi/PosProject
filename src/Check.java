
public class Check {
	private long rountingNum;
	private long accountNum;

	
	
	public Check(long rountingNum, long accountNum) {
		super();
		this.rountingNum = rountingNum;
		this.accountNum = accountNum;
	}
	
	public boolean checkValid() {
		int count1;
		int count2;
		
		for (count1 = 0; rountingNum > 0; rountingNum = rountingNum/10) {
			count1 = count1 + 1; 
		}
		
		for (count2 = 0; accountNum > 0; accountNum = accountNum/10) {
			count2 = count2 + 1;
		}
	
		if(count1 == 9 && count2 == 10) {
			
			return true;
		} else return false;
	
	}
	
	
	
}
