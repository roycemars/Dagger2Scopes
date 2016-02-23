package cmars.dagger2scopes.ui.component;

import cmars.dagger2scopes.ui.activity.ActivityScope;
import cmars.dagger2scopes.ui.activity.MainActivity;
import cmars.dagger2scopes.ui.module.MainActivityModule;
import dagger.Subcomponent;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
