import java.util.Objects;

public class State {
    int id;
    boolean isFinish;
    boolean isStart;

    public State(int id, boolean isFinish, boolean isStart) {
        this.id = id;
        this.isFinish = isFinish;
        this.isStart = isStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
