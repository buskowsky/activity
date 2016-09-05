package jfonferko.genuitek.activity.service;

import jfonferko.genuitek.activity.domain.Currency;
import jfonferko.genuitek.activity.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JFonferko on 2016-09-02.
 */
@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;

	public List<Currency> findAll() {
		return currencyRepository.findAll();
	}
}
