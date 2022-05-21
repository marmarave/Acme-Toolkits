
package acme.components;

import java.time.Period;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import acme.framework.helpers.MessageHelper;
import acme.framework.helpers.StringHelper;

public class PeriodFormatter implements Formatter<Period> {

	// Formatter<Period> interface ---------------------------------------------

	@Override
	public String print(final Period object, final Locale locale) {
		assert object != null;
		assert locale != null;

		String result;
		String years, months, days;

		years = String.format("%d", object.getYears());
		months = String.format("%d", object.getMonths());
		days = String.format("%d", object.getDays());

		result = String.format("%s Years, %s Months, %s Days", years, months, days);

		return result;
	}

	@Override
	public Period parse(final String text, final Locale locale) throws ParseException {
		assert !StringHelper.isBlank(text);
		assert locale != null;

		final Period result;
		String countryCodeRegex, areaCodeRegex, numberRegex, phoneRegex;
		Pattern pattern;
		Matcher matcher;
		String errorMessage;
		String countryCodeText;
		int countryCode;
		String areaCode, number;

		countryCodeRegex = "\\+\\d{1,3}";
		areaCodeRegex = "\\d{1,6}";
		numberRegex = "\\d{1,9}([\\s-]\\d{1,9}){0,5}";
		phoneRegex = String.format( //
			"^\\s*(?<CC>%1$s)(\\s+\\((?<AC>%2$s)\\)\\s+|\\s+)(?<N>%3$s)\\s*$", //
			countryCodeRegex, //
			areaCodeRegex, //
			numberRegex //
		);

		pattern = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(text);

		if (!matcher.find()) {
			errorMessage = MessageHelper.getMessage("default.error.conversion", null, "Invalid value", locale);
			throw new ParseException(0, errorMessage);
		}
		countryCodeText = matcher.group("CC");
		countryCode = Integer.parseInt(countryCodeText);
		areaCode = matcher.group("AC");
		number = matcher.group("N");

//		result = new Phone();
//		result.setCountryCode(countryCode);
//		result.setAreaCode(areaCode);
//		result.setNumber(number);

//		return result;
		return null;
	}

}
