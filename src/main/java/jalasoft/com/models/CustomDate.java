package jalasoft.com.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		validate(this);
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
		return year + "-" + month + "-" + date;
	}

	public void validate(CustomDate date) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			simpleDateFormat.parse(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
