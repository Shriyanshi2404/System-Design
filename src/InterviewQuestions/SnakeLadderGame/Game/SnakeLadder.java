package InterviewQuestions.SnakeLadderGame.Game;

import InterviewQuestions.SnakeLadderGame.Board.Board;
import InterviewQuestions.SnakeLadderGame.Cell.Cell;
import InterviewQuestions.SnakeLadderGame.Dice.Dice;
import InterviewQuestions.SnakeLadderGame.Player.Player;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeLadder {
    Dice dice;
    Deque<Player> playersList;
    Board board;
    Player winner;

    public SnakeLadder()
    {
        initialiseGame();
    }

    public void initialiseGame()
    {
        dice = new Dice(1);
        playersList = new LinkedList<>();
        winner = null;
        board = new Board(10, 5, 4);
        addPlayers();
    }

    public void addPlayers()
    {
        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0);
        playersList.add(p1);
        playersList.add(p2);
    }

    public void startGame()
    {
        while(winner == null)
        {
            // Find which player has the turn
            Player currentPlayer = findTurn(playersList);
            System.out.println("player turn is:" + currentPlayer.getId() + " current position is: " + currentPlayer.getCurrentPosition());

            // Roll the dice
            int diceNumber = dice.rollDice();

            // get the new position
            int playerNewPosition = currentPlayer.getCurrentPosition() + diceNumber;
            playerNewPosition = findJump(playerNewPosition); // // Find if there is any jump in new position
            currentPlayer.setCurrentPosition(playerNewPosition);

            System.out.println("player turn is:" + currentPlayer.getId() + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1)
                winner = currentPlayer;
        }
        System.out.println("Winner is: " + winner.getId());
    }

    private Player findTurn(Deque<Player> playersList)
    {
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }

    private int findJump(int position)
    {
        if(position > board.cells.length * board.cells.length-1 ){
            return position;
        }

        Cell cell = board.getCell(position);
        if(cell.getJumpObj() != null && cell.jump.getStartPos() == position)
        {
            String jumpBy = (cell.jump.getStartPos() < cell.jump.getEndPos())? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.getEndPos();
        }
        return position;
    }
}
