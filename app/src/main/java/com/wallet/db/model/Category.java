package com.wallet.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Cengiz on 21.8.2016.
 */
@DatabaseTable(tableName = "CASH_CATEGORY")
public class Category extends Model implements Serializable {
    @DatabaseField(canBeNull = false,generatedId = true,columnName = "ID")
    private Integer id;

    @DatabaseField(canBeNull = false,columnName = "NAME")
    private String name;

    @DatabaseField(canBeNull = false,columnName = "ACTIVE")
    private Boolean active;

    @DatabaseField(canBeNull = false, foreign = true, columnName = "GROUP_ID")
    private Category group;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getGroup() {
        return group;
    }

    public void setGroup(Category group) {
        this.group = group;
    }

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

    @Override
    public String toString() {
        return id + " " + name + " " + active + " (" + group.getName()+ " )";
    }
}
