package hu.bme.iemqra.mobsoft.myapplication.ui.favdrinks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsPresenter;

/**
 * Created by jamalito on 2017.04.05..
 */

public class FavDrinksActivity extends AppCompatActivity implements FavDrinksScreen {
    @Inject
    FavDrinksPresenter favDrinksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_drinks);
    }
    //TODO: call inject

    @Override
    protected void onStart() {
        super.onStart();
        favDrinksPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        favDrinksPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void deleteFav(int id) {    }
    @Override
    public void showFav(int id) {    }
}