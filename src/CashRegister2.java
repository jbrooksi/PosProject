import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ProductFile menu = new ProductFile("./StoreItems.txt");
		Transaction tran;
		ArrayList<Product> purchaseList = new ArrayList<Product>();
		ArrayList<Transaction> quanitylist = new ArrayList<Transaction>();
		Product p;
		int productNum;
		String again;
		String totalList;
		int quanity;
		double sum = 0;
		String payment;
		double substotals;
		double change;

		System.out.println("Welcome to the: GET&GO");
		System.out.println("Please enjoy and shop smart" + "\n");

		menu.printMenu();
		System.out.println();

		do {
			System.out.println("Please Choose number of Product you would like to Purchase");
			productNum = scan.nextInt();
			p = menu.getProduct(productNum);
			purchaseList.add(p);
			System.out.println(p);

			System.out.println("How many would you like");
			quanity = scan.nextInt();
			tran = new Transaction(p, quanity);
			quanitylist.add(tran);

			scan.nextLine();
			System.out.println("Would you like to do some more shopping (Yes or No)");
			again = scan.nextLine();
		} while (again.equalsIgnoreCase("yes"));

		
		System.out.println("\nItems in your Shopping cart\n");
		System.out.println(displayCart(purchaseList, quanitylist));
		for (int i = 0; i < purchaseList.size(); i++) {
//			System.out.println(purchaseList.get(i) + " X " + quanitylist.get(i).getQuatity() + " "
//					+ "$" + quanitylist.get(i).subTotal());
			sum = new BigDecimal(sum + quanitylist.get(i).subTotal())
					.setScale(2, RoundingMode.HALF_UP).doubleValue();

		}

		System.out.println("\n" + "Your total Price is" + " \t$" + sum);

		System.out.println("\n");
		System.out.println("How will you be paying by \n" + "A for Cash \n" + "B for Check\n" + "C for Credit");

		payment = scan.nextLine();
		payment = payment.toUpperCase();
		double amount =sum;
		switch (payment) {

		case "A":
			System.out.println("Enter the amount");
			amount = scan.nextDouble();
			change = new BigDecimal(amount - sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
			System.out.println("Your change is $" + " " + change);
			break;
		case "B":
			Check check;
			long routingNum;
			long accountNum;
			boolean isValidCheck;
			do {
				System.out.println("Please enter routing number");
				routingNum = scan.nextLong();
				System.out.println("Please enter account number");
				accountNum = scan.nextLong();
				check = new Check(routingNum, accountNum);
				isValidCheck = check.checkValid();
				if (!isValidCheck)
					System.out.println("You enter invalid check.");
			} while (!isValidCheck);
			break;
		case "C":
			boolean cardisValid;
			do {
				System.out.println("Please enter card number");
				long cardNum = scan.nextLong();
				CreditCard card = new CreditCard(cardNum);
				cardisValid = card.isValid();
				if (!cardisValid)
					System.out.println("You enter invalid check.");
				
			} while(!cardisValid);
			
		}
		System.out.println("Thank you for Shopping with us heres your reciept");
		System.out.println(displayCart(purchaseList, quanitylist));
		System.out.println();
		System.out.println("You paid " + amount);
		

	}

	private static String displayCart(ArrayList<Product> purchaseList, ArrayList<Transaction> quanitylist) {
		// TODO Auto-generated method stub
		//double sum=0;
//		BigDecimal grandTotal = new BigDecimal("0")
//				.setScale(2, RoundingMode.HALF_UP);
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < purchaseList.size(); i++) {
			output.append(purchaseList.get(i) + " X " + quanitylist.get(i).getQuatity() + " "
					+ "$" + quanitylist.get(i).subTotal()+ "\n");
		//sum = sum + quanitylist.get(i).subTotal();
		
		}
	
		return output.toString();
	}
	
	

}
