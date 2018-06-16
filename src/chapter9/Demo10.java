package chapter9;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playable[] o = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new WoodWind()
		};
		tuneAll(o);
	}

	public static void tune(Playable i) {
		i.play(Note.HUST);
	}
	
	public static void tuneAll(Playable[] e) {
		for (Playable playable : e) {
			tune(playable);
		}
	}
}
enum Note{
	HUST,SWJTU;
}

interface Instrument{
	int VALUE = 5;//static and final
	void adjust();
}

interface Playable{
	void play(Note n);
}

class Wind implements Instrument, Playable{
	@Override
	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	@Override
	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	@Override
	public String toString() {
		return "Wind";
	}
}

class Percussion implements Instrument, Playable{
	@Override
	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	@Override
	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	@Override
	public String toString() {
		return "Percussion";
	}
}

class Stringed implements Instrument, Playable{
	@Override
	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	@Override
	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	@Override
	public String toString() {
		return "Stringed";
	}
}

class Brass extends Wind{
	@Override
	public String toString() {
		return "Brass";
	}
}

class WoodWind extends Wind{
	@Override
	public String toString() {
		return "WoodWind";
	}
}