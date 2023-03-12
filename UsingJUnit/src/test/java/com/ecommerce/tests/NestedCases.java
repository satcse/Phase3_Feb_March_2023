package com.ecommerce.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("JUnit 5 Nested Cases Example")
@RunWith(JUnitPlatform.class)
public class NestedCases {


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
	
	@Nested
	@DisplayName("Tests for the Class A")
	class A
	{
		@BeforeEach
		void init()
		{
			System.out.println("init() before a test of A Class");
		}
		
		@AfterEach
		void tearDown()
		{
			/*After Each - Cleanup, Close 
			Test specific variables*/
			System.out.println("tearDown() after Test of A Class");
		}
		
		@Test
		@DisplayName("Example test for Method A")
		void sampleTestForMethodA()
		{
			System.out.println("Example test for method A");
		}
		
		@Nested
		@DisplayName("When X is true here")
		class WhenX
		{
			@BeforeEach
			void init()
			{
				System.out.println("init() before a test of When X Class");
			}
			
			@AfterEach
			void tearDown()
			{
				/*After Each - Cleanup, Close 
				Test specific variables*/
				System.out.println("tearDown() after Test of When X Class");
			}
			
			@Test
			@DisplayName("Example test for Method A")
			void sampleTestForMethodAWhenX()
			{
				System.out.println("Example test for method A When X is true");
			}
		}
	}
}
