package jfonferko.genuitek.activity.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import jfonferko.genuitek.activity.domain.Currency;

/**
 * Created by JFonferko on 2016-09-02.
 */
public class CurrencyTableModel extends ListDataModel<Currency>
		implements SelectableDataModel<Currency> {

	public CurrencyTableModel(List<Currency> list) {
		super(list);
	}

	@Override
	public Object getRowKey(Currency object) {
		return null;
	}

	@Override
	public Currency getRowData(String s) {
		List<Currency> currencies = (List<Currency>) getWrappedData();

		for (Currency currency : currencies) {
			if (currency.getId() == new Long(s))
				return currency;
		}
		return null;
	}
}
