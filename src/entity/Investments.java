package entity;

import java.util.ArrayList;

/**
 * A wrapper class designed to hold all of the investments that a user will make.
 */
public class Investments {
    public final ArrayList<Investment> investments;

    /**
     * A constructor for a new Investments entity. This should only ever need to be ran once.
     */
    public Investments() {
        investments = new ArrayList<Investment>();
    }
}
