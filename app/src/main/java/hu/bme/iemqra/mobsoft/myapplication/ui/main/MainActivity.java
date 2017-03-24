package hu.bme.iemqra.mobsoft.myapplication.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;

public class MainActivity extends AppCompatActivity implements MainScreen{

        @Inject
        MainPresenter mainPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            MobSoftApplication.injector.inject(this);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        //TODO: call inject

        @Override
        protected void onStart() {
            super.onStart();
            mainPresenter.attachScreen(this);
        }

        @Override
        protected void onStop() {
            super.onStop();
            mainPresenter.detachScreen();
        }

        @Override
        public void showMessage(String text) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
