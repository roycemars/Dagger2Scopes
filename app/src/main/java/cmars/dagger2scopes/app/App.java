package cmars.dagger2scopes.app;

import android.app.Application;
import android.content.Context;

import cmars.dagger2scopes.app.component.AppComponent;
import cmars.dagger2scopes.app.component.DaggerAppComponent;
import cmars.dagger2scopes.app.module.AppModule;
import lombok.Data;
import timber.log.Timber;

/**
 * Created by Constantine Mars on 2/22/16.
 */
@Data
public class App extends Application {
    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
