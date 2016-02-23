package cmars.dagger2scopes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cmars.dagger2scopes.R;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.ui.di.MainActivityModule;
import cmars.dagger2scopes.ui.view.MainView;

import static cmars.dagger2scopes.api.ApiHelper.User;


public class MainActivity extends BaseActivity implements MainView {
    @Bind(R.id.name)
    TextView name;
    @Inject
    User user;

    @OnClick(R.id.details)
    void details() {
        App.get(this).releaseUserComponent();
        startActivity(new Intent(this, UserDetailsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        name.setText(user.getName());
    }

    @Override
    protected void setupActivityComponent() {
        App.get(this).getUserComponent()
                .plus(new MainActivityModule())
                .inject(this);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
