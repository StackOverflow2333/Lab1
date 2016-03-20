package lab1;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args){
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}

		double cost = 0;
		
		int mode;    //表示输入的模式，0表示旧方式，1表示新方式，可以拓展新的方式
		if(Character.isDigit(args[0].charAt(0)))
			mode = 1;
		else
			mode = 0;
		
		//根据 mode选择不同的计算价格方式
		switch(mode){
		
			case 0: {  //旧方式
				cost = getCostOfOneDrink(disArr);
				break;

			}

			case 1: {  //新方式
				cost = getCostOfSeveralDrink(disArr);
				break;

			}
				
		}
		
		if(cost == 0)
			return;
		
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "
				+ df.format(cost));
	}
	
	


	//计算一杯饮料价格，参数为旧方式的参数  ：<beverage name>  <size>  [<ingredient 1, ingredient 2, ingredient 3>] ，返回double。
	public static double getCostOfOneDrink(String[] disArr) {
		//判断商品名字为几位
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
				//((CoffeeBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("houseblend")) {
				//order = new CoffeeBeverage();
				order = new HouseBlend();
				//((CoffeeBeverage) order).setSize(disArr[i]);
			} else if (beveStr.equals("mocha")) {
				order = new Espresso();
				((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Chocolate(order);
			} else if (beveStr.equals("latte")) {
				order = new Espresso();
				//((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Milk(order);
			} else if (beveStr.equals("cappuccino")) {
				order = new Espresso();
				//((CoffeeBeverage) order).setSize(disArr[i]);
				order = new WhipCream(order);
			} else if (beveStr.equals("decaf mocha")) {			//澧炲姞
				order = new Decaf();
				//((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Chocolate(order);
			} else if (beveStr.equals("decaf latte")) {			//澧炲姞
				order = new Decaf();
				//((CoffeeBeverage) order).setSize(disArr[i]);
				order = new Milk(order);
			} else if (beveStr.equals("decaf cappuccino")) {	//澧炲姞
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
		if (order instanceof BeverageWithIngredient) {
			((BeverageWithIngredient) order).getDescription();
		} else if (order instanceof Espresso) {
			((Espresso) order).getDescription();
		}
		// and so on...
		return order.cost();

	}
	
	
	//新方式的价格计算，调用了getCostOfOneDrink()
	public static double getCostOfSeveralDrink(String[] disArr) {
		String str = "";
		double cost = 0;
		for(int j = 1;j < disArr.length; j++) 
			str += disArr[j]+" ";
		String[] strArr = str.split(" ; ");
		if(Integer.parseInt(disArr[0]) == strArr.length) 
			for(int j = 0;j < strArr.length;j++) {
				double cost1 = getCostOfOneDrink(strArr[j].split(" "));
				if(cost1 == 0)
					return 0;
				else
					cost += cost1;
			}
		else {
			System.out.println("Beverage number is wrong!");
			return 0;
		}
		return cost;
	}
}

