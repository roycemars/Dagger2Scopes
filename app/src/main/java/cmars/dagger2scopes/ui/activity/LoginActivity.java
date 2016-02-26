package cmars.dagger2scopes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import cmars.dagger2scopes.R;
import cmars.dagger2scopes.api.ApiHelper.User;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.entities.Car;
import cmars.dagger2scopes.entities.Engine;
import cmars.dagger2scopes.ui.di.LoginActivityModule;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;
import cmars.dagger2scopes.ui.view.LoginView;
import timber.log.Timber;

public class LoginActivity extends BaseActivity implements LoginView {
    @Inject
    LoginActivityPresenter presenter;

    @Inject
    Car car;
    @Inject
    Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Timber.d(engine.getModel());
        Timber.d(car.getName());
        Timber.d(car.getEngine().getModel());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> presenter.loadUser());
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
