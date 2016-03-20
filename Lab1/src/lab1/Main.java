package lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}
		double cost;
		//choose old or new function
		if (!Character.isDigit(disArr[0].charAt(0))){
			if (oldCal(disArr)!=0)
				cost = oldCal(disArr);
			else
				return;
		}else {
			if (newCal(disArr)!=0)
				cost = newCal(disArr);
			else
				return;
		}
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "+df.format(cost));
		
	}

	public static double newCal(String[] args) {
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}
		double cost = 0;
		int num_of_drink = 1;
		//compare the number of ; and the first number
		for (int i = 0; i < args.length; i++) {
			if (disArr[i].equals(";"))
				num_of_drink++;
		}
		if (num_of_drink != Integer.valueOf(disArr[0])) {
			System.out.println("Illegal input: " + disArr[0]);
			return 0;
		} else {
			ArrayList<Integer> index = new ArrayList<Integer>();// remark the
																// location of
																// the
																// number,the ;
																// and the end
			index.add(0);
			for (int i = 0; i < args.length; i++) {
				if (disArr[i].equals(";"))
					index.add(i);
			}
			index.add(disArr.length);
			for (int i = 1; i <= num_of_drink; i++) {
				String[] input = new String[index.get(i) - index.get(i - 1) - 1];
				for (int j = 0; j < input.length; j++) {
					input[j] = disArr[index.get(i - 1) + 1 + j];
					//System.out.println(input[j]);
				}
				if (oldCal(input) != 0)
					cost += oldCal(input);
				else
					return 0;
			}
		}
		DecimalFormat df = new DecimalFormat(".0");
		return Double.valueOf(df.format(cost));
		//System.out.println("The total cost of your order is: "
		//		+ df.format(cost));
	}

	public static double oldCal(String[] args) {
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}

		String beveStr;
		Beverage order ;

		// judge the size
		int i;
		i_break: for (i = 0; i < disArr.length; i++) {

			for (int j = 0; j < SizeFactor.sizeIndex; j++) {
				if (disArr[i].equals(SizeFactor.sizeDes[j])) {
					break i_break;
				}
			}
		}

		if (i >= disArr.length) {
			System.out.println("Must set a size!");
			return 0;
		}

		if (i == 2) {
			beveStr = disArr[0] + " " + disArr[1];
		} else {
			beveStr = disArr[0];
		}

		if (beveStr.equals("espresso")) {
			// order = new CoffeeBeverage();
			order = new Espresso();
			//((CoffeeBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("houseblend")) {
			// order = new CoffeeBeverage();
			order = new HouseBlend();
			//((CoffeeBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("mocha")) {
			order = new Espresso();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Chocolate(order);
		} else if (beveStr.equals("latte")) {
			order = new Espresso();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Milk(order);
		} else if (beveStr.equals("cappuccino")) {
			order = new Espresso();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new WhipCream(order);
		} else if (beveStr.equals("decaf mocha")) { // new add
			order = new Decaf();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Chocolate(order);
		} else if (beveStr.equals("decaf latte")) { // new add
			order = new Decaf();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Milk(order);
		} else if (beveStr.equals("decaf cappuccino")) { // new add
			order = new Decaf();
			//((CoffeeBeverage) order).setSize(disArr[i]);
			order = new WhipCream(order);
		} else if (beveStr.equals("green tea")) {
			order = new GreenTea();
			//((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("red tea")) {
			order = new RedTea();
			//((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("white tea")) {
			order = new WhiteTea();
			//((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("flower tea")) {
			order = new GreenTea();
			//((TeaBeverage) order).setSize(disArr[i]);
			order = new Jasmine(order);
		} else if (beveStr.equals("ginger tea")) {
			order = new GreenTea();
			//((TeaBeverage) order).setSize(disArr[i]);
			order = new Ginger(order);
		} else if (beveStr.equals("tea latte")) {
			order = new RedTea();
			//((TeaBeverage) order).setSize(disArr[i]);
			order = new Milk(order);
		} else {
			System.out.println("Illegal input: " + beveStr);
			return 0;
		}
		order.setSize(disArr[i]);
		for (i++; i < disArr.length; i++) {
			if (disArr[i].equals("chocolate")) {
				order = new Chocolate(order);
			} else if (disArr[i].equals("ginger")) {
				order = new Ginger(order);
			} else if (disArr[i].equals("milk")) {
				order = new Milk(order);
			} else if (disArr[i].equals("jasmine")) {
				order = new Jasmine(order);
			} else if (disArr[i].equals("whip")) {
				i++;
				order = new WhipCream(order);
			} else {
				System.out.println("Illegal input: " + disArr[i]);
				return 0;
			}
		}

		/**
		 * How do I get the description of each order instead of doing this
		 * stupid thing forever (except for printing the args)?
		 */
		/*
		 * if (order instanceof BeverageWithIngredient) {
		 * ((BeverageWithIngredient) order).getDescription(); } else if (order
		 * instanceof Espresso) { ((Espresso) order).getDescription(); }
		 */
		// and so on...

		order.getDescription();

		DecimalFormat df = new DecimalFormat(".0");
		// System.out.println("The total cost of your order is: "
		// + df.format(order.cost()));
		return Double.valueOf(df.format(order.cost()));
	}
}