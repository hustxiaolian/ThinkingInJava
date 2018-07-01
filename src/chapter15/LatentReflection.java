package chapter15;

import java.lang.reflect.Method;

class Mime{
	public void walkAgainsTheWind() {}
	public void sit() {System.out.println("Pretending to sit");}
	public void pushInvisibleWalls() {}
	public String toString() {return "Mime";}
}

class SmartDog{
	public void speak() {System.out.println("Woof");}
	public void sit() {System.out.println("Sitting");}
	public void reproduce() {}
}

class CommunicationReflectively{
	public static void perform(Object obj) {
		Class<?> sprk = obj.getClass();
		try {
			Method m = sprk.getMethod("speak");
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class LatentReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
