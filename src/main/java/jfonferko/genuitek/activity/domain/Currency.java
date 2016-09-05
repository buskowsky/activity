package jfonferko.genuitek.activity.domain;

/**
 * Created by JFonferko on 2016-09-02.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "currency")
@XmlRootElement
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "name")
    private String name;

    @Column(name = "usercurrency")
    private Long usercurrency;

    @Column(name = "mon")
    private String mon;

    public Currency() {
    }

    public Currency(String name, Long usercurrency, String mon) {
        this.name = name;
        this.usercurrency = usercurrency;
        this.mon = mon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUsercurrency() {
        return usercurrency;
    }

    public void setUsercurrency(Long usercurrency) {
        this.usercurrency = usercurrency;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Currency currency = (Currency) o;

        return id == currency.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

