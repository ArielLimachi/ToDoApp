package jalasoft.com.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jalasoft.com.utils.Constants;

public class DateValidator implements Validator<CustomDate> {

	SimpleDateFormat simpleDateFormat;

	public DateValidator() {
		simpleDateFormat = new SimpleDateFormat(Constants.CUSTOM_DATE_FORMAT);
	}

	@Override
	public void validate(CustomDate date) {
		try {
			simpleDateFormat.parse(date.toString());
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
	}
}
