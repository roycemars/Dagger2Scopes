package cmars.dagger2scopes.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cmars.dagger2scopes.R;
import cmars.dagger2scopes.api.ApiHelper.User;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.ui.di.UserDetailsModule;

public class UserDetailsActivity extends BaseActivity {

    @Bind(R.id.user_name)
    TextView userName;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        userName.setText(user.getName() + " (details)");
    }

    @Override
    protected void setupActivityComponent() {
        App.get(this).getUserComponent()
                .plus(new UserDetailsModule())
                .inject(this);
    }
}
