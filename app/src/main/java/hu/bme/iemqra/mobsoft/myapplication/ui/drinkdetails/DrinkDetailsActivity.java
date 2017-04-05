package hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsPresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsScreen;

/**
 * Created by jamalito on 2017.04.05..
 */

public class DrinkDetailsActivity extends AppCompatActivity implements DrinkDetailsScreen {
    @Inject
    DrinkDetailsPresenter drinkDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);
    }
    //TODO: call inject

    @Override
    protected void onStart() {
        super.onStart();
        drinkDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        drinkDetailsPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void updateDrink(int id) {

    }
}