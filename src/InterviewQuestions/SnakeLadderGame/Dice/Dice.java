package InterviewQuestions.SnakeLadderGame.Dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount)
    {
        this.diceCount = diceCount;
    }

    public int rollDice()
    {
        int totalSum = 0;
        int count = 0;
        while(count < diceCount)
        {
            totalSum += ThreadLocalRandom.current().nextInt(1, max+1); // if dice count is 2 suppose, then we will add a sum of two random numbers
            count++;
        }
        return totalSum;
    }
}
