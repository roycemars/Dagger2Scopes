package cmars.dagger2scopes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import cmars.dagger2scopes.R;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.ui.module.LoginActivityModule;
import cmars.dagger2scopes.ui.presenter.LoginActivityPresenter;

public class LoginActivity extends BaseActivity {
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
                presenter.test();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void setupActivityComponent() {
        App.get(this)
                .getAppComponent()
                .plus(new LoginActivityModule())
                .inject(this);
    }

}
