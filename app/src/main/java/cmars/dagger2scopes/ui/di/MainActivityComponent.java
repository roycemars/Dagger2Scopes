package cmars.dagger2scopes.ui.di;

import cmars.dagger2scopes.ui.activity.ActivityScope;
import cmars.dagger2scopes.ui.activity.MainActivity;
import dagger.Subcomponent;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
