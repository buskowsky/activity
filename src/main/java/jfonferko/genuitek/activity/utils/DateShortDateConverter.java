package jfonferko.genuitek.activity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 * Created by JFonferko on 2016-08-24.
 */
@RequestScoped
@FacesConverter("dateShortDateConverter")
public class DateShortDateConverter {

	public static final String REPORT_PARAM_DATE_PATTERN = "yyyy-MM-dd";
	private SimpleDateFormat simpleDateFormat;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		SimpleDateFormat simpleDateFormat;

		simpleDateFormat = new SimpleDateFormat(REPORT_PARAM_DATE_PATTERN);
		Date date = null;
		try {
			date = simpleDateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		simpleDateFormat = format();
		return simpleDateFormat.format(date);
	}

	public SimpleDateFormat format() {
		return new SimpleDateFormat(REPORT_PARAM_DATE_PATTERN);
	}
}
