package hu.bme.iemqra.mobsoft.myapplication.ui.main;

/**
 * Created by mobsoft on 2017. 03. 24..
 */
import org.greenrobot.eventbus.EventBus;

import  hu.bme.iemqra.mobsoft.myapplication.ui.Presenter;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    Executor executor;

    @Inject
    EventBus bus;
    //private static MainPresenter instance = null;

    public MainPresenter() {
    }


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }
}
