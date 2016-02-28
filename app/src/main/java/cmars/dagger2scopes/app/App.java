package cmars.dagger2scopes.app;

import android.app.Application;
import android.content.Context;

import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.api.di.UserComponent;
import cmars.dagger2scopes.api.di.UserModule;
import cmars.dagger2scopes.app.di.AppComponent;
import cmars.dagger2scopes.app.di.AppModule;
import cmars.dagger2scopes.app.di.DaggerAppComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import timber.log.Timber;

/**
 * Created by Constantine Mars on 2/22/16.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class App extends Application {
    private AppComponent appComponent;
    private UserComponent userComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        initAppComponent();
    }

    protected DaggerAppComponent.Builder prepareAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this));
    }

    private void initAppComponent() {
        appComponent = prepareAppComponent()
                .build();
    }

    public UserComponent createUserComponent(ApiHelper.User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }
}
