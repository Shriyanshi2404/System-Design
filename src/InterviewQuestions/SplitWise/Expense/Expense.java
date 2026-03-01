package InterviewQuestions.SplitWise.Expense;

import InterviewQuestions.SplitWise.Expense.Split.Split;
import InterviewQuestions.SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    List<Split> splitDetails;
    ExpenseSplitType splitType;
    User paidByUser;

    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = new ArrayList<>();
        if (splitDetails != null) {
            this.splitDetails.addAll(splitDetails);
        }
    }
}
