import java.util.Objects;

public class TransitionKey {
    State stateIn;
    String keyIn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransitionKey that = (TransitionKey) o;
        return Objects.equals(stateIn, that.stateIn) &&
                Objects.equals(keyIn, that.keyIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateIn, keyIn);
    }

    public TransitionKey(State stateIn, String keyIn) {
        this.stateIn = stateIn;
        this.keyIn = keyIn;
    }
}
