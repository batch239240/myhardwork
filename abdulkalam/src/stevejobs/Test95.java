package stevejobs;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test95
{
	public static void main(String[] args) throws Exception
	{
		//Load "tessdata" folder, which have characters
		File fo=LoadLibs.extractTessResources("tessdata");  
		//Create object to apply OCR on image
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		//Take screenshot file, which have text in content
		File f=new File("toastedmsgss.png"); 
		String result=obj.doOCR(f);
		Thread.sleep(20000);
		System.out.println(result);                             

	}

}


