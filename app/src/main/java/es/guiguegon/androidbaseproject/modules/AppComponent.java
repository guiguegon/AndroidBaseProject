package es.guiguegon.androidbaseproject.modules;

import android.app.Application;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Component;
import es.guiguegon.androidbaseproject.application.App;
import es.guiguegon.androidbaseproject.providers.RestProvider;

/**
 * Created by guillermo.guerrero on 09/07/2015.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    // Field injections of any dependencies of the DemoApplication
    void inject(App application);

    // Exported for child-components.
    Application application();
    LocationManager locationManager();
}