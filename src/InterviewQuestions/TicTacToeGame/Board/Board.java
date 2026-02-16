package InterviewQuestions.TicTacToeGame.Board;

import InterviewQuestions.TicTacToeGame.PlayingPiece.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece board[][];

    public Board(int size)
    {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public PlayingPiece[][] getBoard()
    {
        return board;
    }

    public int getSize()
    {
        return size;
    }

    public boolean addPiece(int row, int col, PlayingPiece piece)
    {
        if(board[row][col] != null)
            return false;
        board[row][col] = piece;
        return true;
    }

    public List<Pair<Integer,Integer>> getFreeCells()
    {
        List<Pair<Integer,Integer>> freeCells = new ArrayList<Pair<Integer,Integer>>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == null)
                {
                    Pair<Integer, Integer> pair = new Pair(i,j);
                    freeCells.add(pair);
                }
            }
        }
        return freeCells;
    }

    public void printBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] != null) {
                    System.out.print(" " + board[i][j].pieceType.name() + " ");
                } else {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
