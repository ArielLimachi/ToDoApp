package jalasoft.com.models;

import java.util.Objects;

public class CustomDate {
	private int year;
	private int month;
	private int date;

	public CustomDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.date = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return date;
	}

	public void setDay(int day) {
		this.date = day;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomDate other = (CustomDate) obj;
		return date == other.date && month == other.month && year == other.year;
	}

	@Override
	public String toString() {
		return " (" + year + "-" + month + "-" + date + ")";
	}

}
