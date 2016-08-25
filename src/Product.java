
public class Product {
	private int id; 
	private String name;
	private String category;
	private String description; 
	private double price;
	
		
	

	public Product(int id, String name, String category, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	
	public Product(String id, String name, String category, String description, String price) {
		super();
		this.id = Integer.parseInt(id);
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = Double.parseDouble(price); // I have question for that 
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		
		return String.format("%2d %20S         %10S     %21S     $%1.2f", id, name, category, description, price); 
	}

	

}
