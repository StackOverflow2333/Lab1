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
		int num_of_drink = 1 ;
		
		//判断是不是旧式输入
		if (!Character.isDigit(disArr[0].charAt(0))){
			cost = CalOldInput.oldCal(args);
		}else {
			
			for (int i = 0 ; i < args.length ; i++){
				if (disArr[i].equals(";"))
					num_of_drink++;
			}			
			if (num_of_drink != Integer.valueOf(disArr[0])){
				System.out.println("Illegal input: " + disArr[0]);
				return;
			}
			else {
				ArrayList<Integer> index = new ArrayList<Integer>();//记录数字和分号和末尾的位置
				index.add(0);
				for (int i = 0 ; i < args.length ; i++){
					if (disArr[i].equals(";"))
						index.add(i);
				}
				index.add(disArr.length);
				for (int i = 1 ; i <= num_of_drink ; i++){
					String[] input = new String[index.get(i)-index.get(i-1)-1];
					for (int j = 0 ; j <input.length ; j++){
						input[j] = disArr[index.get(i-1)+1+j];
						//System.out.println(input[j]);
					}
					cost += CalOldInput.oldCal(input);
				}
			}
		}
		
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "
				+ df.format(cost));
	}
	
}