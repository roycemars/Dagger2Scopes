package cmars.dagger2scopes;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Constantine Mars on 2/22/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
