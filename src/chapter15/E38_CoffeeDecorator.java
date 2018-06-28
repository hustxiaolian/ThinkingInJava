package chapter15;

public class E38_CoffeeDecorator {
	private Coffee coffee;

	public E38_CoffeeDecorator(Coffee coffee) {
		super();
		this.coffee = coffee;
	}
	
	public String getCofferName(){
		return coffee.toString();
	}
	
	public static void main(String[] args) {
		E38_Test.main(args);
	}
}

class E38_CoffeeAddMuikDeorator extends E38_CoffeeDecorator{
	public E38_CoffeeAddMuikDeorator(Coffee coffee) {
		super(coffee);
	}
	
	public void addMuik(Muik muik) {
		System.out.println("向" + this.getCofferName() + "添加" + muik);
	}
}

class E38_CoffeeAddChocolateDecorator extends E38_CoffeeDecorator{

	public E38_CoffeeAddChocolateDecorator(Coffee coffee) {
		super(coffee);
		// TODO Auto-generated constructor stub
	}
	
	public void addChocolate(Chocolate c) {
		System.out.println("向" + this.getCofferName() + "添加" + c);
	}
}
//也就是说装饰器之间还可以通过继承复用部分代，合情合理
class E38_CoffeeAddChocolateAndMuikDecorator extends E38_CoffeeAddMuikDeorator{
	public E38_CoffeeAddChocolateAndMuikDecorator(Coffee coffee) {
		super(coffee);
	}
	public void addChocolate(Chocolate c) {
		System.out.println("向" + this.getCofferName() + "添加" + c);
	}
}

class E38_Test{
	public static void main(String[] args) {
		E38_CoffeeAddMuikDeorator c = new E38_CoffeeAddMuikDeorator(new Coffee());
		c.getCofferName();
		c.addMuik(Muik.PURE_MULK);
		
		E38_CoffeeAddChocolateAndMuikDecorator c2 = new E38_CoffeeAddChocolateAndMuikDecorator(new Coffee());
		c2.addChocolate(Chocolate.BLACK_CHOCOLATE);
		c2.addMuik(Muik.YOGHOURT);
	}
}

enum Muik{
	PURE_MULK, YOGHOURT;
}

enum Chocolate{
	BLACK_CHOCOLATE, WHITE_CHOCOLATE;
}