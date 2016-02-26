package cmars.dagger2scopes.entities;

import javax.inject.Inject;

import lombok.Data;

/**
 * Created by Constantine Mars on 26/02/16.
 */
@Data
public class Part2 {
    private String name;

    @Inject
    Part2() {
        name = "Part2";
    }
}
