package cmars.dagger2scopes.di;

import javax.inject.Singleton;

import cmars.dagger2scopes.MainActivity;
import dagger.Component;

/**
 * Created by Constantine Mars on 2/22/16.
 */
@Singleton
@Component
public interface ActivityComponent {
    void inject(MainActivity activity);
}
