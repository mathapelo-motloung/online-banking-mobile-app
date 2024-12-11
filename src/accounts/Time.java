package accounts;

import java.util.Objects;

public class Time implements Comparable<Time> {
	int hour;
	int minutes;
	
	public Time(int hour, int minutes) {
		super();
		this.hour = hour;
		this.minutes = minutes;
	}
	
	public Time(String time) {
		super();
		time = this.hour + ":"+ this.minutes;
	}
	
	public Time() {
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public int compareTo(Time other) {
		if (this.hour != other.hour) {
            return Integer.compare(this.hour, other.hour);
        }
        return Integer.compare(this.minutes, other.minutes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && minutes == other.minutes;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minutes=" + minutes + "]";
	}
	
}
