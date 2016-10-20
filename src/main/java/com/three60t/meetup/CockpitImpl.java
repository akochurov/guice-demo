package com.three60t.meetup;

import javax.inject.Inject;

/**
 * @author akochurov on 10/20/16.
 */
class CockpitImpl implements Cockpit {
    private final Captain captain;

    @Inject
    public CockpitImpl(Captain captain) {
        this.captain = captain;
    }
}
