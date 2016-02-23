package cmars.dagger2scopes.ui.module;

import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.ui.activity.ActivityScope;
import cmars.dagger2scopes.ui.activity.LoginActivity;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Module
public class LoginActivityModule {
    private LoginActivity activity;


    public LoginActivityModule(LoginActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    LoginActivityPresenter presenter(ApiHelper apiHelper) {
        return new LoginActivityPresenter(apiHelper, activity);
    }
}
