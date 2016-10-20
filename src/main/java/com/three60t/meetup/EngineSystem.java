package com.three60t.meetup;

import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

/**
 * @author akochurov on 10/20/16.
 */
class EngineSystem extends PrivateModule {
    @Override
    protected void configure() {
        bind(Engine.class).annotatedWith(Names.named("left")).to(AntimatterEngine.class);
        bind(Engine.class).annotatedWith(Names.named("right")).to(AntimatterEngine.class);
        bind(Fuel.class).to(Antimatter.class);

        expose(Engine.class).annotatedWith(Names.named("left"));
        expose(Engine.class).annotatedWith(Names.named("right"));
    }
}
