package InterviewQuestions.TicTacToeGame.Player;

import InterviewQuestions.TicTacToeGame.PlayingPiece.PlayingPiece;

public class Player {
    private String name;
    private PlayingPiece piece;

    public Player(String name, PlayingPiece piece)
    {
        this.name = name;
        this.piece = piece;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public PlayingPiece getPiece()
    {
        return this.piece;
    }

    public void setPiece()
    {
        this.piece = piece;
    }
}
