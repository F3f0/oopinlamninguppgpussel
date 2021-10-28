package Classes;

public class Piece {
    private final int value;
    private int position;

    public Piece(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int changePosition(int positionGoing) {
        int positionComing = this.position;
        this.position = positionGoing;
        return positionComing;
    }

    @Override
    public String toString() {
        return "Classes.Piece{" +
                "value=" + value +
                ", position=" + position +
                '}';
    }
}
