package chapter14;

public class Position {
	private String title;
	private Person person;
	
	public Position(String title, Person person) {
		super();
		this.title = title;
		this.person = person;
		if(person == null)
			this.person = Person.NULL;
	}

	public Position(String title) {
		super();
		this.title = title;
		this.person = Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		if(person == null)
			this.person = Person.NULL;
	}

	@Override
	public String toString() {
		return "Position [title=" + title + ", person=" + person + "]";
	}
	
	
	
	
	
	
}
