package cmars.dagger2scopes.ui.activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import cmars.dagger2scopes.BuildConfig;
import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.app.di.AppComponent;
import cmars.dagger2scopes.ui.activity.di.TestLoginActivityModule;
import cmars.dagger2scopes.ui.di.LoginActivityComponent;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by Constantine Mars on 28/02/16.
 */
@RunWith(DaggerRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    private AppComponent appComponent;
    private LoginActivityComponent loginActivityComponent;

    @Before
    public void setup() {
        TestApp app = (TestApp) RuntimeEnvironment.application;
        appComponent = app.getAppComponent();

    }

    @Test
    public void testOnUserDownloaded() throws Exception {
        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class);
        LoginActivity spy = spy(controller.get());
        loginActivityComponent = appComponent.plus(new TestLoginActivityModule(spy));

        doReturn(loginActivityComponent).when(spy).prepareActivityComponent();

        LoginActivity activity = controller.create().start().get();

        LoginActivityPresenter presenter = activity.presenter;

        ApiHelper apiHelper = mock(ApiHelper.class);
        presenter.setApiHelper(apiHelper);
        presenter.loadUser();
        verify(apiHelper).getUser();
    }


}