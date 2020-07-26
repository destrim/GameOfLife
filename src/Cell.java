import java.util.Objects;

public class Cell {
    private boolean isAlive;
    private Position pos;

    public Cell(boolean isAlive, Position pos) {
        this.isAlive = isAlive;
        this.pos = pos;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return isAlive == cell.isAlive &&
                pos.equals(cell.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive, pos);
    }
}
