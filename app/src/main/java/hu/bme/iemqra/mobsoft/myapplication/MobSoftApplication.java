package hu.bme.iemqra.mobsoft.myapplication;
import javax.inject.Inject;
import hu.bme.iemqra.mobsoft.myapplication.repository.Repository;
/**
 * Created by mobsoft on 2017. 03. 24..
 */
import android.app.Application;

import hu.bme.iemqra.mobsoft.myapplication.ui.UIModule;

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
