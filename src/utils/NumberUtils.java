package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class NumberUtils {

	private static final String DEFAULT_PATTERN = "##,##0.00";

	private static final DecimalFormat df = new DecimalFormat("", new DecimalFormatSymbols(new Locale("pt", "br")));

	private NumberUtils() {
	}

	public static String format(Number number) {
		return format(DEFAULT_PATTERN, number);
	}

	public static Number parse(String value) throws ParseException {
		return parse(DEFAULT_PATTERN, value);
	}

	public static String format(String pattern, Number number) {
		df.applyPattern(pattern);
		if (number == null) {
			return "";
		}
		if (number instanceof Integer) {
			return df.format(number).replace(",00", "");
		}
		return df.format(number);
	}

	public static Number parse(String pattern, String value) throws ParseException {
		df.applyPattern(pattern);
		return df.parse(value);
	}

	public static List<String> format(String pattern, Collection<? extends Number> lista) {
		List<String> numbers = new ArrayList<String>();
		if (lista != null && !lista.isEmpty()) {
			for (Number number : lista) {
				numbers.add(format(pattern, number));
			}
		}
		return numbers;
	}

	public static List<String> format(Collection<? extends Number> lista) {
		return format(DEFAULT_PATTERN, lista);
	}

	public static <T extends Number> List<T> generate(T number, int start, int end) {
		List<T> lista = new ArrayList<T>();
		for (int i = start; i <= end; i++) {
			lista.add(number);
		}
		return lista;
	}
}
