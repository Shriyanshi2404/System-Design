package InterviewQuestions.CricBuzz.ScoreUpdator;

import InterviewQuestions.CricBuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
