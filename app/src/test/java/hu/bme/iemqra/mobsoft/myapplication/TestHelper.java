package hu.bme.iemqra.mobsoft.myapplication;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
        MobSoftApplicationComponent injector =
                DaggerTestComponent.builder().testModule(
                        new TestModule(application.getApplicationContext())
                ).build();
        application.injector = injector;
    }
}
