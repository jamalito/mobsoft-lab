package hu.bme.iemqra.mobsoft.myapplication.ui.browse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;


/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class BrowseActivity extends AppCompatActivity implements BrowseScreen {
    @Inject
    BrowsePresenter browsePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
    }
    //TODO: call inject

    @Override
    protected void onStart() {
        super.onStart();
        browsePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        browsePresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showDrinks(String s){

    }
}
