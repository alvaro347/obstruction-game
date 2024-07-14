import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
      ObstructionGame obstruction = new ObstructionGame();
      ObstructionGame.startGame();
  }
}

class ObstructionGame {
  Display display;
  int rows;
  int columns;
  ArrayList<Integer> board;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public ObstructionGame() {

    board = new ArrayList<Integer>();
    try {
      System.out.println("---- Obstruct Game ----\n");
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

  public void startGame() {
    display = new Display(rows, columns);
    // display.displayGame();
    String[][] playersMoves = new String[rows][columns];
    boolean displayIsFull = false;
    Players players = new Players(rows, columns);
    display.displayGame(playersMoves);
    while (!displayIsFull) {
      playersMoves = players.playerInput();
      display.displayGame(playersMoves);
      displayIsFull = display.full(playersMoves);

    }
    this.gameOver(players.lastPlayer());

  }

  public void gameOver(int player) {
    System.out.println("\n---------------------------------");
    System.out.println("Player " + player + " wins!" + "\nGame Over.");
    System.out.println("---------------------------------\n");

  }
}

class Players {
  String[][] playersMoves;
  // int rowInput, columnInput;
  ArrayList<Integer> playerMove;
  int player;
  int moves;

  public Players(int rows, int columns) {
    playersMoves = new String[rows][columns];
    this.moves = 1;
  }

  public String[][] playerInput() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    playerMove = new ArrayList<Integer>();
    player = moves % 2 != 0 ? 1 : 2;
    try {
      System.out.println("\n---- Player " + player + " ----\n");
      System.out.println("Enter next move (row x column)");
      while (playerMove.size() != 2) {
        System.out.printf(playerMove.isEmpty() ? "row: " : "Column: ");
        String input = br.readLine();

        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
          playerMove.add(Integer.parseInt(input));
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

  public String[][] updatePlayerMove(ArrayList playerMove, int player) {
    int row = ((int) playerMove.get(0)) - 1;
    int column = ((int) playerMove.get(1)) - 1;
    if (playersMoves[row][column] == null) {
      for (int r = -1; r <= 1; r++) {
        for (int c = -1; c <= 1; c++) {
          if (c == 0 && r == 0) {
            playersMoves[row][column] = (player == 1 ? "0" : "X");
          } else if ((row + r) < playersMoves.length && (column + c) < playersMoves[0].length && (row + r) >= 0 && (column + c) >= 0) {
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

class Display {
  private int rows;
  private int columns;
  int[][] board;

  public Display(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.board = new int[rows][columns];
  }

  public void displayGame(String[][] playersMoves) {
    String empty = " ";

    for (int i = 0; i < rows; i++) {
      if (i == 0) {
        System.out.printf("       ");
        for (int n = 0; n < columns; n++) {
          // System.out.printf("ABDCEFGH".charAt(n) + " ");
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

  public boolean full(String[][] playersMoves) {
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