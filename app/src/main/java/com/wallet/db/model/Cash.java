package com.wallet.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cengiz on 21.8.2016.
 */
@DatabaseTable(tableName = "CASH")
public class Cash extends Model implements Serializable {
    @DatabaseField(canBeNull = false,generatedId = true, columnName = "ID")
    private Integer id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = "CURRENCY_ID")
    private CurrencyUnit currency;//para birimi

    @DatabaseField(canBeNull = false, columnName = "TOTAL")
    private Integer total;//tutar

    @DatabaseField(canBeNull = false, columnName = "IN_OR_OUT")
    private Boolean inOrOut;//giriş çıkış

    @DatabaseField(canBeNull = false, columnName = "REPETITIVE")//tekrarlı yada tekrarsız
    private Boolean repetitive;

    @DatabaseField(canBeNull = true,columnName = "REPETITIVE_OF_DAYS")
    private Integer repetitiveOfDays;//kaç günde bir tekrar edecek

    @DatabaseField(canBeNull = true,columnName = "REPETITIVE_COUNT")
    private Integer repetitiveCount;//tutarın tekrar etme sayısı. Eğer tutar sürekli tekrar edecekse -1 verilir bu alanın değeri

    @DatabaseField(canBeNull = false,columnName = "INSERT_DATE")
    private Date insertDate;

    public CurrencyUnit getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyUnit currency) {
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(Boolean inOrOut) {
        this.inOrOut = inOrOut;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Boolean getRepetitive() {
        return repetitive;
    }

    public void setRepetitive(Boolean repetitive) {
        this.repetitive = repetitive;
    }

    public Integer getRepetitiveCount() {
        return repetitiveCount;
    }

    public void setRepetitiveCount(Integer repetitiveCount) {
        this.repetitiveCount = repetitiveCount;
    }

    public Integer getRepetitiveOfDays() {
        return repetitiveOfDays;
    }

    public void setRepetitiveOfDays(Integer repetitiveOfDays) {
        this.repetitiveOfDays = repetitiveOfDays;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "";
    }
}
