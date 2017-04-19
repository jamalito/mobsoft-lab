package hu.bme.iemqra.mobsoft.myapplication.repository;

import android.content.Context;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

/**
 * Created by jamalito on 2017.04.19..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Drink> getFavourites();

    List<Drink> getDrinks();

    void addDrink(Drink drink);

    void addFavourite(Drink drink);

    void updateDrink(Drink drink);

    void removeFavourite(Drink drink);

    boolean isInDB(Drink drink);
}
