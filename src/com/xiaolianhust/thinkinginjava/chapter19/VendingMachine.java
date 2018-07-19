package com.xiaolianhust.thinkinginjava.chapter19;

import static com.xiaolianhust.thinkinginjava.chapter19.Input.*;

import java.util.EnumMap;
import java.util.Iterator;

import com.xiaolianhust.thinkinginjava.chapter18.TextFile;

import chapter15.Generator;

enum Category{
	MONEY(NICKEL, DIME, QUARTER, DOLLER),
	ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
	SHUT_DOWN(STOP)
	;
	private Input[] values;
	private Category(Input... values) {
		this.values = values;
	}
	
	private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);
	static {
		for(Category c: Category.class.getEnumConstants()) {
			for(Input type : c.values) {
				categories.put(type, c);
			}
		}
	}
	
	public static Category categorize(Input input) {
		return categories.get(input);
	}
}

class RandomInputGenerator implements Generator<Input>{
	@Override
	public Input next() {
		return Input.randomSelection();
	}
}

class FileInputGenerator implements Generator<Input>{
	private Iterator<String> input;
	
	public FileInputGenerator(String fileName) {
		input = new TextFile(fileName).iterator();
	}
	
	@Override
	public Input next() {
		if(!input.hasNext()) {
			return null;
		}
		return Enum.valueOf(Input.class, input.next().trim());//这里去点头尾可能的空格
	}
}

public class VendingMachine {
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Input selection = null;

	enum StateDuration { TRANSIENT }
	
	enum State{
		RESTING{
			@Override
			void next(Input input) {
				switch(Category.categorize(input)) {
				case MONEY:
					amount += input.amount();
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		ADDING_MONEY{
			@Override
			void next(Input input) {
				switch(Category.categorize(input)) {
				case MONEY:
					amount += input.amount();
					break;
				case ITEM_SELECTION:
					selection = input;
					if(amount < selection.amount()) {
						System.out.println("金钱不足");
					}
					else {
						state = DISPENSING;
					}
				case QUIT_TRANSACTION:
					state = State.GIVING_CHANGE;break;
				case SHUT_DOWN:
					state = State.TERMINAL;
				default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT){
			@Override
			void next() {
				System.out.println("here is your" + selection);
				amount -= selection.amount();
				state = State.GIVING_CHANGE;
			}
		},
		GIVING_CHANGE(StateDuration.TRANSIENT){
			@Override
			void next() {
				if(amount > 0) {
					System.out.println("Your change:" + amount);
					amount = 0;
				}
				state = RESTING;
			}
		},
		TERMINAL{
			@Override
			void output() {
				System.out.println("Halted");
			}
		}
		;
		private boolean isTransient = false;
		State() {}
		State(StateDuration stateDuration) { isTransient = true;}
		void next(Input input) {
			throw new RuntimeException("error 3");
		}
		
		void next() {
			throw new RuntimeException("error 4");
		}
		
		void output() {
			System.out.println(amount);
		}
	}
	
	public static void run(Generator<Input> gen) {
		while(state != State.TERMINAL) {
			state.next(gen.next());
			while(state.isTransient)
				state.next();
			state.output();
		}
	}
	
	public static void main(String[] args) {
		run(new RandomInputGenerator());
	}
}
