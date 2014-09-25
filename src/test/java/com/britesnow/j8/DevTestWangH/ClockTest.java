package test.java.com.project.devtest.wangh;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

public class ClockTest {
	
	@Test
	public void mytest(){
		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalTime time = LocalTime.now();
		final LocalDateTime datetime = LocalDateTime.now();
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final Year year = Year.now();
		
		System.out.println( date );
		System.out.println( time );
		System.out.println( datetime );
		System.out.println( zonedDatetime );
		System.out.println( year );
		
		System.out.println("---of Test:");
		System.out.println(LocalDate.of(2012, Month.DECEMBER, 12));
		System.out.println(LocalDate.ofEpochDay(150));
		System.out.println(LocalTime.of(17, 18));
		
		System.out.println("---parse Test:");
		System.out.println(LocalTime.parse("10:15:30"));
		
		
		System.out.println("---at Test:");
		LocalDateTime datetime2 = date.atTime(time);
		System.out.println( datetime2 );

		System.out.println("---isLeapYear Test:");
		System.out.println("isLeapYear :" + date.isLeapYear());

		System.out.println("---format Test:");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu MM dd");
		System.out.println( dateTimeFormatter.format(date));
		
		System.out.println("---from Test:");
		TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2013 01 15");
		System.out.println("temporalAccessor :" + LocalDate.from(temporalAccessor));


	}

}
