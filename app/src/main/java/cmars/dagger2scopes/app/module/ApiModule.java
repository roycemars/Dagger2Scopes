package cmars.dagger2scopes.app.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    public String rest() {
        return "rest";
    }
}
