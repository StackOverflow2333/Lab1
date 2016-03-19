package lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}

		double cost = 0;
		
		
		int mode;    //表示输入的模式，0表示旧方式，1表示新方式
		if(Character.isDigit(args[0].charAt(0)))
			mode = 1;
		else
			mode = 0;
		
		
		switch(mode){
			case 0: {  //旧方式
				cost = getCost(disArr);
				break;
			}
			
			case 1: {  //新方式
				String str = "";
				for(int j = 1;j < disArr.length; j++) {
					str += disArr[j]+" ";
				}
				String[] strArr = str.split(" ; ");
				
				if(Integer.parseInt(args[0]) == strArr.length) {
					for(int j = 0;j < strArr.length;j++) {
						if(getCost(strArr[j].split(" ")) == 0)
							return;
						else
							cost += getCost(strArr[j].split(" "));
					}
				}
				else {
					System.out.println("Beverage number is wrong!");
					return;
				}
				break;
			}
			
			
		}
		

		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "
				+ df.format(cost));
	}
	
	
	
	public static double getCost(String[] disArr) {
		
		//判断商品名字为几位
		int i;
		for (i = 0; i < disArr.length; i++)
			if (disArr[i].equals("small") || disArr[i].equals("medium")
					|| disArr[i].equals("large") || disArr[i].equals("grand"))  //增加
				break;

		if (i >= disArr.length) {
			System.out.println("Must set a size!");
			return 0;
		}

		String beveStr;
		if (i == 2) {
			beveStr = disArr[0] + " " + disArr[1];
		} else {
			beveStr = disArr[0];
		}

		
		
		Beverage order;
		if (beveStr.equals("espresso")) {
			order = new CoffeeBeverage();
			order = new Espresso();
			((CoffeeBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("houseblend")) {
			order = new CoffeeBeverage();
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
		} else if (beveStr.equals("decaf mocha")) {			//增加
			order = new Decaf();
			((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Chocolate(order);
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

		
		return order.cost();

	}
	
}
