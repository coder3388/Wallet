package com.wallet.daoControllerImpl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.wallet.daoController.CurrencyController;
import com.wallet.db.dao.CurrencyUnitDao;
import com.wallet.db.enums.EnumDaoAndModelMapping;
import com.wallet.db.model.CurrencyUnit;

import java.util.List;

/**
 * Created by Cengiz on 10.9.2016.
 */
public class CurrencyControllerImpl implements CurrencyController {
    private static final String TAG = CurrencyControllerImpl.class.getCanonicalName();
    @Override
    public CurrencyUnit getCurrencyDetail(Context context, Integer id) {
        //get dao for crud operations
        try {
            CurrencyUnitDao daoClass = (CurrencyUnitDao) EnumDaoAndModelMapping.getDaoClass(CurrencyUnit.class);
            CurrencyUnit currencyUnit = daoClass.queryForId(id);
            return currencyUnit;
        } catch (Exception e) {
            Toast.makeText(context, id + " 'li" + "Kayıt CurrencyUnitDao'dan alınırken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }

    @Override
    public CurrencyUnit getCurrencyDetail(Context context, String name) {
        //get dao for crud operations
        try {
            CurrencyUnitDao daoClass = (CurrencyUnitDao) EnumDaoAndModelMapping.getDaoClass(CurrencyUnit.class);
            List<CurrencyUnit> currencyUnits = daoClass.queryForEq("name", name);
            return currencyUnits!=null && currencyUnits.size() > 0 ? currencyUnits.get(0):null;
        } catch (Exception e) {
            Toast.makeText(context, name + " 'li" + "Kayıt CurrencyUnitDao'dan alınırken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }

    @Override
    public Boolean createCurrencyDetail(Context context, CurrencyUnit currencyUnit) {
        //get dao for crud operations
        try {
            CurrencyUnitDao daoClass = (CurrencyUnitDao) EnumDaoAndModelMapping.getDaoClass(CurrencyUnit.class);
            int result = daoClass.create(currencyUnit);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "CurrencyUnit kaydı oluşturulamadı!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }
}
