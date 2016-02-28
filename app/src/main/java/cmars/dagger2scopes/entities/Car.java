package cmars.dagger2scopes.entities;

import javax.inject.Inject;

import lombok.Data;

/**
 * Created by Constantine Mars on 26/02/16.
 */
@Data
public class Car {
    protected Engine engine;
    private String name;

    @Inject
    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }
}
