package com.wallet.daoControllerImpl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.wallet.daoController.CategoryController;
import com.wallet.db.dao.CategoryDao;
import com.wallet.db.enums.EnumDaoAndModelMapping;
import com.wallet.db.model.Category;

import java.util.List;

/**
 * Created by Cengiz on 10.9.2016.
 */
public class CategoryControllerImpl implements CategoryController {
    private static final String TAG = CategoryControllerImpl.class.getCanonicalName();
    private CategoryDao daoClass;
    private Context context;

    public CategoryControllerImpl(Context context) {
        try {
            this.daoClass = (CategoryDao) EnumDaoAndModelMapping.getDaoClass(Category.class);
            this.context = context;
        } catch (Exception e) {
            Toast.makeText(context, "CategoryControllerImpl oluşturulurken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
    }

    @Override
    public Category getCategoryById(Integer id) {
        //get dao for crud operations
        try {
            Category currencyUnit = daoClass.queryForId(id);
            return currencyUnit;
        } catch (Exception e) {
            Toast.makeText(context, id + " 'li" + "Kayıt CategoryDao'dan alınırken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        //get dao for crud operations
        try {
            List<Category> categories = daoClass.queryForEq("name", name);
            return categories!=null && categories.size() > 0 ? categories.get(0):null;
        } catch (Exception e) {
            Toast.makeText(context, name + " 'li" + "Kayıt CategoryDao'dan alınırken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }

    @Override
    public Boolean createCategory(Category category) {
        //get dao for crud operations
        try {
            int result = daoClass.create(category);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Category kaydı oluşturulamadı!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public Boolean updateCategory( Category category) {
        try {
            int result = daoClass.update(category);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Category kaydı güncellenemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public List<Category> getAllCategories( Category categoryFilter) {
        try {
            List<Category> categories = daoClass.queryForMatching(categoryFilter);
            return categories;
        }catch (Exception e){
            Toast.makeText(context, "Category kayıtları getirilemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }
}
