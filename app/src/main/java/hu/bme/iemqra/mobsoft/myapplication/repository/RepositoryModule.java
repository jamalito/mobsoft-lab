package hu.bme.iemqra.mobsoft.myapplication.repository;

/**
 * Created by jamalito on 2017.04.19..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}
