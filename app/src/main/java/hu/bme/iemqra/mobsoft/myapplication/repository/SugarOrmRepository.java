package hu.bme.iemqra.mobsoft.myapplication.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

/**
 * Created by jamalito on 2017.04.19..
 */

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context){
        SugarContext.init(context);
    }
    @Override
    public void close(){
        SugarContext.terminate();
    }

    @Override
    public List<Drink> getFavourites(){
         return SugarRecord.listAll(Drink.class);
    }

    @Override
    public void addFavourite(Drink drink){
        SugarRecord.saveInTx(drink);
    }

    @Override
    public void addDrink(Drink drink){
        SugarRecord.saveInTx(drink);
    }

    @Override
    public void removeFavourite(Drink drink){
        SugarRecord.deleteInTx(drink);
    }

    @Override
    public void removeAll() {
        SugarRecord.deleteAll(Drink.class);
    }

    @Override
    public void updateFavourites(List<Drink> drinks){
        List<Drink> favourites = getFavourites();
        List<Drink> toUpdate = new ArrayList<>(favourites.size());
        for (Drink favourite : favourites) {
            for (Drink drink : drinks) {
                if (drink.getId().equals(favourite.getId())) {
                    toUpdate.add(drink);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public boolean isInDB(Drink drink){

        return SugarRecord.findById(Drink.class, drink.getId()) != null;
    }

}
