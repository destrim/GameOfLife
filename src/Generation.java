import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Generation {
    public HashMap<Position, Cell> aliveCells = new HashMap<>();
    public HashMap<Position, Integer> numberOfNeighbours = new HashMap<>();
    public int length = 10;
    public int width = 10;

    public void newGen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of alive cells: ");
        int numberOfalive = scanner.nextInt();

        for (int i = 0; i < numberOfalive; i++) {
            System.out.print("Pos x: ");
            int posx = scanner.nextInt();

            System.out.print("Pos y: ");
            int posy = scanner.nextInt();

            Position pos = new Position(posx, posy);
            Cell cell = new Cell(true, pos);
            aliveCells.put(pos, cell);
        }
    }

    public void nextGen() {
        Set<Position> setOfAlivePos = aliveCells.keySet();
        Iterator<Position> listOfAlivePosIterator = setOfAlivePos.iterator();

        while (listOfAlivePosIterator.hasNext()) {
            Position positionForGettingXY = listOfAlivePosIterator.next();
            int x = positionForGettingXY.getX();
            int y = positionForGettingXY.getY();

            for (int i = x-1; i <= x+1; i++) {
                for (int j = y-1; j <= y+1; j++) {
                    Position pos = new Position(i, j);

                    if (pos.getX() == x && pos.getY() == y)
                        ;
                    else if (numberOfNeighbours.containsKey(pos)) {
                        int val = numberOfNeighbours.get(pos);
                        val++;
                        numberOfNeighbours.put(pos, val);
                    } else
                        numberOfNeighbours.put(pos, 1);
                }
            }
        }

        Set<Position> setOfNumberOfNeighbours = numberOfNeighbours.keySet();
        Iterator<Position> setOfNumberOfNeighboursIterator = setOfNumberOfNeighbours.iterator();

        while (setOfNumberOfNeighboursIterator.hasNext()) {
            Position positionForGettingXY = setOfNumberOfNeighboursIterator.next();

            int x = positionForGettingXY.getX();
            int y = positionForGettingXY.getY();

            Position pos = new Position(x, y);
            int neighbours = numberOfNeighbours.get(pos);

            if (neighbours < 2 || neighbours > 3) {
                aliveCells.remove(pos);
            } else if (neighbours == 3) {
                if (!aliveCells.containsKey(pos)) {
                    Cell cell = new Cell(true, pos);
                    aliveCells.put(pos, cell);
                }
            }
        }
    }

    public void showGen() {
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Position pos = new Position(i, j);

                if (aliveCells.containsKey(pos))
                    System.out.print("X");
                else
                    System.out.print("O");

                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }
}
