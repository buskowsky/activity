package jfonferko.genuitek.activity.controllers;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by JFonferko on 2016-08-29.
 */
@ManagedBean
@Component
@SessionScoped
public class PageController implements Serializable {

	public String moveToActivity() {
		return  "index";
	}

	public String moveToCurrency() {
		return "currency";
	}

	public String moveToUser() {
		return "user";
	}
}
