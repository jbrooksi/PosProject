import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister2 {


public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	ProductFile menu = new ProductFile("./StoreItems.txt");
	Transaction tran;
	ArrayList<Product> purchaseList = new ArrayList<Product>();
	ArrayList<Double> quanitylist = new ArrayList<Double>();
	Product p;
	int productNum;
	String again;
	String totalList;
	int quanity;
	
	
	System.out.println("Welcome to the: GET&GO");
	System.out.println("Please enjoy and shop smart" + "\n");
	
	
	menu.printMenu();
	
	do {
		System.out.println("Please Choose number of Product you would like to Purchase");
		productNum = scan.nextInt();
		p = menu.getProduct(productNum);
		purchaseList.add(p);
		System.out.println(p);
		
		System.out.println("How many would you like");
		quanity = scan.nextInt();
		tran = new Transaction(p, quanity);
		quanitylist.add(tran.subTotal());
		
		
		scan.nextLine();
		System.out.println("Would you like to do some more shopping (Yes or No)");
		again = scan.nextLine();
	} while (again.equalsIgnoreCase("yes"));
	
	
		System.out.println("Items in your Shopping cart" + "\n");
	for(int i = 0; i < purchaseList.size(); i++){
		System.out.println (purchaseList.get(i) + " X "+ quanity+ " " + quanitylist.get(i) );
	}
		//for(Product c: purchaseList){
		//	System.out.println(c + " " + quanity + " " + quanitylist);
		//}
	
	
}




}
