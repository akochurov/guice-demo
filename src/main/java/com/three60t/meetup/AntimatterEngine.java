package com.three60t.meetup;

import javax.inject.Inject;

/**
 * @author akochurov on 10/20/16.
 */
class AntimatterEngine implements Engine {
    private final Fuel fuel;

    @Inject
    public AntimatterEngine(Fuel fuel) {
        this.fuel = fuel;
    }
}
