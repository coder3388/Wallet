package com.wallet.daoControllerImpl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.wallet.daoController.CashController;
import com.wallet.db.dao.CashDao;
import com.wallet.db.enums.EnumDaoAndModelMapping;
import com.wallet.db.model.Cash;

import java.util.List;

/**
 * Created by Cengiz on 11.9.2016.
 */
public class CashControllerImpl implements CashController {
    private static final String TAG = CashControllerImpl.class.getCanonicalName();
    private CashDao daoClass;
    private Context context;

    public CashControllerImpl(Context context) {
        try {
            this.daoClass = (CashDao) EnumDaoAndModelMapping.getDaoClass(Cash.class);
            this.context = context;
        } catch (Exception e) {
            Toast.makeText(context, "CashControllerImpl oluşturulurken bir hata meydana geldi.", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
    }

    @Override
    public Boolean createCash(Cash cash) {
        try {
            int result = daoClass.create(cash);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Cash kaydı oluşturulamadı!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public Boolean updateCash(Cash cashNew) {
        try {
            int result = daoClass.update(cashNew);
            return result>0 ? true:false;
        } catch (Exception e) {
            Toast.makeText(context, "Cash kaydı güncellenemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return false;
    }

    @Override
    public List<Cash> getAllCashByFilter(Cash cashFilter) {
        try {
            List<Cash> cashs = daoClass.queryForMatching(cashFilter);
            return cashs;
        }catch (Exception e){
            Toast.makeText(context, "Cash kayıtları getirilemedi!", Toast.LENGTH_SHORT);
            Log.e(TAG, "Bir hata meydana geldi", e);
        }
        return null;
    }
}
