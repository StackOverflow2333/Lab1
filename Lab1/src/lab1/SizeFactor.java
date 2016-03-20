package lab1;

public abstract class SizeFactor {

	public static String[] sizeDes = new String[]{
		"small","medium","large","grande"
	};
	public static int sizeIndex = sizeDes.length;
	
	
	double[] sizePrice;
	
	SizeFactor(){
		
		sizePrice = new double[sizeIndex];
		
	}
	
	public double sizeCost(String size) {
	
		for (int i=0;i<sizeIndex;i++){
			if (size.toLowerCase().equals(sizeDes[i])){
				return sizePrice[i];
			}
		}
		System.out.println("Wrong Size Description");
		return 0;
	}
	

}
