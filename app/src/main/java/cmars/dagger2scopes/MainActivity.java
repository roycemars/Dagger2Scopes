package cmars.dagger2scopes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import cmars.dagger2scopes.api.ApiHelper;
import cmars.dagger2scopes.di.ActivityComponent;
import cmars.dagger2scopes.di.DaggerActivityComponent;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiHelper apiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComponent().inject(this);

        Timber.plant(new Timber.DebugTree());
        Timber.d(apiHelper.getResponse());
    }

    public ActivityComponent getComponent() {
        return DaggerActivityComponent.builder().build();
    }
}
