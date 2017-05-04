package hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsPresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsScreen;



public class DrinkDetailsActivity extends AppCompatActivity implements DrinkDetailsScreen {
    @Inject
    DrinkDetailsPresenter drinkDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);

        Bundle intentExtras = getIntent().getExtras();
        //final String id = intentExtras.getString("id");
        String name = intentExtras.getString("name");
        String type = intentExtras.getString("type");
        String count = intentExtras.getString("count");
        String recomm = intentExtras.getString("recomm");

        TextView tvName = (TextView)findViewById(R.id.drinkdetails_name);
        TextView tvType = (TextView)findViewById(R.id.drinkdetails_type);
        TextView tvCount = (TextView)findViewById(R.id.drinkdetails_count);
        TextView tvRecomm = (TextView)findViewById(R.id.drinkdetails_recomm);

        tvName.setText(name);
        tvType.setText(type);
        tvCount.setText(count);
        tvRecomm.setText(recomm);
    }


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