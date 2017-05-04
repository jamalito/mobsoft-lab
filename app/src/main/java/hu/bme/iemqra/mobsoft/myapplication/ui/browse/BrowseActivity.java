package hu.bme.iemqra.mobsoft.myapplication.ui.browse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.myapplication.MobSoftApplication;
import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.adapter.DrinksAdapter;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.repository.Repository;
import hu.bme.iemqra.mobsoft.myapplication.ui.newdrink.NewDrinkActivity;

public class BrowseActivity extends AppCompatActivity implements BrowseScreen {
    private RecyclerView recyclerViewDrinks;
    private SwipeRefreshLayout swipeRefreshLayoutDrinks;
    private TextView tvEmpty;
    private List<Drink> drinkList;
    private DrinksAdapter drinksAdapter;

    @Inject
    BrowsePresenter browsePresenter;
    @Inject
    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        tvEmpty = (TextView) findViewById(R.id.drinks_tvEmpty);
        recyclerViewDrinks = (RecyclerView) findViewById(R.id.drinks_recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDrinks.setLayoutManager(llm);

        drinkList = new ArrayList<>();
        drinksAdapter = new DrinksAdapter(this, drinkList);
        recyclerViewDrinks.setAdapter(drinksAdapter);

        swipeRefreshLayoutDrinks = (SwipeRefreshLayout) findViewById(R.id.drinks_swipeRefreshLayout);
        swipeRefreshLayoutDrinks.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                browsePresenter.refreshDrinks();
        //createNavigationDrawer();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_drink:
                startActivity(new Intent(BrowseActivity.this, NewDrinkActivity.class));
                return true;
            case R.id.remove:
                repository.removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        browsePresenter.attachScreen(this);
        browsePresenter.refreshDrinks();
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
    public void showDrinks(List<Drink> drinkList){
        if (swipeRefreshLayoutDrinks != null) {
            swipeRefreshLayoutDrinks.setRefreshing(false);
        }

        if(drinkList.isEmpty()) {
            recyclerViewDrinks.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerViewDrinks.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }

        this.drinkList.clear();
        this.drinkList.addAll(drinkList);
        drinksAdapter.notifyDataSetChanged();
    }

}
