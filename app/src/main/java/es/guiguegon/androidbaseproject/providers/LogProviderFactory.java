package es.guiguegon.androidbaseproject.providers;

import es.guiguegon.androidbaseproject.BuildConfig;
import es.guiguegon.androidbaseproject.providers.interfaces.ILogProvider;

/**
 * Created by guillermo.guerrero on 26/05/2015.
 */
public class LogProviderFactory {

    private static ILogProvider _logProvider;

    public static ILogProvider getLogProvider() {
        if (_logProvider == null) _logProvider = new LogProvider(BuildConfig.LOG);
        return _logProvider;
    }
}
