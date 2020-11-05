package com.miscellaneous;

public class StockBuySell {

	public static void main(String[] args) {
//		int[] prices = {1,2,5,7,3,9,43,6};
//		int []prices = {100, 180, 260, 310, 40, 535, 695};
		int[] prices = {2,4,7,5,4,3,5};
		stockBuySell(prices);
	}
	
	private static void stockBuySell(int[] prices) {
		if(prices.length <=1)
			return;
		
		for(int i = 0; i < prices.length;) {
			int j = i;
			
			while(j < prices.length - 1 && prices[j+1] >= prices[j])
				j++;
			
			if(j > i) {
				System.out.println("Buy : "+(i)+" and Sell :"+(j));
			}
			
			i = j+1; 
		}
	}

}
