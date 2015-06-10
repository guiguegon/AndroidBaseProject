package es.guiguegon.androidbaseproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import es.guiguegon.androidbaseproject.interfaces.ILogProvider;
import es.guiguegon.androidbaseproject.providers.LogProviderFactory;


public abstract class AbstractActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _logProvider = LogProviderFactory.getLogProvider();
        _logProvider.v(TAG, "onCreate");
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        _logProvider.v(TAG, "onPostCreate");
        ButterKnife.inject(this);
        fillUi(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        _logProvider.v(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        _logProvider.v(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        _logProvider.v(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        _logProvider.v(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        _logProvider.v(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _logProvider.v(TAG, "onDestroy");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            return;
        }
        // To remove back animation
        finish();
        // super.onBackPressed();
    }

    /**
     * Custom methods
     */
    protected void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            _logProvider.v(TAG, "setToolbar");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            _logProvider.e(TAG, "setToolbar on not view with toolbar");
        }
    }
}


