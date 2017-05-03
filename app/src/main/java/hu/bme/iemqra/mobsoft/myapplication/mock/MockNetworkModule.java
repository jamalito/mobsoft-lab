package hu.bme.iemqra.mobsoft.myapplication.mock;

/**
 * Created by jamalito on 2017.04.20..
 */
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.myapplication.mock.interceptors.DrinkMock;
import hu.bme.iemqra.mobsoft.myapplication.network.NetworkConfig;
import hu.bme.iemqra.mobsoft.myapplication.network.NetworkModule;
import hu.bme.iemqra.mobsoft.myapplication.network.drink.DrinkApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
@Module
public class MockNetworkModule {
//    private NetworkModule networkModule = new NetworkModule();
//
//    @Provides
//    @Singleton
//    public OkHttpClient.Builder provideOkHttpClientBuilder() {
//        return networkModule.provideOkHttpClientBuilder();
//    }
//
//    @Provides
//    @Singleton
//    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
//
//        builder.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                return MockHttpServer.call(request);
//            }
//        });
//
//        return builder.build();
//    }
//
//    @Provides
//    @Singleton
//    public Retrofit provideRetrofit(OkHttpClient client) {
//        return networkModule.provideRetrofit(client);
//    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.SERVICE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public DrinkApi provideDrinkApi(Retrofit retrofit) {
        return new DrinkMock();
    }
}
