import java.io.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ObstructGame obstruct = new ObstructGame();
    obstruct.startGame();
  }
}

class ObstructGame {
  Display display;
  int rows;
  int columns;
  ArrayList<Integer> board;

  public ObstructGame() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    board = new ArrayList<Integer>();
    try {
      System.out.println("---- Obstruct Game ----\n");
      System.out.println("Enter the board Dimmensions (rows x columns)");
      while (board.size() != 2) {
        System.out.println(board.isEmpty() ? "rows: " : "Columns: ");
        String input = br.readLine();
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
          board.add(Integer.parseInt(input));
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
    display.displayGame();
    Players players = new Players(rows, columns);
    players.playerInput();
  }
}

class Players {
  String[][] playersMoves;
  // int rowInput, columnInput;
  ArrayList<Integer> playerMove;

  public Players(int rows, int columns) {
      playersMoves = new String[rows][columns];
  }

  public void playerInput() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    playerMove = new ArrayList<Integer>();
    try {
      System.out.println("---- Player 1 ----\n");
      System.out.println("Enter next move (row x column");
      while (playerMove.size() != 2) {
        System.out.println(playerMove.isEmpty() ? "row: " : "Column: ");
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
    this.updatePlayerMove(playerMove);
  }
  public void updatePlayerMove(ArrayList playerMove) {
    playersMove[r][]
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

  public void displayGame() {
    String empty = " ";

    for (int i = 0; i < rows; i++) {
      if (i == 0) {
        System.out.printf("       ");
        for (int n = 0; n < columns; n++) {
          System.out.printf("ABDCEFGH".charAt(n) + "   ");
        }
        System.out.println("\n\n");
      }
      for (int j = 0; j <= columns; j++) {
        if (j == 0) {
          System.out.printf((i + 1) + "    ");
        } else if (j <= columns) {
          System.out.printf("| " + "O" + " ");
        }
        if (j == columns) {
          System.out.printf("|");
        }

      }
      System.out.println("\n");
    }
  }

}