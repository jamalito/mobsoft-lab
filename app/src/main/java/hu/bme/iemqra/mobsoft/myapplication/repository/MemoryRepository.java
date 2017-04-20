package hu.bme.iemqra.mobsoft.myapplication.repository;

import java.util.List;
import android.content.Context;

import java.util.ArrayList;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

/**
 * Created by jamalito on 2017.04.20..
 */

public class MemoryRepository implements Repository {
    public static List<Drink> drinks;


    @Override
    public void open(Context context) {
        Drink drink1 = new Drink();
        Drink drink2 = new Drink();

        drinks = new ArrayList<>();
        drinks.add(drink1);
        drinks.add(drink2);
    }

    @Override
    public void close() {

    }
    @Override
    public List<Drink> getFavourites(){
        return drinks;
    }

    @Override
    public void addFavourite(Drink drink){ drinks.add(drink);}

    @Override
    public void removeFavourite(Drink drink){ drinks.remove(drink);}

    @Override
    public void updateFavourites(List<Drink> drinks) {
        for (int i = 0; i < this.drinks.size(); i++) {
            Drink favourite = this.drinks.get(i);
            for (Drink drink : drinks) {
                if (drink.getId().equals(favourite.getId())) {
                    this.drinks.set(i, drink);
                }
            }
        }
    }

    @Override
    public boolean isInDB(Drink drink){
        return drinks.contains(drink);
    }
}
