package com.ecommerce.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("JUnit 5 Standard Test Class Example")
@RunWith(JUnitPlatform.class)
public class StandardTestClass {
	
	@BeforeAll
	static void initAll()
	{
		/*Before All - Initialization of Projects, 
		setting up of environment variables, 
		Database connections, Cache connections.*/
		System.out.println("initAll()"); 
	}
	

	@BeforeEach
	void init()
	{
		/*Before Each - Setup / create /initialize 
		Test specific variables*/
		System.out.println("init() before a test");
	}

	@Test
	void succeedingTest()
	{
		System.out.println("succeedingTest()");
	}
	
	@AfterEach
	void tearDown()
	{
		/*After Each - Cleanup, Close 
		Test specific variables*/
		System.out.println("tearDown() after Test");
	}
	
	@AfterAll
	static void tearDownAll()
	{
		/*After All - Cleanup of Projects, clear memory, 
		Close Database connections, Clear Cache connections.*/
		System.out.println("tearDownAll();");
	}
}
