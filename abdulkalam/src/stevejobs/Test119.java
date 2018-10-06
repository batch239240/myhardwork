package stevejobs;

public class Test119
{
	public static void main(String[] args) 
	{
		Parent p=new Parent();
		p.x=20;
		p.method1();
		Child c=new Child();
		c.x=20; //Parent property
		c.y=40;
		c.method1(); //Parent method
		c.method2();
	}
}










