package hu.bme.iemqra.mobsoft.myapplication.mock.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import hu.bme.iemqra.mobsoft.myapplication.network.drink.DrinkApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;

public class DrinkMock implements DrinkApi {

    @Override
    public Call<Drink> drinkPost(@Body NewDrink body) {
        return null;
    }

    @Override
    public Call<List<Drink>> drinkSearchSearchTextGet(@Path("searchText") String searchText) {
        return null;
    }

    @Override
    public Call<List<Drink>> drinksGet() {
        final List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink(1L, "Name", "Type", "Url", 1, "not recommended"));

        Call<List<Drink>> call = new Call<List<Drink>>() {
            @Override
            public Response<List<Drink>> execute() throws IOException {
                return Response.success(drinks);
            }

            @Override
            public void enqueue(Callback<List<Drink>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Drink>> clone() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Drink> drinksIdGet(@Path("id") int id) {
        return null;
    }
}
