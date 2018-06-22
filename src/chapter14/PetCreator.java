package chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random rand = new Random();
	/**
	 * ������ʵ�־��岢�ҷ�����Ҫ����������Ķ����������Ϣ
	 * @return
	 */
	public abstract List<Class<? extends Pet>> getType();
	
	public Pet randomPet() {
		int n = rand.nextInt(getType().size());
		try {
			return getType().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pet[] createPetArray(int size) {
		Pet[] ret = new Pet[size];
		for(int i = 0;i < size;i++) {
			ret[i] = randomPet();
		}
		return ret;
	}
	
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> ret = new ArrayList<>();
		Collections.addAll(ret, createPetArray(size));
		return ret;
	}
}
