package lab1;

import java.text.DecimalFormat;

public class CalOldInput {
	
	public static double oldCal(String[] args) {
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}
		
		String beveStr;
		Beverage order = new Beverage();

			//鍒ゆ柇鍟嗗搧鍚嶅瓧涓哄嚑浣�
			int i;
			i_break:
			for (i = 0; i < disArr.length; i++){

				for (int j=0;j<SizeFactor.sizeIndex;j++){
					if (disArr[i].equals(SizeFactor.sizeDes[j])){
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
				//order = new CoffeeBeverage();
				order = new Espresso();
				((CoffeeBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("houseblend")) {
				//order = new CoffeeBeverage();
				order = new HouseBlend();
				((CoffeeBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("mocha")) {
				order = new Espresso();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Chocolate(order);
			} else if (beveStr.equals("latte")) {
				order = new Espresso();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Milk(order);
			} else if (beveStr.equals("cappuccino")) {
				order = new Espresso();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new WhipCream(order);
			} else if (beveStr.equals("decaf mocha")) {			//澧炲姞
				order = new Decaf();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Chocolate(order);
			} else if (beveStr.equals("decaf latte")) {			//澧炲姞
				order = new Decaf();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Milk(order);
			} else if (beveStr.equals("decaf cappuccino")) {	//澧炲姞
				order = new Decaf();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new WhipCream(order);
			} else if (beveStr.equals("green tea")) {
				order = new GreenTea();
				((TeaBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("red tea")) {
				order = new RedTea();
				((TeaBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("white tea")) {
				order = new WhiteTea();
				((TeaBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("flower tea")) {
				order = new GreenTea();
				((TeaBeverage) order).setSize(disArr[i]);
				order = new Jasmine(order);
			} else if (beveStr.equals("ginger tea")) {
				order = new GreenTea();
				((TeaBeverage) order).setSize(disArr[i]);
				order = new Ginger(order);
			} else if (beveStr.equals("tea latte")) {
				order = new RedTea();
				((TeaBeverage) order).setSize(disArr[i]);
				order = new Milk(order);
			} else {
				System.out.println("Illegal input: " + beveStr);
				return 0;
			}

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
		if (order instanceof BeverageWithIngredient) {
			((BeverageWithIngredient) order).getDescription();
		} else if (order instanceof Espresso) {
			((Espresso) order).getDescription();
		}
		// and so on...
		
		

		DecimalFormat df = new DecimalFormat(".0");
		// System.out.println("The total cost of your order is: "
		//		+ df.format(order.cost()));
		return Double.valueOf(df.format(order.cost()));
	}
}
