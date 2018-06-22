package chapter14;



public class Pet {
	private String name;
	public Pet(String name) {
		this.name = name;
	}
	
	public Pet() {
		name = "default";
	}
	
	public String toString() {
		return name;
	}
}

class Mutt extends Dog{
	public Mutt(String name) { super(name);}
	public Mutt() {super();}
}

class Pug extends Dog{
	public Pug(String name) { super(name);}
	public Pug() {super();}
}

class EgyptianMau extends Cat{
	public EgyptianMau(String name) { super(name);}
	public EgyptianMau() {super();}
}

class Manx extends Cat{
	public Manx(String name) { super(name);}
	public Manx() {super();}
}

class Cymric extends Manx{
	public Cymric(String name) { super(name);}
	public Cymric() {super();}
}

class Rodent extends Pet{
	public Rodent(String name) { super(name);}
	public Rodent() {super();}
}

class Rat extends Rodent{
	public Rat(String name) { super(name);}
	public Rat() {super();}
}

class Mouse extends Rodent{
	public Mouse(String name) { super(name);}
	public Mouse() {super();}
}

class Hamster extends Rodent{
	public Hamster(String name) { super(name);}
	public Hamster() {super();}
}



