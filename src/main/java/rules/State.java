package rules;

import java.util.Objects;

/**
 *
 * @author mcaikovs
 */
public class State {

    String state;

    public State(String state) {
        this.state = state;
    }

    protected boolean isAlive() {
        return !"X".equals(state);
    }

    protected boolean isAllNotDead() {
        return "*".equals(state);
    }

    @Override
    public String toString() {
        return state;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        final State other = (State) obj;
        return this.state.equals(other.state);
    }

}
