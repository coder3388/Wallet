package com.wallet.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Cengiz on 21.8.2016.
 */
@DatabaseTable(tableName = "CURRENCY_UNIT")
public class CurrencyUnit extends Model implements Serializable {
    @DatabaseField(canBeNull = false,generatedId = true,columnName = "ID")
    private Integer id;

    @DatabaseField(canBeNull = false,columnName = "NAME")
    private String name;

    @DatabaseField(canBeNull = true,columnName = "SYMBOL")
    private String symbol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + symbol;
    }
}
