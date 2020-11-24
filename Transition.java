public class Transition {

    String inChar;
    String outChar;
    Diretion nextMoveDirection;
    State nextState;

    public Transition(String inChar, String outChar, Diretion nextMoveDirection, State nextState) {
        this.inChar = inChar;
        this.outChar = outChar;
        this.nextMoveDirection = nextMoveDirection;
        this.nextState = nextState;
    }
}
