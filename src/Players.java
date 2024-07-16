import java.io.*;
import java.util.*;

/**
* Player Class
* Creates the player object that handles the moves and player input. 
*/

public class Players {
  String[][] playersMoves;
  ArrayList<Integer> playerMove;
  int player;
  int moves;
  int rows;
  int columns;
  
  /**
  * Player Class Constructor
  * @param rows and columns of the game
  */
  public Players(int rows, int columns) {
    playersMoves = new String[rows][columns];
    this.moves = 1;
    this.rows = rows;
    this.columns = columns;
  }
  
  /**
  * playerInput method
  * Handles the input of the player and adds it to an ArrayList
  */
  public String[][] playerInput() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int inputNumber;
    playerMove = new ArrayList<Integer>();
    player = moves % 2 != 0 ? 1 : 2;
    try {
      System.out.println("\n---- Player " + player + " ----\n");
      System.out.println("Enter next move (row x column)");
      while (playerMove.size() != 2) {
        System.out.printf(playerMove.isEmpty() ? "row: " : "Column: ");
        String input = br.readLine();
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
          inputNumber = Character.getNumericValue(input.charAt(0));
          if (playerMove.isEmpty() && inputNumber <= rows && inputNumber > 0) {
            playerMove.add(Integer.parseInt(input));
          } else if (!playerMove.isEmpty() && inputNumber <= columns && inputNumber > 0) {
            playerMove.add(Integer.parseInt(input));
          } else {
            System.out.println("Number is invalid! Try again");
          }
        } else {
          System.out.println("Wrong input! Enter a number");
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    System.out.println("\n");
    moves += 1;
    return this.updatePlayerMove(playerMove, player);
  }

  /**
  * updatePlayerMove method
  * @param playerMove, the coordinates of the player moves
  * @param player, which player made the move
  */
  public String[][] updatePlayerMove(ArrayList playerMove, int player) {
    int row = ((int) playerMove.get(0)) - 1;
    int column = ((int) playerMove.get(1)) - 1;
    if (playersMoves[row][column] == null) {
      for (int r = -1; r <= 1; r++) {
        for (int c = -1; c <= 1; c++) {
          if (c == 0 && r == 0) {
            playersMoves[row][column] = (player == 1 ? "0" : "X");
          } else if ((row + r) < playersMoves.length && (column + c) < playersMoves[0].length && (row + r) >= 0
              && (column + c) >= 0) {
            playersMoves[row + r][column + c] = "-";
          }
        }
      }
    } else {
      System.out.println("\n---------------------------------");
      System.out.println("The box it's not empty, try again");
      System.out.println("---------------------------------\n");
      moves -= 1;
      this.playerInput();
    }
    return playersMoves;
  }

  public int lastPlayer() {
    return player;
  }

}