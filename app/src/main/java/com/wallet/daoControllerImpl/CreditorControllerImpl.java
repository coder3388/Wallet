package com.wallet.daoControllerImpl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.wallet.daoController.CashController;
import com.wallet.daoController.CreditorController;
import com.wallet.db.dao.CreditorDao;
import com.wallet.db.enums.EnumDaoAndModelMapping;
import com.wallet.db.model.Creditor;

import java.util.List;

/**
 * Created by Cengiz on 10.9.2016.
 */
public class CreditorControllerImpl implements CreditorController {
    private static final String TAG = CreditorControllerImpl.class.getCanonicalName();
    private CreditorDao daoClass;
    private Context context;
    //services
    private CashController cashController;

    public CreditorControllerImpl(Context context) {
        try {
            this.daoClass = (CreditorDao) EnumDaoAndModelMapping.getDaoClass(Creditor.class);
            this.context = context;
        } catch (Exception e) {
            Toast.makeText(context, "CategoryControllerImpl oluşturulurken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
    }

    @Override
    public Boolean createCreditor(Creditor creditor) {
        try {
            int result = daoClass.create(creditor);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Creditor kaydı oluşturulamadı!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public Boolean updateCreditor(Creditor creditor) {
        try {
            int result = daoClass.update(creditor);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Creditor kaydı güncellenemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public Boolean daleteCreditor(Integer id) {
        try {
            int result = daoClass.deleteById(id);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Creditor kaydı silinemdi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public List<Creditor> getAllActiveCreditor(Creditor creditorFilter) {
        if (cashController==null){
            cashController = new CashControllerImpl(context);
        }


        /*try {
            List<Creditor> creditors = daoClass.queryForMatching(creditorFilter);
            return creditors;
        }catch (Exception e){
            Toast.makeText(context, "Aktif Creditor kayıtları getirilemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }*/
        return null;
    }

    @Override
    public List<Creditor> getIncomingCreditorsForPays() {
        return null;
    }

    /*@Override
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
    }*/
}
