package com.wallet.db.enums;

import com.wallet.db.dao.CashDao;
import com.wallet.db.dao.CategoryDao;
import com.wallet.db.dao.CreditorDao;
import com.wallet.db.dao.CurrencyUnitDao;
import com.wallet.db.model.Cash;
import com.wallet.db.model.Category;
import com.wallet.db.model.CurrencyUnit;
import com.wallet.db.model.Model;
import com.wallet.db.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cengiz on 21.8.2016.
 */
public enum EnumDaoAndModelMapping {
    CURRENCY_UNIT(CurrencyUnit.class, CurrencyUnitDao.class),
    CREDITOR(Person.class, CreditorDao.class),
    CATEGORY(Category.class, CategoryDao.class),
    CASH(Cash.class, CashDao.class);

    private Class modelClass;
    private Class daoClass;

    EnumDaoAndModelMapping(Class modelClass, Class daoClass) {
        this.modelClass = modelClass;
        this.daoClass = daoClass;
    }

    public Class getDaoClass() {
        return daoClass;
    }

    public Class getModelClass() {
        return modelClass;
    }

    public static Object getDaoClass(Class<? extends Model> modelClass) throws InstantiationException, IllegalAccessException{
        for(EnumDaoAndModelMapping e: EnumDaoAndModelMapping.values()) {
            if(e.getModelClass().getClass().equals(modelClass)) {
                return e.getDaoClass().newInstance();
            }
        }
        return null;
    }

    public static List<Class> getAllModelClass() {
        List<Class> listModels = new ArrayList<>();
        for(EnumDaoAndModelMapping e: EnumDaoAndModelMapping.values()) {
            listModels.add(e.getModelClass());
        }
        return null;
    }
}
