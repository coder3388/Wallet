package com.wallet.daoController;

import com.wallet.db.model.Person;

import java.util.List;

/**
 * Created by Cengiz on 10.9.2016.
 */
public interface CreditorController {

    /**
     * Create a record into table.
     * @param creditor category model
     * @return if creating record is success, true, otherwise false
     */
    Boolean createCreditor(Person creditor);

    /**
     * Update category record in its table
     * @param creditor category model
     * @return if updating record is success, true, otherwise false
     */
    Boolean updateCreditor(Person creditor);

    /**
     * Delete creditor from its table
     * @param id
     * @return if deleting record is success, true, otherwise false
     */
    Boolean daleteCreditor(Integer id);

    /**
     * get result with filtering the creditor records by creditorFilter param
     * @param creditorFilter
     * @return
     */
    List<Person> getAllActiveCreditor(Person creditorFilter);

    /**
     * Get creditors that are borrowed or norrowed persons
     * @return
     */
    List<Person> getIncomingCreditorsForPays();
}
