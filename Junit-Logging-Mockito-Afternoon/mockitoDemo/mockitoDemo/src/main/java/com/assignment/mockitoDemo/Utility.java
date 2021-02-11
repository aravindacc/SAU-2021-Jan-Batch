package com.assignment.mockitoDemo;

import java.util.Arrays;

public class Utility {
	public Items item;
	
	public int getExpensiveItem(Items item) {
		int[] maximum=item.getMaxPrices();
		return Arrays.stream(maximum).max().getAsInt();
	}
	
	public int[] trendingItem() {
		int[] arr= {1,5,2,4,3};
		return arr;
	}
}

