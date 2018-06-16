package chapter13;

import java.util.Formatter;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Receipt{
	public static final int ITEM_WIDTH = 15;
	public static final int QTY_WIDTH = 5;
	public static final int PRICE_WIDTH = 10;
	public static final String TITLE_FRMT = 
			"%-" + ITEM_WIDTH + "s %" + QTY_WIDTH + "s %" + PRICE_WIDTH + "S \n";
	public static final String ITEM_FRMT =
			"%-" + ITEM_WIDTH + "." + ITEM_WIDTH + "s %" + QTY_WIDTH + "d %" + PRICE_WIDTH + "." + ".2f\n";
	public static final String TOTAL_FRMT = 
			"%-" + ITEM_WIDTH + "s %" + QTY_WIDTH + "s %" + PRICE_WIDTH + ".2f\n";
	private double total = 0;
	private Formatter f = new Formatter(System.out);//Formatter类对象接受输出流对象来构造
	public void printTitle(int n) {
		f.format(TITLE_FRMT, "Item", "Qty", "Price");
		f.format(TITLE_FRMT, "----","---","-----");
	}
	
	public void printItem(String name, int qty, double price) {
		f.format(ITEM_FRMT, name, qty, price);
		total += price;
	}
	
	public void printTotal() {
		f.format(TOTAL_FRMT, "Tax","", total * 0.06);
		f.format(TITLE_FRMT, "","", "-----");
		f.format(TOTAL_FRMT, "Total", "", total * 1.06);
	}
	
	public static void main(String[] args) {
		
	}
}
