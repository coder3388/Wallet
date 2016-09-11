package com.wallet.daoController;

import android.content.Context;

import com.wallet.db.model.CurrencyUnit;

/**
 * Created by Cengiz on 10.9.2016.
 */
public interface CurrencyController {
    /**
     * Fetches CurrencyUnit record from database
     *
     * @param id database table record id field value
     * @return CurrencyUnit model
     */
    CurrencyUnit getCurrencyDetail(Context context, Integer id);

    /**
     * Fetches CurrencyUnit record from database
     *
     * @param name database table record name field value
     * @return CurrencyUnit
     */
    CurrencyUnit getCurrencyDetail(Context context, String name);

    /**
     * Create a record into table.
     * @param context
     * @param currencyUnit currency model
     * @return if creating record is success, true, otherwise false
     */
    Boolean createCurrencyDetail(Context context, CurrencyUnit currencyUnit);
}
