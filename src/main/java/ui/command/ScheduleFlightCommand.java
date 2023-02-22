package ui.command;

import java.util.Date;

import flight.reservation.flight.Flight;
import flight.reservation.flight.Schedule;

public class ScheduleFlightCommand implements Command{
	private Flight flight;
	private Date date;

	ScheduleFlightCommand(Flight flight, Date Date) {
        this.flight = flight;
        this.date = date;
	}

	public void exec() {
		Schedule schedule = new Schedule();     // get schedule
        schedule.scheduleFlight(flight, date);
	}
}