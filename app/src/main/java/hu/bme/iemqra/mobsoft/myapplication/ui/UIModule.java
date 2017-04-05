package hu.bme.iemqra.mobsoft.myapplication.ui;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowsePresenter;
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
    public BrowsePresenter provideBrowsePresenter() {
        return new BrowsePresenter();
    }
}
