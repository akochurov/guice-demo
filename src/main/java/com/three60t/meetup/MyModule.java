package com.three60t.meetup;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author akochurov on 10/20/16.
 */
class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SpaceShip.class).to(SpaceShipImpl.class);

        bind(Cockpit.class).to(CockpitImpl.class);
        bind(Captain.class).toInstance(new Person("James T. Kirk"));
        bind(Engine.class).annotatedWith(Names.named("left")).to(AntimatterEngine.class);
        bind(Engine.class).annotatedWith(Names.named("right")).to(AntimatterEngine.class);
        bind(Fuel.class).to(Antimatter.class);
    }
}
