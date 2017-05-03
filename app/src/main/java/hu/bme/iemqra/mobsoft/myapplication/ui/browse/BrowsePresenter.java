package hu.bme.iemqra.mobsoft.myapplication.ui.browse;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event.GetDrinksEvent;
import hu.bme.iemqra.mobsoft.myapplication.ui.Presenter;

public class BrowsePresenter extends Presenter<BrowseScreen> {
//    @Inject
//    @Network
//    Executor networkExecutor;

    @Inject
    DrinksInteractor drinksInteractor;

    @Override
    public void attachScreen(BrowseScreen screen) {
            super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void refreshDrinks() {
        drinksInteractor.getDrinks();
    }

    public void addFavourites() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDrinksEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showDrinks(event.getDrink());
            }
        }
    }
}