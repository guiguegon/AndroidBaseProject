package es.guiguegon.androidbaseproject.application;

import android.app.Application;
import android.location.LocationManager;

import javax.inject.Inject;

import es.guiguegon.androidbaseproject.modules.AppComponent;
import es.guiguegon.androidbaseproject.modules.AppModule;
import es.guiguegon.androidbaseproject.modules.DaggerAppComponent;
import es.guiguegon.androidbaseproject.modules.DaggerRestComponent;
import es.guiguegon.androidbaseproject.providers.RestProvider;
import es.guiguegon.androidbaseproject.providers.interfaces.ILogProvider;
import es.guiguegon.androidbaseproject.providers.LogProviderFactory;
import es.guiguegon.androidbaseproject.providers.interfaces.IRestProvider;

/**
 * Created by guillermo.guerrero on 28/05/2015.
 */
public class App extends Application {

    /**
     * App instance
     */
    private static App _instance;
    /**
     * Logs
     */
    protected final String TAG = this.getClass().getSimpleName();
    ILogProvider _logProvider;
    @Inject
    LocationManager locationManager;
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        _logProvider = LogProviderFactory.getLogProvider();
        _logProvider.v(TAG, "onCreate");

        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))

                .build();

    }

    public AppComponent component() {
        return applicationComponent;
    }
}
