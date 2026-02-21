package InterviewQuestions.SnakeLadderGame.Player;

public class Player {
    String id;
    int currentPosition;

    public Player(String id, int pos)
    {
        this.id = id;
        this.currentPosition = pos;
    }

    public String getId()
    {
        return this.id;
    }

    public int getCurrentPosition()
    {
        return this.currentPosition;
    }

    public void setCurrentPosition(int newPosition)
    {
        this.currentPosition = newPosition;
    }
}
