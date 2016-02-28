package cmars.dagger2scopes.ui.activity;

import org.junit.After;
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
import cmars.dagger2scopes.ui.activity.di.TestApp;
import cmars.dagger2scopes.ui.activity.di.TestLoginActivityModule;
import cmars.dagger2scopes.ui.activity.utils.RxDaggerRobolectricTestRunner;
import cmars.dagger2scopes.ui.di.LoginActivityComponent;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import cmars.dagger2scopes.ui.view.LoginView;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by Constantine Mars on 28/02/16.
 */
@RunWith(RxDaggerRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    private AppComponent appComponent;
    private LoginActivityComponent loginActivityComponent;

    @Before
    public void setup() {
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        TestApp app = (TestApp) RuntimeEnvironment.application;
        appComponent = app.getAppComponent();
    }

    @After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
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
        doReturn(rx.Observable.just(null)).when(apiHelper).getUser();
        presenter.setApiHelper(apiHelper);

        LoginView view = mock(LoginView.class);
        presenter.setView(view);

        presenter.loadUser();
        verify(apiHelper).getUser();
        verify(view).onUserDownloaded(null);
    }


}