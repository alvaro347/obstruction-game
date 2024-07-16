/**
* Display Class
* Creates the board and updates it everytime it's called with the moves of the players
*/

public class Display {
  private int rows;
  private int columns;
  int[][] board;

  public Display(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.board = new int[rows][columns];
  }

  /**
  * displayGame
  * Displays the game to show the board and the player moves.
  * @param playersMoves, the matrix containing the players moves and the obstructed tiles.
  */

  public void displayGame(String[][] playersMoves) {
    String empty = " ";

    for (int i = 0; i < rows; i++) {
      if (i == 0) {
        System.out.printf("       ");
        for (int n = 0; n < columns; n++) {
          System.out.printf((n + 1) + "   ");
        }
        System.out.println("\n\n");
      }
      for (int j = 0; j <= columns; j++) {
        if (j == 0) {
          System.out.printf((i + 1) + "    ");
        } else if (j <= columns) {
          System.out.printf("| " + (playersMoves[i][j - 1] == null ? empty : playersMoves[i][j - 1]) + " ");
        }
        if (j == columns) {
          System.out.printf("|");
        }
      }
      System.out.println("\n");
    }
  }

  /**
  * isFull method
  * Check if the board it's full everytime the player makes the next move.
  * @param playersMoves ArrayList containing the matrix of the moves
  */
  public boolean isFull(String[][] playersMoves) {
    for (int i = 0; i < playersMoves.length; i++) {
      for (int j = 0; j < playersMoves[0].length; j++) {
        if (playersMoves[i][j] == null) {
          return false;
        }
      }
    }
    return true;
  }

}