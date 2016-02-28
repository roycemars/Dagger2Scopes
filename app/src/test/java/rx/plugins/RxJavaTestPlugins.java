package rx.plugins;

/**
 * Created by Constantine Mars on 28/02/16.
 */
public class RxJavaTestPlugins extends RxJavaPlugins {
    RxJavaTestPlugins() {
        super();
    }

    public static void resetPlugins() {
        getInstance().reset();
    }
}
