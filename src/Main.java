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
            String whatToDo = scanner.next();
            if (whatToDo.equals("0"))
                break;
        }
    }
}
