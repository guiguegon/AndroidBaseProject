package es.guiguegon.androidbaseproject.modules;

import android.app.Application;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.guiguegon.androidbaseproject.providers.LogProviderFactory;
import es.guiguegon.androidbaseproject.providers.interfaces.ILogProvider;

/**
 * Created by guillermo.guerrero on 28/05/2015.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(application.LOCATION_SERVICE);
    }
}
