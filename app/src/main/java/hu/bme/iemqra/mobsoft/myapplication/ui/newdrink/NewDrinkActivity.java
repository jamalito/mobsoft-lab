package hu.bme.iemqra.mobsoft.myapplication.ui.newdrink;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;

/**
 * Created by jamalito on 2017.04.05..
 */

public class NewDrinkActivity extends AppCompatActivity implements NewDrinkScreen{
        @Inject
        NewDrinkPresenter newDrinkPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);
    }
        //TODO: call inject

        @Override
        protected void onStart() {
        super.onStart();
        newDrinkPresenter.attachScreen(this);
    }

        @Override
        protected void onStop() {
        super.onStop();
        newDrinkPresenter.detachScreen();
    }

        @Override
        public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
        @Override
        public void showRecipe(int id) {    }

    }