package cmars.dagger2scopes.ui.activity;

import android.os.Bundle;

import cmars.dagger2scopes.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void setupActivityComponent() {

    }
}
