package cmars.dagger2scopes.ui.activity;

import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.app.di.DaggerAppComponent;

/**
 * Created by Constantine Mars on 28/02/16.
 */
public class TestApp extends App {
    @Override
    protected DaggerAppComponent.Builder prepareAppComponent() {
        return super.prepareAppComponent()
                .appModule(new TestAppModule(this));
    }


}
