package es.guiguegon.baseproject.di.components;

import dagger.Component;
import es.guiguegon.baseproject.ui.BaseActivity;
import es.guiguegon.baseproject.di.modules.ActivityModule;
import es.guiguegon.baseproject.di.scopes.PerActivity;

/**
 * Created by guiguegon on 12/11/2016.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);
}
