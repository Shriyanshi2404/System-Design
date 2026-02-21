package InterviewQuestions.SnakeLadderGame.Board;

import InterviewQuestions.SnakeLadderGame.Cell.Cell;
import InterviewQuestions.SnakeLadderGame.Dice.Dice;
import InterviewQuestions.SnakeLadderGame.Jump.Jump;
import InterviewQuestions.SnakeLadderGame.Player.Player;

import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    public Cell[][] cells;

    public Board(int size, int numberOfSnakes, int numberOfLadders)
    {
        initialiseBoard(size);
        addSnakeLadders(numberOfSnakes, numberOfLadders, cells);
    }

    public void initialiseBoard(int size)
    {
        cells = new Cell[size][size];
        for(int i=0;i< cells.length;i++)
        {
            for(int j=0;j< cells.length;j++)
            {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }

    }

    public void addSnakeLadders(int numberOfSnakes, int numberOfLadders, Cell[][] cells)
    {
        while(numberOfSnakes != 0)
        {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            if(end >= start)
                continue;

            Jump snakeObj = new Jump(start, end);
            snakeObj.setStartPos(start);
            snakeObj.setEndPos(end);;

            Cell cell = getCell(start);
            cell.setJumpObj(snakeObj); // set the jump in specific cell if applicable

            numberOfSnakes--;
        }
        while(numberOfLadders != 0)
        {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            if(start >= end)
                continue;

            Jump ladderObj = new Jump(start, end);
            ladderObj.setStartPos(start);
            ladderObj.setEndPos(end);

            Cell cell = getCell(start);
            cell.setJumpObj(ladderObj); // set the jump in specific cell if applicable

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition)
    {
        int row = playerPosition / cells.length;
        int col = playerPosition % cells.length;
        return cells[row][col];
    }
}
