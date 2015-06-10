package es.guiguegon.androidbaseproject.providers;

import android.util.Log;

import es.guiguegon.androidbaseproject.interfaces.ILogProvider;

/**
 * Created by guillermo.guerrero on 26/05/2015.
 */
class LogProvider implements ILogProvider {
    private boolean debug;

    public LogProvider(boolean debug) {
        this.debug = debug;
    }

    public void v(String TAG, String log) {
        if (debug) Log.v(TAG, log);
    }

    public void w(String TAG, String log) {
        if (debug) Log.w(TAG, log);
    }

    public void i(String TAG, String log) {
        if (debug) Log.i(TAG, log);
    }

    public void d(String TAG, String log) {
        if (debug) Log.d(TAG, log);
    }

    public void e(String TAG, String log) {
        if (debug) Log.e(TAG, log);
    }
}