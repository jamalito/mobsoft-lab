package hu.bme.iemqra.mobsoft.myapplication.ui.newdrink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowseActivity;

/**
 * Created by jamalito on 2017.04.05..
 */

public class NewDrinkActivity extends AppCompatActivity implements NewDrinkScreen {
    private EditText etName;
    private EditText etImgUrl;
    private EditText etCount;
    private EditText etType;
    private EditText etRecomm;

    @Inject
    NewDrinkPresenter newDrinkPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);

       // View view = getLayoutInflater().inflate(R.layout.activity_new_drink, null);

        etName = (EditText) findViewById(R.id.newdrink_etName);
        etImgUrl = (EditText) findViewById(R.id.newdrink_etImgUrl);
        etCount = (EditText) findViewById(R.id.newdrink_etCount);
        etType = (EditText) findViewById(R.id.newdrink_etType);
        etRecomm = (EditText) findViewById(R.id.newdrink_etRecomm);

        Button btnSave = (Button) findViewById(R.id.newdrink_btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NewDrink newDrink = new NewDrink();
                newDrink.setName(etName.getText().toString());
                newDrink.setImgUrl(etImgUrl.getText().toString());
                newDrink.setCount(Integer.parseInt(etCount.getText().toString()));
                newDrink.setType(etType.getText().toString());
                newDrink.setRecomm(etRecomm.getText().toString());


                newDrinkPresenter.addNewDrink(newDrink);

            }
        });
    }
    @Override
    public void showDrinks(){
        startActivity(new Intent(NewDrinkActivity.this, BrowseActivity.class));

    }
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

}