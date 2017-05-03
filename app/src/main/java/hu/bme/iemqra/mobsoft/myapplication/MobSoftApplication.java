package hu.bme.iemqra.mobsoft.myapplication;
import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.repository.Repository;
/**
 * Created by mobsoft on 2017. 03. 24..
 */
import android.app.Application;

import com.orm.SugarRecord;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.ui.UIModule;

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

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
