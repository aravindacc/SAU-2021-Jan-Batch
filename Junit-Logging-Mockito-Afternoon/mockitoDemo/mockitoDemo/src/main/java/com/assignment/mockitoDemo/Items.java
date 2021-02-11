package com.assignment.mockitoDemo;

public class Items {
	public Utility util;
	
	public String[] items= {"Item1","Item2","Item3","Item4","Item5"};
	
	public int[] getMaxPrices(){
		int[] price= {100,280,300,215,400};
		return price;
	}
	
	public String getMostTrending(Utility util) {
		int[] famous=util.trendingItem();
		return items[famous[0]];
	}
}
