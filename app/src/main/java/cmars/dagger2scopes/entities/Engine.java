package cmars.dagger2scopes.entities;

import javax.inject.Inject;

import lombok.Data;

/**
 * Created by Constantine Mars on 26/02/16.
 */
@Data
public class Engine {
    @Inject
    Part1 part1;
    @Inject
    Part2 part2;
    String model;

    @Inject
    Engine() {
        model = "E1";
    }
}
