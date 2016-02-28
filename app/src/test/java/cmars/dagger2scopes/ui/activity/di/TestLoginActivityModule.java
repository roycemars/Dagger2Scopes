package cmars.dagger2scopes.ui.activity.di;

import javax.inject.Singleton;

import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.ui.activity.LoginActivity;
import cmars.dagger2scopes.ui.di.LoginActivityModule;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Created by Constantine Mars on 28/02/16.
 */
@Module
public class TestLoginActivityModule extends LoginActivityModule {
    public TestLoginActivityModule(LoginActivity activity) {
        super(activity);
    }

    @Provides
    @Singleton
    public ApiHelper apiHelper() {
        return mock(ApiHelper.class);
    }

    @Override
    public LoginActivityPresenter presenter(ApiHelper apiHelper) {
        return super.presenter(apiHelper);
    }
}
