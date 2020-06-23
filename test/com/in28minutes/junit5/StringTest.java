package com.in28minutes.junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void lenght_basic() {
		int actualLenght = "ABCD".length();
		int expectedLength = 4;
		
		assertEquals(expectedLength, actualLenght);
	}
	
	@Test
	void toUpperCase() {
		String str = "abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
		assertNotNull(result);
	}

	@Test
	void contains_basic() {
		//assertEquals(false, result);
		assertFalse("abcdefgh".contains("ijk"));
	}
	
	@Test
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[] = str.split(" ");
		String[] expected = new String[] {"abc", "def", "ghi"};
		
		assertArrayEquals(expected, actualResult);
	}
	
}
