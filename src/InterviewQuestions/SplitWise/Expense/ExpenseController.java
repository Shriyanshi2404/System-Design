package InterviewQuestions.SplitWise.Expense;

import InterviewQuestions.SplitWise.BalanceSheet.BalanceSheetController;
import InterviewQuestions.SplitWise.Expense.Split.ExpenseSplit;
import InterviewQuestions.SplitWise.Expense.Split.Split;
import InterviewQuestions.SplitWise.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController()
    {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        // creating a new expense
        Expense newExpense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);
        // updating the balance sheet for particular user since new expense is created
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return newExpense;
    }
}

