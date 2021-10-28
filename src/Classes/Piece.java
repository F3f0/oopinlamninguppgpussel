package Classes;

public class Piece {
    private int value;
    private int position;

    public Piece(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public void setValue(int value) {
        this.value = value;
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

    public int changeValue(int valueGoing) {
        int valueComing = this.value;
        this.value = valueGoing;
        return valueComing;
    }

    @Override
    public String toString() {
        return "Classes.Piece{" +
                "value=" + value +
                ", position=" + position +
                '}';
    }
}
