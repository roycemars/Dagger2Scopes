package cmars.dagger2scopes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import cmars.dagger2scopes.R;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.model.User;
import cmars.dagger2scopes.ui.module.LoginActivityModule;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import cmars.dagger2scopes.ui.view.LoginView;

public class LoginActivity extends BaseActivity implements LoginView {
    @Inject
    LoginActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadUser();
            }
        });
    }

    @Override
    protected void setupActivityComponent() {
        App.get(this)
                .getAppComponent()
                .plus(new LoginActivityModule(LoginActivity.this))
                .inject(this);
    }

    @Override
    public void onUserDownloaded(User user) {
        App.get(this).createUserComponent(user);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
