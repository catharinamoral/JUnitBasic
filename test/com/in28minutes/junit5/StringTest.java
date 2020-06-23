package com.in28minutes.junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Initialize connection to database");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Close connection to database");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for " + info.getDisplayName());
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up Test Data for " + info.getDisplayName());
	}

	@Test
	void lenght_basic() {
		int actualLenght = "ABCD".length();
		int expectedLength = 4;
		
		assertEquals(expectedLength, actualLenght);
	}
	
	@Test
	void lenght_greater_than_zero() {
		assertTrue("ABCD".length()>0);
		assertTrue("AB".length()>0);
		assertTrue("A".length()>0);
		assertTrue("DEF".length()>0);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
	void lenght_greater_than_zero_using_parameterized_test(String str) {
		assertTrue(str.length()>0);
	}
	
	@Test
	@DisplayName("When lenght is null, throw an exception")
	void lenght_exception() {
		String str = null;
		
		assertThrows(NullPointerException.class, 
				() -> {
					str.length();
				});
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
