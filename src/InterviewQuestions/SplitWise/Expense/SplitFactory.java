package InterviewQuestions.SplitWise.Expense;

import InterviewQuestions.SplitWise.Expense.Split.EqualExpenseType;
import InterviewQuestions.SplitWise.Expense.Split.ExpenseSplit;
import InterviewQuestions.SplitWise.Expense.Split.PercentageExpenseType;
import InterviewQuestions.SplitWise.Expense.Split.UnequalExpenseType;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType)
    {
        switch (splitType) {
            case EQUAL :
                return new EqualExpenseType();
            case UNEQUAL :
                return new UnequalExpenseType();
            case PERCENTAGE :
                return new PercentageExpenseType();
            default:
                return null;
        }
    }
}
