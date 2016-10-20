package com.three60t.meetup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author akochurov on 10/20/16.
 */
@Configuration
class MyConfBean {
    @Bean
    public SpaceShip spaceShip(Cockpit cockpit, Engine leftEngine, Engine rightEngine) {
        return new SpaceShipImpl(cockpit, leftEngine, rightEngine);
    }

    @Bean
    public Engine leftEngine(Fuel fuel) {
        return new AntimatterEngine(fuel);
    }

    @Bean
    public Engine rightEngine(Fuel fuel) {
        return new AntimatterEngine(fuel);
    }

    @Bean
    public Cockpit cockpit(Captain captain) {
        return new CockpitImpl(captain);
    }

    @Bean
    public Captain captain() {
        return new Person("James T. Kirk");
    }

    @Bean
    public Fuel fuel() {
        return new Antimatter();
    }
}
