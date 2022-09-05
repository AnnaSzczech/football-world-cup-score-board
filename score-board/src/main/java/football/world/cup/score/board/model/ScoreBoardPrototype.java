package football.world.cup.score.board.model;

public class ScoreBoardPrototype<T> implements Cloneable {
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
