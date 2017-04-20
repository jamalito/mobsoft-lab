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

    void addFavourite(Drink drink);

    void removeFavourite(Drink drink);

    void updateFavourites(List<Drink> drinks);

    boolean isInDB(Drink drink);
}
