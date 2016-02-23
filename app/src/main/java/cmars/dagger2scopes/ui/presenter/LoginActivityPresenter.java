package cmars.dagger2scopes.ui.presenter;

import java.util.concurrent.TimeUnit;

import cmars.dagger2scopes.model.User;
import cmars.dagger2scopes.ui.view.LoginView;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Data
@RequiredArgsConstructor
public class LoginActivityPresenter {
    private final LoginView view;

    public void loadUser() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        view.onUserDownloaded(new User());
    }
}
