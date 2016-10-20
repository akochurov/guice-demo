package com.three60t.meetup;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

/**
 * @author akochurov on 10/20/16.
 */
class MyModuleProvides extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    public SpaceShip spaceShip(Cockpit cockpit, @Named("left") Engine leftEngine,
                               @Named("right") Engine rightEngine) {
        return new SpaceShipImpl(cockpit, leftEngine, rightEngine);
    }

    @Provides
    @Named("left")
    public Engine leftEngine(Fuel fuel) { return new AntimatterEngine(fuel);  }

    @Provides
    @Named("right")
    public Engine rightEngine(Fuel fuel) { return new AntimatterEngine(fuel); }

    @Provides
    public Cockpit cockpit(Captain captain) { return new CockpitImpl(captain); }

    @Provides
    public Captain captain() { return new Person("James T. Kirk"); }

    @Provides
    public Fuel fuel() { return new Antimatter(); }
}
