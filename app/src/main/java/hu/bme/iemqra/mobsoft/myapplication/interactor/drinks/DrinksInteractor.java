package hu.bme.iemqra.mobsoft.myapplication.interactor.drinks;
import com.orm.SugarRecord;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.AddDrinkEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.AddDrinkToFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetDrinkEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetDrinksEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.RemoveDrinkFromFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import hu.bme.iemqra.mobsoft.myapplication.network.drink.DrinkApi;
import hu.bme.iemqra.mobsoft.myapplication.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jamalito on 2017.04.18..
 */

public class DrinksInteractor {
    @Inject
    DrinkApi drinkApi;

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public DrinksInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void addNewDrink(NewDrink newDrink) {
        Call<Drink> queryCall = drinkApi.drinkPost(newDrink);

        AddDrinkEvent event = new AddDrinkEvent();
        try {
            Response<Drink> response = queryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Something went wrong!");
            }
            event.setCode(response.code());
            Drink drink= response.body();
            SugarRecord.saveInTx(drink);
            event.setDrink(drink);
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }

    }

    public void addDrinkToFavourites(){
        AddDrinkToFavouritesEvent event = new AddDrinkToFavouritesEvent();
    }

    public void getDrinks(){
        Call<List<Drink>> queryCall = drinkApi.drinksGet();

        GetDrinksEvent event = new GetDrinksEvent();
        try {
            Response<List<Drink>> response = queryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Something went wrong!");
            }
            event.setCode(response.code());
            List<Drink> drinks = response.body();
            SugarRecord.saveInTx(drinks);
            event.setDrink(SugarRecord.listAll(Drink.class));
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
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
