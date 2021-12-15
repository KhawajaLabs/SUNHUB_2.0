package TestPackage;

import java.io.File;
import java.util.Properties;

import com.sunhub.qa.base.BaseClass;

public class TestClassPage 
{

	public void fileCount()
	{
		File directory=new File("./AutoIT/Document Uploading");
	    int fileCount=directory.list().length;
	    System.out.println("File Count: "+fileCount);
	}

}
