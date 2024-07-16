
import java.io.*;
import java.util.*;

/**
* ObstructionGmae class
* Handles the game to connect the different classes
*/

public class ObstructionGame {
  Display display;
  int rows;
  int columns;
  ArrayList<Integer> board;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  /**
  * ObstructionGmae Constructor
  * Starts the game asking for a board size and starts the player input.
  */
  public ObstructionGame() {
    board = new ArrayList<Integer>();
    try {
      System.out.println("---- Obstruction Game ----\n");
      System.out.println("Enter the board Dimmensions (rows x columns)");
      while (board.size() != 2) {
        System.out.printf(board.isEmpty() ? "rows: " : "Columns: ");
        String input = br.readLine();
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
          if (Integer.parseInt(input) > 4) {
            board.add(Integer.parseInt(input));
          } else {
            System.out.println("Board too small choose a bigger number");
          }

        } else {
          System.out.println("Wrong input! Enter a number");
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    System.out.println("\n---- Start Game ----\n");
    rows = board.get(0);
    columns = board.get(1);
  }

  /**
  * startGame method
  * Displays the game and asks for player input until the board it's full.
  */
  public void startGame() {
    display = new Display(rows, columns);
    String[][] playersMoves = new String[rows][columns];
    boolean displayIsFull = false;
    Players players = new Players(rows, columns);
    display.displayGame(playersMoves);
    while (!displayIsFull) {
      playersMoves = players.playerInput();
      display.displayGame(playersMoves);
      displayIsFull = display.isFull(playersMoves);
    }
    this.gameOver(players.lastPlayer());
  }

  /**
  * gameOver method
  * When the board it's full displays the winnder
  * @params player, the player that won the game.
  */
  public void gameOver(int player) {
    System.out.println("\n---------------------------------");
    System.out.println("Player " + player + " wins!" + "\nGame Over.");
    System.out.println("---------------------------------\n");
  }
  
}
