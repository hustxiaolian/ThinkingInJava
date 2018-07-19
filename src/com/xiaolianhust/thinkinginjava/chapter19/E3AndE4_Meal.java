package com.xiaolianhust.thinkinginjava.chapter19;

public enum E3AndE4_Meal {
	MAINCOURSE(Food.MainCourse.class),
	VEGETABLE(Food.Vegetable.class),
	DRINKS(Food.Drink.class);
	
	private Food[] values;
	private E3AndE4_Meal(Class<? extends Food> cls) {
		values = cls.getEnumConstants();
	}
	public interface Food{
		public enum MainCourse implements Food{//这里必须要让这个enum实现Food接口，这样才能保证它还是个“Food”
			MI_FAN, RE_GAN_MIAN, DAN_DAN_MIAN;
		}
		public enum Vegetable implements Food{
			QING_CAI, BAI_CAI, HUA_CAI, HONG_LUOBO;
		}
		public enum Drink implements Food{
			NING_MENG_SHUI, RED_TEA;
		}
	}
	
	public Food randSelection() {
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		E3AndE4_Meal m = E3AndE4_Meal.MAINCOURSE;
		System.out.println(m.randSelection());
	}
}
