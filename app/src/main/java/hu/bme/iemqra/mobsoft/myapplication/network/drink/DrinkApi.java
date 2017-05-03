package hu.bme.iemqra.mobsoft.myapplication.network.drink;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink;
import retrofit2.Call;
import retrofit2.http.*;

public interface DrinkApi {
    @POST("drink")
    Call<Drink> drinkPost(@Body NewDrink body);

    @GET("drink/search/{searchText}")
    Call<List<Drink>> drinkSearchSearchTextGet(@Path("searchText") String searchText);

    @GET("drinks")
    Call<List<Drink>> drinksGet();

    @GET("drinks/{id}")
    Call<Drink> drinksIdGet(@Path("id") int id);
}
