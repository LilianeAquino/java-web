package br.com.liliane.calendario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarFormat {
	
	public String formatCalendar(Calendar calendar){
		Date time = calendar.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(time);
	}

}
