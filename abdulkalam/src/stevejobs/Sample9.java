package stevejobs;
public class Sample9 
{
	//Data member
	public int x;
	//Constructor method
	private Sample9()
	{
		x=10;
	}
	//Operational methods
	public static Sample9 create()
	{
		Sample9 obj=new Sample9();
		return(obj);
	}
	public void display()
	{
		System.out.println(x);
	}
}







