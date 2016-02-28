package cmars.dagger2scopes.ui.presenter;

import javax.inject.Inject;

import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.ui.view.LoginView;
import lombok.Data;

/**
 * Created by Constantine Mars on 23/02/16.
 */
@Data
public class LoginActivityPresenter {
    private LoginView view;
    private ApiHelper apiHelper;

    @Inject
    public LoginActivityPresenter(ApiHelper apiHelper, LoginView loginView) {
        this.apiHelper = apiHelper;
        view = loginView;
    }

    public void loadUser() {
        apiHelper.getUser();
//                .subscribe(
//                        view::onUserDownloaded,
//                        throwable -> Timber.e(throwable.getMessage())
//                );

    }
}
