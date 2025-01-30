package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {

	// priority
	// invocation count
	// dependsOnmethods
	// enabled
	// dataprovider

	@Test(dataProvider = "getData")
	public void addprodcutTocart(String name,int qty) {

		System.out.println("Phone info is - "+name+" and Qty is - "+qty);// pass
	}

	@DataProvider
	public Object[][] getData()
	{                        //3 rows and 2 columns - 3 data sets which 2 info each
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung";
		data[0][1] = 20;
		
		data[1][0] = "Vivo";
		data[1][1] = 12;
		
		data[2][0] = "Iphone";
		data[2][1] = 30;
		
		return data;
	}
	
	@Test
	public void sample()
	{
		System.out.println("sample");
	}
	

}
