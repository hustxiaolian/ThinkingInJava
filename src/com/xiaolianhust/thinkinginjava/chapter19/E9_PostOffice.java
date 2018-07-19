package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.EnumMap;

public class E9_PostOffice {
	public interface MailHandleStrategy{
		boolean handle(Mail m);
	}
	
	enum MailHandleStragyEnum{ GENERAL_DELIVERY, MACHINE_SCAE, VISUAL_INSPECTION, RETURN_TO_SENDER }
	
	EnumMap<MailHandleStragyEnum, MailHandleStrategy> map = new EnumMap<>(MailHandleStragyEnum.class);
	//构造时，添加进来
	E9_PostOffice() {
		super();
		map.put(MailHandleStragyEnum.GENERAL_DELIVERY, new MailHandleStrategy() {
			@Override
			public boolean handle(Mail m) {
				switch(m.g) {
				case YES:System.out.println("Using general delivery + " + m);return true;
				default: return false;
				}
			}
		});
		map.put(MailHandleStragyEnum.MACHINE_SCAE, new MailHandleStrategy() {
			@Override
			public boolean handle(Mail m) {
				switch(m.s) {
				case UNSCANNABLE: return false;
				default:
					switch(m.a) {
					case INCORRECT: return false;
					default:System.out.println("Delivery " + m + "by automatically");return true;
					}
				}
			}
		});
		//后面的两个命令类似的添加即可
	}
	
	public void handle(Mail m) {
		for(MailHandleStragyEnum mhse : MailHandleStragyEnum.values())
			map.get(mhse).handle(m);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
