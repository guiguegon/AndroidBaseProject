package es.guiguegon.androidbaseproject.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.guiguegon.androidbaseproject.retrofit.RestServices;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by guillermo.guerrero on 09/07/2015.
 */
@Module
public class RestModule {
    private final static String FAKE_ENDPOINT = "http://jsonstub.com";

    @Provides
    @Singleton
    RestServices provideRestServices() {
        Gson gson = new GsonBuilder()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setEndpoint(FAKE_ENDPOINT)
                .build();

        return restAdapter.create(RestServices.class);
    }
}
