package InterviewQuestions.SplitWise.Group;

import InterviewQuestions.SplitWise.Expense.Expense;
import InterviewQuestions.SplitWise.Expense.ExpenseController;
import InterviewQuestions.SplitWise.Expense.ExpenseSplitType;
import InterviewQuestions.SplitWise.Expense.Split.Split;
import InterviewQuestions.SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group()
    {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    //add member to group
    public void addMember(User member){
        groupMembers.add(member);
    }

    // creating an expense inside a particular group
    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
