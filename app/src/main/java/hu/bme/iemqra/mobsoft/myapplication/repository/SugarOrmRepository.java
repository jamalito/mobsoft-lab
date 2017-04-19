package hu.bme.iemqra.mobsoft.myapplication.repository;

import android.content.Context;

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
        return null;
    }

    @Override
    public List<Drink> getDrinks(){
        return null;
    }

    @Override
    public void addDrink(Drink drink){

    }

    @Override
    public void saveFavourite(Drink drink){}

    @Override
    public void updateDrink(Drink drink){}

    @Override
    public void removeFavourite(Drink drink){}

    @Override
    public boolean isInDB(Drink drink){
        return true;
    }

}
