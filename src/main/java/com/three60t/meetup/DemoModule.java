package com.three60t.meetup;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import java.lang.reflect.Constructor;

/**
 * @author akochurov on 10/20/16.
 */
class DemoModule extends AbstractModule {

    private static final Appolo13 SOME_EXISTING_OBJECT = new Appolo13();

    @Override
    protected void configure() {
        // Just class...
        bind(SpaceShip.class).to(Appolo13.class);
        // Class + any annotation of this kind...
        bind(SpaceShip.class).annotatedWith(MyAnnotation.class).to(Appolo13.class);
        // Class + annotation with given values
        bind(SpaceShip.class).annotatedWith(Names.named("test")).to(Appolo13.class);
        // Binds a primitive and allows type conversion for it
        bindConstant().annotatedWith(Names.named("test")).to(1);

        requireBinding(SpaceShip.class);
        requestInjection(SOME_EXISTING_OBJECT);
        requestStaticInjection(Appolo13.class);

        // Bind to class (or other interface)...
        bind(SpaceShip.class).to(Appolo13.class).in(Scopes.SINGLETON);
        // Bind to instance
        bind(SpaceShip.class).toInstance(new Appolo13());
        // Bind to constructor
        bind(SpaceShip.class).toConstructor((Constructor<SpaceShip>)SpaceShip.class.getConstructors()[0]);
        // Bind to provider (it would be called dynamically)
        bind(SpaceShip.class).toProvider(Appolo13::new);
    }

    private static class Appolo13 implements SpaceShip {
        @Override
        public void flyToMars() {
            throw new RuntimeException("Hey, I was going to fly to the Moon!");
        }
    }
}
