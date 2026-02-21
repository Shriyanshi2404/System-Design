package InterviewQuestions.TicTacToeGame;

public class PlayGame {
    public static void main(String[] args)
    {
        TicTacToeGame game = new TicTacToeGame();
        game.initialiseGame();
        GameStatus status = game.startGame();
        switch (status) {
            case WIN :
                System.out.println("Won the game");
                break;
            case DRAW:
                System.out.println("It's a DRAW");
                break;
            default:
                System.out.print("Game Ends");
                break;
        }
    }
}
