package cmars.dagger2scopes.app.component;

import cmars.dagger2scopes.app.UserScope;
import cmars.dagger2scopes.app.module.UserModule;
import cmars.dagger2scopes.ui.component.MainActivityComponent;
import cmars.dagger2scopes.ui.module.MainActivityModule;
import dagger.Subcomponent;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);
}
