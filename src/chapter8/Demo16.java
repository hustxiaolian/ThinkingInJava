package chapter8;

import chapter8.AlertStatus.Status;

public class Demo16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StarShip().changeStatus(Status.MOVING);
		
	}
	
	
}

class StarShip{
	private AlertStatus status;
	public void changeStatus(AlertStatus.Status s) {
		status.changeStatus(s);
	}
}

class AlertStatus{
	private Status status = Status.STOP;
	public static enum Status{
		STOP, MOVING, PAUSE;
	}
	
	public void changeStatus(Status s) {
		status = s;
	}
	
}