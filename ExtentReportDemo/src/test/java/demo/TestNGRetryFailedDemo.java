package demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {

	@Test
	public void test1() {
		System.err.println("I am inside Test 1 ");
	}
	
	@Test
	public void test2() {
		System.err.println("I am inside Test 2 ");
//		/int i = 1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test3() {
		System.err.println("I am inside Test 3 ");
		Assert.assertTrue(0>1);
		
		
	}
}
