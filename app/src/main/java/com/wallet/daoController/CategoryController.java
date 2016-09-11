package com.wallet.daoController;

import com.wallet.db.model.Category;

import java.util.List;

/**
 * Created by Cengiz on 10.9.2016.
 */
public interface CategoryController {
    /**
     * Fetches Category record from database
     *
     * @param id database table record id field value
     * @return Category model
     */
    Category getCategoryById(Integer id);

    /**
     * Fetches Category record from database
     *
     * @param name database table record name field value
     * @return Category
     */
    Category getCategoryByName(String name);


    /**
     * Create a record into table.
     * @param category category model
     * @return if creating record is success, true, otherwise false
     */
    Boolean createCategory(Category category);

    /**
     * Update category record in its table
     * @param category category model
     * @return if updating record is success, true, otherwise false
     */
    Boolean updateCategory(Category category);

    /**
     * get result with filtering the category records by categoryFilter param
     * @param categoryFilter
     * @return
     */
    List<Category> getAllCategories(Category categoryFilter);
}
