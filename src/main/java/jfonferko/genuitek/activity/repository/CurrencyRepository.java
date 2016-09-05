package jfonferko.genuitek.activity.repository;

import jfonferko.genuitek.activity.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JFonferko on 2016-09-02.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{

}
