package es.guiguegon.androidbaseproject.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import es.guiguegon.androidbaseproject.interfaces.ILogProvider;
import es.guiguegon.androidbaseproject.providers.LogProviderFactory;

/**
 * Created by guillermo.guerrero on 26/05/2015.
 */
public abstract class AbstractFragment extends Fragment {

    /**
     * Logs
     */
    protected final String TAG = this.getClass().getSimpleName();
    ILogProvider _logProvider;

    /**
     * Fill the UI being aware of savedInstanceState
     *
     * @param savedInstanceState
     */
    protected abstract void fillUi(Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _logProvider.v(TAG, "onCreate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _logProvider = LogProviderFactory.getLogProvider();
        _logProvider.v(TAG, "onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _logProvider.v(TAG, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _logProvider.v(TAG, "onViewCreated");
        ButterKnife.inject(this, view);
        fillUi(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _logProvider.v(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        _logProvider.v(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        _logProvider.v(TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        _logProvider.v(TAG, "onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        _logProvider.v(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        _logProvider.v(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        _logProvider.v(TAG, "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _logProvider.v(TAG, "onDetach");
    }

}
