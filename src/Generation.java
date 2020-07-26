import java.util.HashMap;
import java.util.Scanner;

public class Generation {
    public HashMap<Position, Cell> numberOfAliveCells = new HashMap<>();
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
            numberOfAliveCells.put(pos, cell);
        }
    }

    public void nextGen() {
        
    }

    public void showGen() {
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Position pos = new Position(i, j);

                if (numberOfAliveCells.containsKey(pos))
                    System.out.print("X");
                else
                    System.out.print("O");

                System.out.println(" ");
            }

            System.out.print("\n");
        }
    }
}
