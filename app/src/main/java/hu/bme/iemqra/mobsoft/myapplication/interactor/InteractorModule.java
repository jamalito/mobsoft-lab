package hu.bme.iemqra.mobsoft.myapplication.interactor;

import dagger.*;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;

/**
 * Created by jamalito on 2017.04.18..
 */
@Module
public class InteractorModule {
    @Provides
    public DrinksInteractor provideDrinksInteractor() { return new DrinksInteractor(); }
}
