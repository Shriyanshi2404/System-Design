package InterviewQuestions.TicTacToeGame;

import InterviewQuestions.TicTacToeGame.Board.Board;
import InterviewQuestions.TicTacToeGame.Board.Pair;
import InterviewQuestions.TicTacToeGame.Player.Player;
import InterviewQuestions.TicTacToeGame.PlayingPiece.PieceType;
import InterviewQuestions.TicTacToeGame.PlayingPiece.PlayingPiece;
import InterviewQuestions.TicTacToeGame.PlayingPiece.PlayingPieceO;
import InterviewQuestions.TicTacToeGame.PlayingPiece.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> players;
    private Board gameBoard;

    public void initialiseGame()
    {
        // Initialising two players list for this game
        players = new LinkedList<Player>();
        // Initialising two pieces
        PlayingPiece crossPiece = new PlayingPieceX();
        PlayingPiece zeroPiece = new PlayingPieceO();
        // Initialising players
        Player player1 = new Player("Player 1", crossPiece);
        Player player2 = new Player("Player 2", zeroPiece);
        players.add(player1);
        players.add(player2);
        // Initialising board
        gameBoard = new Board(3);
    }

    /**
     * 1. Remove the current player from the deque
     * 2. Check for free cells
     *    - If free cell is not found, then set noWinner as false which means match is DRAW and send status as DRAW
     *    - If free cell is found, then follow further steps
     * 3. Take the input from the player to get the row and column where he/she needs to insert the piece
     * 4. Now, check if you can insert in that cell or not
     *    - If you cannot insert that means it's already occupied by other player piece, simply continue to get another input from same player
     *    - make sure to add current player at first place of players list
     * 5. Add a piece in particular row and column of the board.
     * 6. Add back the current player at last of the players list
     * 7. Check if current player move make him/her the winner, else continue
     */
    public GameStatus startGame()
    {
        boolean noWinner = true;
        System.out.println("-----STARTING THE GAME-----");
        while(noWinner)
        {
            // Remove the player whose turn is and also put the player in the list back
            Player currentPlayer = players.removeFirst();

            // check for free cells
            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty())
            {
                noWinner = false;
                continue;
            }

            // Read the user input
            System.out.print("Player: " +  currentPlayer.getName() + " - Please enter [row, column] where you want to insert: ");
            Scanner scanner = new Scanner(System.in);
            String sc = scanner.nextLine();
            String[] rowColumn = sc.split(",");
            int row = Integer.valueOf(rowColumn[0]);
            int col = Integer.valueOf(rowColumn[1]);

            // Place the piece in the board
            boolean validMove = gameBoard.addPiece(row, col, currentPlayer.getPiece());
            if(validMove ==  false) {
                // Invalid Move: Player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer);
                continue;
            }

            // Print the board after each valid move
            System.out.println("\n----CURRENT BOARD STATE----");
            gameBoard.printBoard();
            System.out.println();

            players.addLast(currentPlayer);

            boolean isWinner = checkForWinner(row, col, currentPlayer.getPiece().pieceType);
            if(isWinner) {
                System.out.println("Winner of the match is: " + currentPlayer.getName());
                System.out.println("===>>> GAME OVER");
                return GameStatus.WIN;
            }
        }
        System.out.println("Match got DRAW");
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        PlayingPiece[][] board = gameBoard.getBoard();
        int size = gameBoard.getSize();

        // check for row
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null || board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // check for column
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null || board[i][col].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // check for diagonal
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // check for anti-diagonal
        for (int i = 0, j = size-1; i < size; i++, j--) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
