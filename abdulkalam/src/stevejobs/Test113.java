package stevejobs;

public class Test113
{
	public static void main(String[] args)
	{
		Sample7 obj1=new Sample7();
		Sample7 obj2=new Sample7();
		Sample7.x=100;
		obj1.y=200;
		obj2.y=300;
		System.out.println(Sample7.x+" "+obj1.y);
		System.out.println(Sample7.x+" "+obj2.y);
	}
}



