package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sample() 
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(1, 1); //fail
		
		System.out.println("Step 4");
		
		Assert.assertTrue(false); //fail
		
		System.out.println("Step 5");
		
		
		
	}

	@Test
	public void sampleSoft() 
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 4");
		
		sa.assertEquals("c", "d");
		
		System.out.println("Step 5");
		
		sa.assertAll();
		
		
		
	}

}
