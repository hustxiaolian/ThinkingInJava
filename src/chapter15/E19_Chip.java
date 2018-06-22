package chapter15;

import java.util.ArrayList;

public class E19_Chip extends ArrayList<Wareroom>{
	private Captain captain = new Captain();
	private ArrayList<ChipCrew> crews = new ArrayList<>();
	
	public E19_Chip(int nWareRoom, int nContainer, int nFreight) {
		for(int i = 0;i < nWareRoom;++i) {
			this.add(new Wareroom(nFreight, nContainer));
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Wareroom w : this) {
			for(Container c : w) {
				for(Freight f : c) {
					sb.append(f).append("\n");
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new E19_Chip(3,5,7));
	}

}
class Captain{}
class ChipCrew{}

class Freight{
	private static int idCounter = 0;
	private final int id = idCounter++;
	private String description;
    private String destination;
    
    Freight(String description, String destination) {
		super();
		this.description = description;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", destination=" + destination + "]";
	}
    
    public static Generator<Freight> generator = new Generator<Freight>() {
		
		@Override
		public Freight next() {
			return new Freight("Test:random product", "hust");
		}
	};
}

class Container extends ArrayList<Freight>{
	public Container(int nFreight) {
		/*
		for(int i = 0;i < nFreight;++i)
			this.add(Freight.generator.next());
		*/
		Generators.fill(this, Freight.generator, nFreight);
	}
}

class Wareroom extends ArrayList<Container> {
	public Wareroom(int nFreight, int nContainer) {
		for(int i = 0;i < nContainer;++i) {
			this.add(new Container(nFreight));
		}
	}
}

