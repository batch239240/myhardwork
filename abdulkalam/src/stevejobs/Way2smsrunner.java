package stevejobs;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Way2smsrunner
{
	public static void main(String[] args) 
			                         throws Exception
	{
		//Connect to Excel file
		File f=new File("way2smstests.xls");
		//Open excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0); //0 for sheet1(tests)
		int nour1=rsh1.getRows();
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1); //1 for sheet2(steps)
		int nour2=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		//Open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0); //0 for sheet1
		WritableSheet wsh2=wwb.getSheet(1); //1 for sheet2
		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
	    cf.setWrap(true);
		//Set name to result column in sheet2
		Date dt=new Date();  
		SimpleDateFormat df=new SimpleDateFormat(
			    		        "dd-MM-yyyy-hh-mm-ss");  
	    String cname=df.format(dt);
	    //Set name to result column in sheet1
	    Label l1=new Label(nouc1,0,cname,cf);
		wsh1.addCell(l1);
		//Set name to result column in sheet2
		Label l2=new Label(nouc2,0,cname,cf);
		wsh2.addCell(l2);
		//Create object to methods class
		W2smsmethods mco=new W2smsmethods();
		//Collect methods info using methods class object
		Method m[]=mco.getClass().getMethods();
		//Keyword driven 
		try
		{
			//Calling methods one after other
			//1st row(index is 0) have names of cols in Sheet1
			for(int i=1;i<nour1;i++) //from 2nd row(index is 1)
			{
				int flag=0;
				//Get tid and mode from Sheet1
				String tid=rsh1.getCell(0,i).getContents();
				String mode=rsh1.getCell(2,i).getContents();
				if(mode.equalsIgnoreCase("yes"))
				{
					//1st row(index 0) have names of cols in Sheet2
					for(int j=1;j<nour2;j++)
					{
						String sid=rsh2.getCell(0,j).getContents();
						if(tid.equalsIgnoreCase(sid))
						{
							//take step details from sheet2
							String mn=rsh2.getCell(2,j).getContents();
							String e=rsh2.getCell(3,j).getContents();
							String d=rsh2.getCell(4,j).getContents();
							String c=rsh2.getCell(5,j).getContents();
							System.out.println(mn+" "+e+" "+d+" "+c);
							for(int k=0;k<m.length;k++)
							{
								if(m[k].getName().equals(mn))
								{
									String r=(String) m[k].invoke(mco,e,d,c);
									Label lb=new Label(nouc2,j,r,cf);
									wsh2.addCell(lb); //step result
									if(r.equalsIgnoreCase("Unknown browser"))
									{
										wwb.write();
										wwb.close();
										rwb.close();
										System.exit(0); //stop run
									}
									if(r.contains("Failed") || 
										    r.contains("interrupted"))
									{
										flag=1;  
									}	
								}
							}  //for k closing 
						}
					} //for j closing
					if(flag==0)
					{
						Label l=new Label(nouc1,i,"Passed",cf);
						wsh1.addCell(l);
					}
					else
					{
						Label l=new Label(nouc1,i,"Failed",cf);
						wsh1.addCell(l);
					}
				}
			} //for i closing
		} //try block closing
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Save and close excel
		wwb.write();
		wwb.close();
		rwb.close();
	}
}
