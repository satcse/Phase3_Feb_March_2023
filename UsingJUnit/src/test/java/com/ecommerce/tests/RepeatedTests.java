package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("JUnit 5 Repeated Tests Example")
@RunWith(JUnitPlatform.class)
public class RepeatedTests {

	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before all test methods");
	}
	
	@BeforeEach
	void init()
	{
		System.out.println("init() before a test");
	}
	
	@AfterEach
	void tearDown()
	{
		System.out.println("tearDown() after Test");
	}
	
	@AfterAll
	static void tearDownAll()
	{
		System.out.println("After All test methods");
	}
	
	@Test
	@RepeatedTest(2)
	void addNumber()
	{
		Calculator calculator = new Calculator();
		assertEquals(6,calculator.add(4, 2),"4+2 should equals 6");
		System.out.println("===AddNumber testcase executed===");
	}
}
