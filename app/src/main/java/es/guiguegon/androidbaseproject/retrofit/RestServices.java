package es.guiguegon.androidbaseproject.retrofit;

import dagger.Component;
import es.guiguegon.androidbaseproject.modules.RestModule;
import es.guiguegon.androidbaseproject.retrofit.callbacks.RestCallback;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by guillermo.guerrero on 09/07/2015.
 */
public interface RestServices {

    @GET("/restService")
    void restService(RestCallback callback);

}
