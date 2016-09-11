package com.wallet.db.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Cengiz on 11.9.2016.
 */
public class PersonCash {
    @DatabaseField(canBeNull = false,generatedId = true, columnName = "ID")
    private Integer id;

    @DatabaseField(canBeNull = true, foreign = true, columnName = "DEPTOR_ID")
    private Person debtor;//borclu

    @DatabaseField(canBeNull = true, foreign = true, columnName = "INDEPTOR_ID")
    private Person indebtor;//borclanan

    @DatabaseField(canBeNull = false, foreign = true, columnName = "CASH_ID")
    private Cash cash;//para giriş çıkışı

    @DatabaseField(canBeNull = false, columnName = "STATUS")
    private Boolean status;//ödeme yapıldımı yapılmadı mı

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getDebtor() {
        return debtor;
    }

    public void setDebtor(Person debtor) {
        this.debtor = debtor;
    }

    public Person getIndebtor() {
        return indebtor;
    }

    public void setIndebtor(Person indebtor) {
        this.indebtor = indebtor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
