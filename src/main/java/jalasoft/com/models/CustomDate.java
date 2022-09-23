package jalasoft.com.models;

import java.util.Objects;
import jalasoft.com.utils.Constants;

public class CustomDate {
	private int year;
	private int month;
	private int date;
	private Validator dateValidator;

	public CustomDate(int year, int month, int day) {
		super();
		dateValidator = new DateValidator();
		this.year = year;
		this.month = month;
		this.date = day;
		dateValidator.validate(this);
	}

	public Validator getDateValidator() {
		return dateValidator;
	}

	public void setDateValidator(Validator validator) {
		this.dateValidator = validator;
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
		return buildDateAsString();
	}

	public String buildDateAsString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(year);
		buffer.append(Constants.HYPHEN);
		buffer.append(month);
		buffer.append(Constants.HYPHEN);
		buffer.append(date);
		return buffer.toString();
	}
}
