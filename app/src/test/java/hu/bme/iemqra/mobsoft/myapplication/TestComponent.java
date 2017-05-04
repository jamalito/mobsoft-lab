package hu.bme.iemqra.mobsoft.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.myapplication.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.myapplication.repository.manager.MockManagerModule;
import hu.bme.iemqra.mobsoft.myapplication.repository.network.MockNetworkModule;

/**
 * Created by jamalito on 2017.05.04..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, MockManagerModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
