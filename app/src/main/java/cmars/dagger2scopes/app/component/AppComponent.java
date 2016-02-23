package cmars.dagger2scopes.app.component;

import javax.inject.Singleton;

import cmars.dagger2scopes.app.module.ApiModule;
import cmars.dagger2scopes.app.module.AppModule;
import cmars.dagger2scopes.app.module.UserModule;
import cmars.dagger2scopes.ui.component.LoginActivityComponent;
import cmars.dagger2scopes.ui.module.LoginActivityModule;
import dagger.Component;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})
public interface AppComponent {
    LoginActivityComponent plus(LoginActivityModule module);

    UserComponent plus(UserModule module);
}
