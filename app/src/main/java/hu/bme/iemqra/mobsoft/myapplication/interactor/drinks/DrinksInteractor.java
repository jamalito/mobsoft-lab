package hu.bme.iemqra.mobsoft.myapplication.interactor.drinks;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.AddDrinkEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.AddDrinkToFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetDrinksEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.RemoveDrinkFromFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.repository.Repository;

/**
 * Created by jamalito on 2017.04.18..
 */

public class DrinksInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public void addNewDrink() {
        AddDrinkEvent event = new AddDrinkEvent();
    }

    public void addDrinkToFavourites(){
        AddDrinkToFavouritesEvent event = new AddDrinkToFavouritesEvent();
    }

    public void getDrinks(){
        GetDrinksEvent event = new GetDrinksEvent();
    }

    public void getFavouritesDrinks(){
        GetFavouritesEvent event = new GetFavouritesEvent();
    }

    public void removeDrinkFromFAvourites(){
        RemoveDrinkFromFavouritesEvent event = new RemoveDrinkFromFavouritesEvent();
    }
    public void searchDrinks(){
        GetDrinksEvent event = new GetDrinksEvent();
    }

}
