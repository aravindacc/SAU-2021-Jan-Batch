package com.assignment.mockitoDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MockitoDemoApplicationTests {
	Items item = new Items();
	Utility util = new Utility();
	
	@Test
	public void testGetExpensiveItem() {
		Items item1 = mock(Items.class);
		int[] price= {100,280,300,215,400};
		when(item1.getMaxPrices()).thenReturn(price);
		int maxe = util.getExpensiveItem(item1);
		assertEquals(400, maxe);
	}
	
	@Test
	public void testGetMostTrending() {
		Utility util = mock(Utility.class);
		int arr[]= {1,5,2,4,3};
		when(util.trendingItem()).thenReturn(arr);
		String str= item.getMostTrending(util);
		assertEquals("Item2",str);
	}
}
