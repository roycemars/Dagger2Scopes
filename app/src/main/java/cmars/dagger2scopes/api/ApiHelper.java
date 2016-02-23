package cmars.dagger2scopes.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Data;

/**
 * Created by Constantine Mars on 2/22/16.
 */
@SuppressWarnings("DefaultFileTemplate")
@Singleton
@Data
public class ApiHelper {
    private String response = "dagger works!";
    private String memory = "";

    @Inject
    public ApiHelper() {
    }
}
