package es.guiguegon.baseproject.di.modules;

import dagger.Module;
import dagger.Provides;
import es.guiguegon.baseproject.ui.BaseActivity;
import es.guiguegon.baseproject.di.scopes.PerActivity;

/**
 * Created by Guille on 12/11/2016.
 */
@Module
public class ActivityModule {
    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    BaseActivity provideActivity() {
        return this.baseActivity;
    }
}