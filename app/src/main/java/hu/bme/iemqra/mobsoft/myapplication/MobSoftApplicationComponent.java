package hu.bme.iemqra.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.myapplication.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;
import hu.bme.iemqra.mobsoft.myapplication.repository.RepositoryModule;
import hu.bme.iemqra.mobsoft.myapplication.ui.UIModule;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowseActivity;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsActivity;
import hu.bme.iemqra.mobsoft.myapplication.ui.favdrinks.FavDrinksActivity;
import hu.bme.iemqra.mobsoft.myapplication.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.myapplication.ui.newdrink.NewDrinkActivity;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(BrowseActivity browseActivity);
    void inject(DrinkDetailsActivity drinkDetailsActivity);
    void inject(FavDrinksActivity favDrinksActivity);
    void inject(NewDrinkActivity newDrinkActivity);
    void inject(DrinksInteractor drinksInteractor);
    void inject(MobSoftApplication mobSoftApplication);
    //void inject(LoginActivity a);

}