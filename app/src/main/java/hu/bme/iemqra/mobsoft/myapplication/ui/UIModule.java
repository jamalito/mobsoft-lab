package hu.bme.iemqra.mobsoft.myapplication.ui;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowsePresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsPresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.main.MainPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
    @Provides
    @Singleton
    public BrowsePresenter provideBrowsePresenter() {

        return new BrowsePresenter();
    }
    @Provides
    @Singleton
    public DrinkDetailsPresenter provideDrinkDetailsPresenter() {
        return new DrinkDetailsPresenter();
    }
}
