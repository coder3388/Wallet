package com.wallet.daoController;

import com.wallet.db.model.Cash;

import java.util.List;

/**
 * Created by Cengiz on 11.9.2016.
 */
public interface CashController {
    /**
     * Create a new cash record in the cash table
     * @param cash will be insert a cash object
     * @return if the new cash inserting is  success, then true, otherwise false return.
     */
    Boolean createCash(Cash cash);

    /**
     * Update an existed cash with a new one in the table.
     * @param cashNew new cash data
     * @return if the cash updating is success, then true, otherwise false return.
     */
    Boolean updateCash(Cash cashNew);

    /**
     * Fetches all cash records by filtering cashFilter's field values from table
     * @param cashFilter
     * @return
     */
    List<Cash> getAllCashByFilter(Cash cashFilter);
}
