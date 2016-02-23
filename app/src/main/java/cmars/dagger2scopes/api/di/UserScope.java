package cmars.dagger2scopes.api.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
