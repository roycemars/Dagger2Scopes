package cmars.dagger2scopes.ui.module;

import cmars.dagger2scopes.ui.activity.ActivityScope;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Module
public class LoginActivityModule {
    @Provides
    @ActivityScope
    LoginActivityPresenter presenter() {
        return new LoginActivityPresenter();
    }
}
