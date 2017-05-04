package hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails;

import org.greenrobot.eventbus.EventBus;

import hu.bme.iemqra.mobsoft.myapplication.ui.Presenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowseScreen;

/**
 * Created by jamalito on 2017.04.05..
 */

public class DrinkDetailsPresenter extends Presenter<DrinkDetailsScreen> {

    @Override
    public void attachScreen(DrinkDetailsScreen screen) {
        super.attachScreen(screen);
//        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        //       EventBus.getDefault().unregister(this);
    }

}