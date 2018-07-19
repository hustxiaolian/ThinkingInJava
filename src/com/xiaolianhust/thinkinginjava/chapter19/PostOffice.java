package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.Iterator;

class Mail{
	enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
	enum Scannablility {UNSCANNABLE, YES1, YES2, YES3, YES4}
	enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
	enum Addrress {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
	enum ReturnAddress{MISSING, OK1, OK2, OK3, OK4}
	
	GeneralDelivery g;
	Scannablility s;
	Readability r;
	Addrress a;
	ReturnAddress ra;
	static long counter = 0;
	long id = ++counter;
	
	@Override
	public String toString() {
		return "Mail [g=" + g + ", s=" + s + ", r=" + r + ", a=" + a + ", ra=" + ra + ", id=" + id + "]";
	}
	
	public static Mail randomMail() {
		Mail ret = new Mail();
		
		ret.g = Enums.random(GeneralDelivery.class);
		ret.s = Enums.random(Scannablility.class);
		ret.r = Enums.random(Readability.class);
		ret.a = Enums.random(Addrress.class);
		ret.ra = Enums.random(ReturnAddress.class);
		
		return ret;
	}
	
	public static Iterable<Mail> randomMailGenerator(final int size){
		return new Iterable<Mail>() {
			@Override
			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					private int count = size;
					@Override
					public boolean hasNext() {
						return count-- > 0;
					}
					@Override
					public Mail next() {
						return randomMail();
					}
				};
			}
		};
	}
	
	public static void main(String[] args) {
		for(Mail m : randomMailGenerator(5))
			System.out.println(m);
	}
}


public class PostOffice {
	enum MailHandler{
		GEGERAL_DELIVERY{
			@Override
			boolean handle(Mail m) {
				switch(m.g) {
				case YES:System.out.println("Using general delivery + " + m);return true;
				default: return false;
				}
			}
		},
		MACHIEN_SCAN{
			@Override
			boolean handle(Mail m) {
				switch(m.s) {
				case UNSCANNABLE: return false;
				default:
					switch(m.a) {
					case INCORRECT: return false;
					default:System.out.println("Delivery " + m + "by automatically");return true;
					}
				}
			}
		},
		VISUAL_INSPECTION{
			@Override
			boolean handle(Mail m) {
				switch(m.r) {
				case ILLEGIBLE:return false;
				default:
					switch(m.a) {
					case INCORRECT: return false;
					default:System.out.println("Delivery " + m + "by normally");return true;
					}
				}
			}
		},
		RETURN_TO_SENDER{
			@Override
			boolean handle(Mail m) {
				switch(m.ra) {
				case MISSING:return false;
				default:
					System.out.println("return " + m + "to sender");
					return true;
				}
			}
		}
		;
		abstract boolean handle(Mail m);
	}
	
	public void handle(Mail m) {
		for(MailHandler mh : MailHandler.values()) {
			if(mh.handle(m))
				return;
		}
		System.out.println(m + "is dead mail");
	}
	
	public static void main(String[] args) {
		PostOffice po = new PostOffice();
		for(Mail m : Mail.randomMailGenerator(10))
			po.handle(m);
	}
}
