package chapter14;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725175037400392374L;

	public void add(String title, Person person) {
		add(new Position(title,person));
	}
	
	public void add(String...titles) {
		for(String oneTitle : titles)
			add(new Position(oneTitle));
	}
	
	public Staff(String...titles) {
		add(titles);
	}
	
	/**
	 * 判断是否有这个职位并且，该职位还有空位
	 * @param title
	 * @return
	 */
	public boolean positionAvaiable(String title) {
		for(Position p : this) {
			if(p.getTitle().equals(title) && p.getPerson() == Person.NULL)
				return true;
		}
		return false;
	}
	
	public void fillPosition(String title, Person hire) {
		for(Position p : this) {
			if(p.getTitle().equals(title) && p.getPerson() == Person.NULL) {
				p.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException("Position:" + title + "not avaibale");
	}
	
	public static void main(String[] args) {
		
	}
}
