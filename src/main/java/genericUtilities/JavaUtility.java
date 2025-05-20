package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consist of reusable method related to java
 * @author Dell
 */

public class JavaUtility 
{
	/**
	 * This Method Will Capture Current Date and Return To Caller
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String currentDate = f.format(d);
		return currentDate;
	}

}
