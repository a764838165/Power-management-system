package cn.fly.elec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelp {

	public static Date stringConverDate(String textDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = null;
	    try
	    {
	      date = dateFormat.parse(textDate);
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	    return date;
	}

}
