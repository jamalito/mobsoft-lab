package hu.bme.iemqra.mobsoft.myapplication;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowsePresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsPresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.newdrink.NewDrinkPresenter;



@Module
public class TestModule {
    private Context context;

    public TestModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() { return context; }

    @Provides
    @Singleton
    public BrowsePresenter provideBrowsePresenter() { return new BrowsePresenter(); }

    @Provides
    @Singleton
    public NewDrinkPresenter provideNewDrinkPresenter() { return new NewDrinkPresenter(); }

    @Provides
    @Singleton
    public DrinkDetailsPresenter provideDrinkDetailsPresenter() { return new DrinkDetailsPresenter(); }


}
