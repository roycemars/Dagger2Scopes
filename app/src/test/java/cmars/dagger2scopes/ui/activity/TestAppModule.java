package cmars.dagger2scopes.ui.activity;

import android.app.Application;

import cmars.dagger2scopes.app.di.AppModule;
import dagger.Module;

/**
 * Created by Constantine Mars on 28/02/16.
 */
@Module
public class TestAppModule extends AppModule {
    public TestAppModule(Application application) {
        super(application);
    }
}
