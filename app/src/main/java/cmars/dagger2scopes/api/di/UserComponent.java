package cmars.dagger2scopes.api.di;

import cmars.dagger2scopes.ui.di.MainActivityComponent;
import cmars.dagger2scopes.ui.di.MainActivityModule;
import cmars.dagger2scopes.ui.di.UserDetailsComponent;
import cmars.dagger2scopes.ui.di.UserDetailsModule;
import dagger.Subcomponent;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);

    UserDetailsComponent plus(UserDetailsModule userDetailsModule);
}
