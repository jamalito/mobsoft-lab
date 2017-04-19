package hu.bme.iemqra.mobsoft.myapplication.ui.favdrinks;

import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetFavouritesEvent;
import hu.bme.iemqra.mobsoft.myapplication.ui.Presenter;
import java.util.concurrent.Executor;
import android.util.Log;
import javax.inject.Inject;

import de.greenrobot.event.EventBus;
/**
 * Created by jamalito on 2017.04.05..
 */

public class FavDrinksPresenter extends Presenter<FavDrinksScreen> {


    @Inject
    DrinksInteractor drinksInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;
    @Override
    public void attachScreen(FavDrinksScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();  }

    public void getFavourites() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                drinksInteractor.getFavouritesDrinks();
            }
        });
    }
}