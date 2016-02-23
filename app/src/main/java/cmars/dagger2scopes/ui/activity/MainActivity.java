package cmars.dagger2scopes.ui.activity;

import android.os.Bundle;

import cmars.dagger2scopes.R;
import cmars.dagger2scopes.app.App;
import cmars.dagger2scopes.ui.module.MainActivityModule;
import cmars.dagger2scopes.ui.view.MainView;


public class MainActivity extends BaseActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void setupActivityComponent() {
        App.get(this).getUserComponent()
                .plus(new MainActivityModule())
                .inject(this);
    }
}
