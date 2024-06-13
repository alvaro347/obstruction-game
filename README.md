# Obstruction Game in Java

This project is a recreation of the "Obstruction" game implemented in Java. The game logic, player interactions, and board display are handled through various classes to create an interactive console-based game.

## Table of Contents

- [Obstruction Game in Java](#obstruction-game-in-java)
  - [Table of Contents](#table-of-contents)
  - [Game Rules](#game-rules)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Example Gameplay](#example-gameplay)
  - [Classes](#classes)
    - [Main](#main)
    - [Players](#players)
    - [Display](#display)
    - [ObstructionGame](#obstructiongame)
  - [License](#license)

## Game Rules

Obstruction is a two-player strategy game played on a rectangular grid. Players take turns marking a cell on the grid. When a player marks a cell, all adjacent cells (including diagonals) become blocked and cannot be used in future moves. The player who cannot make a move loses the game.

## Installation

To run the Obstruction game, you need to have Java installed on your machine. Follow these steps to set up and run the game:

1. Clone the repository:

    ```sh
    git clone https://github.com/yourusername/obstruction-game.git
    cd obstruction-game
    ```

2. Compile the Java files:

    ```sh
    javac Main.java
    ```

3. Run the game:

    ```sh
    java Main
    ```

## Usage

Upon running the game, you will be prompted to enter the board dimensions (rows and columns). The minimum dimension size is 5. Players then take turns entering their moves by specifying the row and column numbers. The game continues until no more moves can be made, and the player who is unable to make a move loses.

## Example Gameplay

1. Start the game and enter board dimensions:

    ```sh
    ---- Obstruction Game ----

    Enter the board dimensions (rows x columns)
    rows: 5
    Columns: 5

    ---- Start Game ----
    ```

2. Players take turns to make moves:

    ```sh
    ---- Player 1 ----

    Enter next move (row x column)
    row: 3
    Column: 3
    ```

3. The game board is updated after each move:

    ```sh
           1   2   3   4   5   

    1    |   |   |   |   |   |

    2    |   | - | - | - |   |

    3    |   | - | 0 | - |   |

    4    |   | - | - | - |   |

    5    |   |   |   |   |   |
    ```

4. The game continues until the board is full:

    ```sh
    Player X wins!
    Game Over.
    ```

## Classes

### Main

The `Main` class contains the `main` method that starts the game by creating an instance of `ObstructionGame` and invoking the `startGame` method.

### Players

The `Players` class handles the player moves and inputs. It keeps track of the current state of the game board and updates it based on player actions.

### Display

The `Display` class is responsible for rendering the game board on the console. It updates the board after each move and checks if the board is full.

### ObstructionGame

The `ObstructionGame` class integrates the game flow. It initializes the game, manages the player turns, and determines when the game is over.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
