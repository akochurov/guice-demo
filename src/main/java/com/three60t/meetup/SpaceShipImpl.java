package com.three60t.meetup;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author akochurov on 10/20/16.
 */
class SpaceShipImpl implements SpaceShip {
    private final Cockpit cockpit;
    private final Engine leftEngine;
    private final Engine rightEngine;

    @Inject
    public SpaceShipImpl(Cockpit cockpit, @Named("left") Engine leftEngine, @Named("right") Engine rightEngine) {
        this.cockpit = cockpit;
        this.leftEngine = leftEngine;
        this.rightEngine = rightEngine;
    }

    @Override
    public void flyToMars() {
        System.out.println("I'm flying to Mars");
    }
}
