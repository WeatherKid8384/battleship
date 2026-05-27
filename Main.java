package battleship;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to BattleShip");
        System.out.println("Would you like to start a new game? (Type in 1 for yes or 2 for no)");
        String startGame = input.nextLine();

        if (startGame.equals("1")) {
            System.out.println("Good Choice");
        } else {
            System.out.println("That's too bad, you have to play anyways");
        }

        TheGame game = new TheGame();
        boolean playGame = true;

        while (playGame) {
            game.print();
            System.out.print("Pick where you want to attack (rowcol, ex: 34 for row 3, col 4): ");
            String nextTurn = input.nextLine();

            int x = Character.getNumericValue(nextTurn.charAt(0));
            int y = Character.getNumericValue(nextTurn.charAt(1));

            game.hit(x, y);

            if (game.allShipsSunk()) {
                System.out.println("Congratulations! You sunk all the ships!");
                game.print();
                playGame = false;
            }
        }
    }
}
