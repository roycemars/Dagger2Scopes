package cmars.dagger2scopes.entities;

import javax.inject.Inject;

import lombok.Data;

/**
 * Created by Constantine Mars on 26/02/16.
 */
@Data
public class Part1 {
    private String name;

    @Inject
    Part1() {
        name = "Part1";
    }
}
