package rules;

import java.util.Random;

/**
 *
 * @author mcaikovs
 */
public class Prognosis {

    static Random rand = new Random();
    State nextState;
    int inverseProbability = 1; // by default happens always

    public Prognosis(State nextState) {
        this.nextState = nextState;
    }

    public Prognosis(State nextState, int inverseProbability) {
        this(nextState);
        this.inverseProbability = inverseProbability;
    }

    boolean fulfilled() {
        return rand.nextInt(inverseProbability) == 0;
    }

    public State getNewState(State currentState) {
        if (fulfilled()
                && !nextState.doesNotChange()) { // patient is not not poisoned
            return nextState;
        }
        return currentState;
    }
//
//    @Override
//    public String toString() {
//        return nextState + "/" + inverseProbability;
//    }
}
