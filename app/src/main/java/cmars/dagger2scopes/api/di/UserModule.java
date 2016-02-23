package cmars.dagger2scopes.api.di;

import cmars.dagger2scopes.api.ApiHelper.User;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Module
public class UserModule {
    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User user() {
        return user;
    }
}
