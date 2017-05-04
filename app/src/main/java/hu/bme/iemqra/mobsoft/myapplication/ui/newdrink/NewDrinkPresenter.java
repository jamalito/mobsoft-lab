package hu.bme.iemqra.mobsoft.myapplication.ui.newdrink;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.AddDrinkEvent;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetDrinksEvent;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import hu.bme.iemqra.mobsoft.myapplication.ui.Presenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.favdrinks.FavDrinksScreen;



public class NewDrinkPresenter extends Presenter<NewDrinkScreen> {
    @Inject
    Executor executor;
    @Inject
    DrinksInteractor drinksInteractor;

    @Override
    public void attachScreen(NewDrinkScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void addNewDrink(final NewDrink newDrink) {
            executor.execute(new Runnable() {
            @Override
            public void run() {
                drinksInteractor.addNewDrink(newDrink);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final AddDrinkEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showDrinks();
            }
        }
    }

}