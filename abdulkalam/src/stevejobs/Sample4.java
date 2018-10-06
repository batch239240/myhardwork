package stevejobs;
public class Sample4
{
	//Data members
	public int input1;
	public int input2;
	//Constructor method
	public Sample4(int temp1, int temp2)
	{
		input1=temp1;
		input2=temp2;
	}
	//Operational methods
	public void add1()
	{
		int output=input1+input2;
		System.out.println(output);
	}
	public int add2()
	{
		int output=input1+input2;
		return(output);
	}
}








