package es.guiguegon.androidbaseproject.providers.interfaces;

/**
 * Created by guillermo.guerrero on 26/05/2015.
 */
public interface ILogProvider {

    void v(String TAG, String log);

    void w(String TAG, String log);

    void i(String TAG, String log);

    void d(String TAG, String log);

    void e(String TAG, String log);
}
