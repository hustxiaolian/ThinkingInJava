package chapter17;

import java.lang.reflect.Constructor;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class GroundDog {
	protected int num;
	
	public GroundDog(int num) {
		super();
		this.num = num;
	}

	@Override
	public String toString() {
		return "GroundDog [num=" + num + "]";
	}
	
	public static void main(String[] args) {
		try {
			SpringDetector.detectSpring(GroundDog.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		/*
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroundDog other = (GroundDog) obj;
		if (num != other.num)
			return false;
		return true;
		*/
		return obj instanceof GroundDog; //&& (num == (GroundDog)obj.num);
	}
	
	
	
}

class Prediction {
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;
	
	public String toString() {
		if(shadow)
			return "Six more week of winter";
		else
			return "Early Spring";
	}
}

class SpringDetector{
	public static <T extends GroundDog> void detectSpring(Class<T> type) throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<GroundDog, Prediction> map = new HashMap<>();
		for(int i = 0;i < 10;++i)
			map.put(ghog.newInstance(i), new Prediction());
		System.out.println(map);
		GroundDog gh = new GroundDog(3);
		if(map.containsKey(gh)) {
			System.out.println(map.get(gh));
		}
		else
			System.out.println("no found:" + gh);
	}
}
