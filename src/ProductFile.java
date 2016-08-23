import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductFile {

	
	private Path productsPath;
	private File productsFile;
	private ArrayList<Product> productList = new ArrayList<Product>();

	public ProductFile(String path) {
		super();
		productsPath = Paths.get(path);
		productsFile = productsPath.toFile();
		readInFile(productsFile);
	}

	private void readInFile(File productsFile) {
		try {
			FileReader fileRdr = new FileReader(productsFile);
			BufferedReader in = new BufferedReader(fileRdr);
			String line = in.readLine();
			while (line != null) {
				String[] details = line.split("\t");
				Product temp = new Product(details[0], details[1], details[2], details[3], details[4]);
				productList.add(temp);
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void printMenu(){
		for (Product p : productList) {
			System.out.println(p);
		}
	}
}
