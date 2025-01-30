package practice;

public class GenericMethodPractice {

//	public static void main(String[] args) {//call it multiple times - Caller function
//
//		int sum = add(10,20);
//		System.out.println(sum);
//		
//		System.out.println(add(sum,40));
//		
//		add(30,1000);
//		add(50,89);
//		add(65,80);
//		
//	}

	
	public static int add(int a, int b) {//write method once - Called function - Generic
		
		// Addition
		int c = a + b;
		return c;
	}

}
