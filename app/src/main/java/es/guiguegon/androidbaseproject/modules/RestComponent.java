package es.guiguegon.androidbaseproject.modules;

import javax.inject.Singleton;

import dagger.Component;
import es.guiguegon.androidbaseproject.providers.RestProvider;

/**
 * Created by guillermo.guerrero on 09/07/2015.
 */
@Singleton
@Component(modules = RestModule.class)
public interface RestComponent {
    RestProvider getRestProvider();
}
