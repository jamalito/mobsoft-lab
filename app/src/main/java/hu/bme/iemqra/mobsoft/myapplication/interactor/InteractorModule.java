package hu.bme.iemqra.mobsoft.myapplication.interactor;

import dagger.*;
import hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.DrinksInteractor;

@Module
public class InteractorModule {
    @Provides
    public DrinksInteractor provideDrinksInteractor() { return new DrinksInteractor(); }
}
