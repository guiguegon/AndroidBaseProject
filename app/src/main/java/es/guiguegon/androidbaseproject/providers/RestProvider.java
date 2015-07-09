package es.guiguegon.androidbaseproject.providers;

import javax.inject.Inject;

import es.guiguegon.androidbaseproject.presenter.IRestPresenter;
import es.guiguegon.androidbaseproject.providers.interfaces.IRestProvider;
import es.guiguegon.androidbaseproject.retrofit.RestServices;
import es.guiguegon.androidbaseproject.retrofit.callbacks.RestCallback;

/**
 * Created by guillermo.guerrero on 09/07/2015.
 */
public class RestProvider implements IRestProvider{

    private final RestServices restServices;

    @Inject
    RestProvider(RestServices restServices) {
        this.restServices = restServices;
    }

    @Override
    public void getRestService(IRestPresenter restPresenter) {
        restServices.restService(new RestCallback(restPresenter));
    }
}
