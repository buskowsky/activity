package jfonferko.genuitek.activity.controllers;

import jfonferko.genuitek.activity.bean.CurrencyBackingBean;
import jfonferko.genuitek.activity.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by JFonferko on 2016-09-02.
 */
@ManagedBean
@Component
@ViewScoped
public class CurrencyController {

	@Autowired
	private CurrencyBackingBean currencyBackingBean;

	@Autowired
	private CurrencyService currencyService;

}
