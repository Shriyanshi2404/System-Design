package InterviewQuestions.SnakeLadderGame;

import InterviewQuestions.SnakeLadderGame.Game.SnakeLadder;

public class MainClass {

    public static void main(String[] args)
    {
        SnakeLadder snakeLadder = new SnakeLadder();
        snakeLadder.initialiseGame();
        snakeLadder.startGame();
    }
}
