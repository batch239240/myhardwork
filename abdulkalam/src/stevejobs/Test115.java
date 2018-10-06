package stevejobs;
public class Test115
{
	public static void main(String[] args) 
	{
		Myinterface obj1=new Myconcrete();
		int o1=obj1.add(10, 20);
		System.out.println(o1); //30
		Myconcrete obj2=new Myconcrete();
		int o2=obj2.add(10, 20);
		System.out.println(o2); //30
	}
}











