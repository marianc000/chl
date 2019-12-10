package rules;

import java.util.Random;

/**
 *
 * @author mcaikovs
 */
public class Prognosis {

    static Random rand = new Random();
    State state;
    int inverseProbability = 1; // happens always

    public Prognosis(State state) {
        this.state = state;
    }

    public Prognosis(State state, int inverseProbability) {
        this(state);
        this.inverseProbability = inverseProbability;
    }

    boolean prognosisFulfilled(int inverseProbability) {
        return rand.nextInt(inverseProbability) == 0;
    }

    public State getNewState(State currentState) {
        if (prognosisFulfilled(inverseProbability)) {
            return state;
        }
        return currentState;
    }

    @Override
    public String toString() {
        return state + "/" + inverseProbability;
    }

}
