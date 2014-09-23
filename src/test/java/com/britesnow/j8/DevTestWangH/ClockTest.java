package test.java.com.project.devtest.wangh;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import org.junit.Test;

public class ClockTest {
	
	@Test
	public void mytest(){
		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalTime time = LocalTime.now();
		final LocalDateTime datetime = LocalDateTime.now();
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();

		System.out.println( date );
		System.out.println( time );
		System.out.println( datetime );
		System.out.println( zonedDatetime );

	}

}
