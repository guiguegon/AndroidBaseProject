package es.guiguegon.androidbaseproject.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import butterknife.InjectView;
import es.guiguegon.androidbaseproject.R;
import es.guiguegon.androidbaseproject.providers.RestProvider;

public class MainActivity extends AbstractActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.navigation_view)
    NavigationView navigationView;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    RestProvider restProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void fillUi(Bundle savedInstanceState) {
        setToolbar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        fab.setOnClickListener(this);
    }

    /**
     * Options
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                // do something
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Click Listeners
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default:
                Snackbar.make(drawerLayout, menuItem.getTitle(), Snackbar.LENGTH_LONG)
                        .show();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                Snackbar.make(v, "fab", Snackbar.LENGTH_LONG).show();
        }
    }
}
