package cmars.dagger2scopes.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Data;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Constantine Mars on 2/22/16.
 * Simple Helper for REST API access
 */

@Singleton
@Data
public class ApiHelper {

    @Inject
    public ApiHelper() {
    }

    public Observable<User> getUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service.getUser("octocat")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface GitHubService {
        @GET("users/{user}")
        Observable<User> getUser(@Path("user") String user);
    }

    @Data
    public static class User {
        protected String login,
                url,
                type,
                name,
                avatar_url;
    }
}
