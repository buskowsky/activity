package jfonferko.genuitek.activity.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jfonferko.genuitek.activity.model.CurrencyTableModel;
import jfonferko.genuitek.activity.service.CurrencyService;

/**
 * Created by JFonferko on 2016-09-02.
 */
@ManagedBean(name = "currencyBackingBean")
@Component
@RequestScoped
public class CurrencyBackingBean {

    @Autowired
    private CurrencyService currencyService;

    private CurrencyTableModel currencyTableModel;

    @PostConstruct
    public void init() {
        setCurrencyTableModel(new CurrencyTableModel(currencyService.findAll()));
    }

    public CurrencyService getCurrencyService() {
        return currencyService;
    }

    public void setCurrencyService(CurrencyService userService) {
        this.currencyService = userService;
    }

    public CurrencyTableModel getcurrencyTableModel() {
        return currencyTableModel;
    }

    public void setCurrencyTableModel(CurrencyTableModel currencyTableModel) {
        this.currencyTableModel = currencyTableModel;
    }
}
