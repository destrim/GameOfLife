import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generation game = new Generation();

        game.newGen();
        game.showGen();

        while (true) {
            game.nextGen();
            game.showGen();
            int whatToDo = scanner.nextInt();
            if (whatToDo == 0)
                break;
        }
    }
}
