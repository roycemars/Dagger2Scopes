package cmars.dagger2scopes.ui.di;

import cmars.dagger2scopes.ui.activity.ActivityScope;
import cmars.dagger2scopes.ui.activity.UserDetailsActivity;
import dagger.Subcomponent;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@ActivityScope
@Subcomponent(modules = UserDetailsModule.class)
public interface UserDetailsComponent {
    void inject(UserDetailsActivity activity);
}
