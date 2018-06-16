package chapter9;

import java.util.Random;

import jdk.internal.dynalink.linker.LinkerServices.Implementation;

public class Demo19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onegame(new DiceGameFactory());
	}
	
	public static void onegame(GameServer g) {
		Game geme = g.getGame();
		System.out.println(geme.tossCoin());
	}

}

interface Game{
	int tossCoin();
}

interface GameServer{
	Game getGame();
}

class CoinGame implements Game{
	private Random rand = new Random(47);
	@Override
	public int tossCoin() {
		return rand.nextInt(2);
	}	
}

class CoinGameFactory implements GameServer{

	@Override
	public Game getGame() {
		return new CoinGame();
	}
}

class DiceGame implements Game{
	private Random rand = new Random(58);
	@Override
	public int tossCoin() {
		return rand.nextInt(5) + 1;
	}
}

class DiceGameFactory implements GameServer{

	@Override
	public Game getGame() {
		return new DiceGame();
	}
}