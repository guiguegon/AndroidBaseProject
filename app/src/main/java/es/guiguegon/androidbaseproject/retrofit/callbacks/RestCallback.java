package es.guiguegon.androidbaseproject.retrofit.callbacks;

import es.guiguegon.androidbaseproject.presenter.IRestPresenter;
import es.guiguegon.androidbaseproject.retrofit.responses.RestResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by guillermo.guerrero on 29/05/2015.
 */
public class RestCallback implements Callback<RestResponse> {

    private IRestPresenter restPresenter;

    public RestCallback(IRestPresenter restPresenter) {
        this.restPresenter = restPresenter;
    }

    @Override
    public void success(RestResponse restResponse, Response response) {
        if (restResponse != null) {
            restPresenter.success();
        } else {
            restPresenter.error();
        }
    }

    @Override
    public void failure(RetrofitError error) {
        restPresenter.error();
    }
}
