package stevejobs;

public class Test116 
{
	public static void main(String[] args) 
	{
		Myabstract obj1=new Mysubconcrete();
		obj1.add(10,20);
		obj1.substract(10,20);
		Mysubconcrete obj2=new Mysubconcrete();
		obj2.add(10, 20);
		obj2.substract(10, 20);
		obj2.multiply(10, 20);
	}
}




