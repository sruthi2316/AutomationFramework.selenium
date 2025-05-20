package practice;

public class GenericMethodPractice 
{

	public static void main(String[] args) 
	{
		System.out.println("Addition");
	   add(2,5);
	   int sum=add(20,30);
	   System.out.println(sum);
	   System.out.println(add(sum,30));
	   System.out.println("Subtraction");
	   int s=sub(40,20);
	   System.out.println(s);
	   System.out.println(sub(60,s));
	   System.out.println("Multiplication");
	   int p=mul(6,8);
	   System.out.println(p);
	   System.out.println(mul(p,3));
	   
	 }
	
	public static int add(int a, int b)
	{
		int c= a+b;
		return c;
	}
	
	public static int sub(int x, int y)
	{
		int z=x-y;
		return z;
	}
	
	public static int mul(int m, int n)
	{
		int k=m*n;
		return k;
	}

}
