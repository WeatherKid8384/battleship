import java.util.Scanner;

public class TheGame {
    private String[][] board = new String[10][10];
    private Ships carrier;
    private Ships battleship;
    private Ships cruiser;

    public TheGame() {
        
        carrier = new Ships(5, "Carrier");
        battleship = new Ships(4, "Battleship");
        cruiser = new Ships(3, "Cruiser");


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = "  ";
                } else if (i == 0) {
                    board[i][j] = j + " ";
                } else if (j == 0) {
                    board[i][j] = i + " ";
                } else {
                    board[i][j] = "~ ";
                }
            }
        }
    }



    public void hit(int xcoord, int ycoord) {
        int [] coords = {xcoord, ycoord};
        Ships[] allShips = {carrier, battleship, cruiser};

        boolean isHit = false;
        String shipName = "";
        if (coords[0] < 1 || coords[0] > 9 || coords[1] < 1 || coords[1] > 9) {
            System.out.println("Invalid coordinates! Use 1-9 for both row and column.");
            return;
        }
        if (!board[coords[0]][coords[1]].equals("~ ")) {
            System.out.println("Space already hit, try a different spot!");
            return;

        }

        for (Ships s : allShips) {
          if (s.checkHit(coords[0], coords[1])) {
          s.removePosition(coords[0], coords[1]);
          isHit = true;
          shipName = s.getName();
          break; 
          }
        }


        if (isHit) {
            board[coords[0]][coords[1]] = "X ";
            int wack = (int)(Math.random() * 4) + 1;
            if (wack == 1) System.out.println("Hit!");
            if (wack == 2) System.out.println("Ouch!");
            if (wack == 3) System.out.println("Stop it... you're hurting me...");
            if (wack == 4) System.out.println("Dang it...");
            if (shipSunk(shipName)) {
                System.out.println("Nice! You sunk the " + shipName + "!");
            }
        } else {
            board[coords[0]][coords[1]] = "O ";
            int ran = (int)(Math.random() * 4) + 1;
            if (ran == 1) System.out.println("Ahh, what a shame, you missed...");
            if (ran == 2) System.out.println("You're boring me with your misses...");
            if (ran == 3) System.out.println("Lock in...missing is so Kevin.");
            if (ran == 4) {
                System.out.print("Watch out, ");
                for (int i = 0; i < 9; i++)
                  System.out.print("tung ");
                System.out.println("sahur is gonna get you!");
            }
        }
    }


    private boolean shipSunk(String shipName) {
        if (shipName.equals(carrier.getName())) return carrier.isSunk();
        if (shipName.equals(battleship.getName())) return battleship.isSunk();
        if (shipName.equals(cruiser.getName())) return cruiser.isSunk();
        return false;
    }


    public boolean allShipsSunk() {
        return carrier.isSunk() && battleship.isSunk() && cruiser.isSunk();
    }


    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
