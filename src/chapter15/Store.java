package chapter15;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Store extends ArrayList<Aisle>{
	private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
	private Office office = new Office();
	public Store(int nAisle, int nShelf, int nProduct) {
		for(int i = 0;i < nAisle;++i) {
			add(new Aisle(nShelf, nProduct));
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Aisle a : this) {
			for(Shelf s : a) {
				for(Product p : s) {
					sb.append(p).append("\n");
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Store(3, 5, 7));
	}
}

class Product {
	
	private static int idCounter = 0;
	private final int id = idCounter++;
	private String descreption;
	private double Price;
	
	public Product(String descreption, double price) {
		super();
		this.descreption = descreption;
		DecimalFormat df = new DecimalFormat("0.00");
		Price = Double.valueOf(df.format(price));
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", descreption=" + descreption + ", Price=" + Price + "]";
	}
	
	public static Generator<Product> generator = new Generator<Product>() {
		
		@Override
		public Product next() {
			// TODO Auto-generated method stub
			return new Product("test", Math.random() * 1000.0);
		}
	};
}

class Shelf extends ArrayList<Product> {
	public Shelf(int nProducts) {
		Generators.fill(this, Product.generator, nProducts);
	}
}

class Aisle extends ArrayList<Shelf>{
	public Aisle(int nShelf, int nProduct) {
		for(int i = 0;i < nShelf;++i) {
			add(new Shelf(nProduct));
		}
	}
}

class CheckoutStand{}
class Office{}
