package cmars.dagger2scopes.app.di;

import javax.inject.Singleton;

import cmars.dagger2scopes.api.di.UserComponent;
import cmars.dagger2scopes.api.di.UserModule;
import cmars.dagger2scopes.ui.di.LoginActivityComponent;
import cmars.dagger2scopes.ui.di.LoginActivityModule;
import dagger.Component;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    LoginActivityComponent plus(LoginActivityModule module);
    UserComponent plus(UserModule module);
}
