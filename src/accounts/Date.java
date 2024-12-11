package accounts;

import java.util.Objects;

import accounts.Month;

public class Date implements Comparable<Date>{
	
	int day;
	Month month;
	int year;
	
	public Date() {
		// TODO Auto-generated constructor stub
	}
	
	public Date(String date) {
		// TODO Auto-generated constructor stub
	}
	public Date(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	@Override
	public int compareTo(Date other) {
		int result =0;
	
        if (this.day > other.day) {
            return result=1;
        }
        if (this.day < other.day) {
            return  result= -1;
        }
        if (this.day == other.day) {
            return result;
        }
		return result;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
	


}
