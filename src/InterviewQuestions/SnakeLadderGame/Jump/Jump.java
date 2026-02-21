package InterviewQuestions.SnakeLadderGame.Jump;

public class Jump {
    int startPos;
    int endPos;

    public Jump(int pos1, int pos2)
    {
        this.startPos = pos1;
        this.endPos = pos2;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public int getEndPos() {
        return this.endPos;
    }

    public void setStartPos(int start)
    {
        this.startPos = start;
    }

    public void setEndPos(int end)
    {
        this.endPos = end;
    }

}
