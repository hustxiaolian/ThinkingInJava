package chapter15;

import java.util.Date;

interface TimeStamped {long getTimeStamp(); } 
interface SerialNumbered {long getSearialNumber();}
interface Basic {
	public void set(String val);
	public String get();
}

class TimeStampedImp implements TimeStamped{
	private final long timeStamp;
	public TimeStampedImp() {
		super();
		this.timeStamp = new Date().getTime();
	}
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
}

class SearilNumberedImp implements SerialNumbered{
	private static long idCounter = 1;
	private final long id = idCounter++;
	@Override
	public long getSearialNumber() {
		return id;
	}
}

class BasicImp implements Basic{
	private String val;

	@Override
	public String get() {
		return val;
	}

	@Override
	public void set(String val) {
		this.val = val;
	}
}
public class Mixins extends BasicImp implements TimeStamped, SerialNumbered {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered searialNum = new SearilNumberedImp();
	@Override
	public long getSearialNumber() {
		return searialNum.getSearialNumber();
	}

	@Override
	public long getTimeStamp() {
		return timeStamp.getTimeStamp();
	}
	
}
