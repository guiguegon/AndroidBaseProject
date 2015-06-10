package es.guiguegon.androidbaseproject.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import es.guiguegon.androidbaseproject.interfaces.ILogProvider;
import es.guiguegon.androidbaseproject.providers.LogProviderFactory;

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

    public static App getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _logProvider = LogProviderFactory.getLogProvider();
        _logProvider.v(TAG, "onCreate");

        if (_instance == null) _instance = this;

    }
}
