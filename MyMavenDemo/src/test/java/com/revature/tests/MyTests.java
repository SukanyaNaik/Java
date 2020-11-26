package com.revature.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.app.Driver;

public class MyTests {
	
	@Test
	public void testAdder() {
		// We want to assure that 2 + 2 = 4 by using the adder method
		assertEquals(4, Driver.adder(2, 2)); // this is what's called an assertion
		assertEquals(100, Driver.subtractor(400,300));
	}
	
	@Test
	public void testSubtractor() {
		// We want to assure that 2 + 2 = 4 by using the adder method
		assertEquals(100, Driver.subtractor(400,300));
	}
}
