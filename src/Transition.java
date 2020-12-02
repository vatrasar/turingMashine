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

	public String getInChar() {
		return inChar;
	}

	public void setInChar(String inChar) {
		this.inChar = inChar;
	}

	public String getOutChar() {
		return outChar;
	}

	public void setOutChar(String outChar) {
		this.outChar = outChar;
	}

	public Diretion getNextMoveDirection() {
		return nextMoveDirection;
	}

	public void setNextMoveDirection(Diretion nextMoveDirection) {
		this.nextMoveDirection = nextMoveDirection;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}
    
}
