package rules;

/**
 *
 * @author mcaikovs
 */
public class State {

    String stateString;

    public State(String stateString) {
        this.stateString = stateString;
    }

    protected String deadStateString() {
        return "X";
    }

    boolean isAlive() {
        return !deadStateString().equals(stateString);
    }

    protected String livingStatesWildcardString() {
        return "*";
    }

    boolean isWildcardForAlive() {
        return livingStatesWildcardString().equals(stateString);
    }

    protected String noNewStateString() {
        return "-";
    }

    public boolean doesNotChange() {
        return noNewStateString().equals(stateString);
    }

    public boolean matches(State patientState) {
        return equals(patientState)
                || (isWildcardForAlive() && patientState.isAlive());   // patient cannot have a wildcard state, so no need to check
    }
 
    public String getStateString() {
        return stateString;
    }

    public boolean equals(State state) {
        return stateString.equals(state.stateString);
    }

}
