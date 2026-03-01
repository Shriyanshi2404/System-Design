package InterviewQuestions.SplitWise;

import InterviewQuestions.SplitWise.BalanceSheet.BalanceSheetController;
import InterviewQuestions.SplitWise.Expense.ExpenseSplitType;
import InterviewQuestions.SplitWise.Expense.Split.Split;
import InterviewQuestions.SplitWise.Group.Group;
import InterviewQuestions.SplitWise.Group.GroupController;
import InterviewQuestions.SplitWise.User.User;
import InterviewQuestions.SplitWise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseAppDemo {

    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    public SplitwiseAppDemo() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {

        setupUserAndGroup();

        //Step1: add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        //Step2. create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("U1001"), 300);
        Split split2 = new Split(userController.getUser("U2001"), 300);
        Split split3 = new Split(userController.getUser("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp1001", "Breakfast", 900, splits, ExpenseSplitType.EQUAL, userController.getUser("U1001"));

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new Split(userController.getUser("U1001"), 400);
        Split splits2_2 = new Split(userController.getUser("U2001"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);
        group.createExpense("Exp1002", "Lunch", 500, splits2, ExpenseSplitType.UNEQUAL, userController.getUser("U2001"));

        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setupUserAndGroup() {

        //onboard user to splitwise app
        addUsersToSplitwiseApp();

        //create a group by user1
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing with Friends", user1);
    }

    private void addUsersToSplitwiseApp() {

        //adding User1
        User user1 = new User("U1001", "User1");

        //adding User2
        User user2 = new User("U2001", "User2");

        //adding User3
        User user3 = new User("U3001", "User3");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

    public static void main(String args[]){

        SplitwiseAppDemo splitwise = new SplitwiseAppDemo();
        splitwise.demo();
    }


    /**
     * Expense 1 - Breakfast (Equal Split):
     * Total: 900, Paid by: U1001
     * Split: U1001(300), U2001(300), U3001(300)

     * Expense 2 - Lunch (Unequal Split):
     * Total: 500, Paid by: U2001
     * Split: U1001(400), U2001(100)

     * Let me manually calculate what each user should have:
     * U1001 Analysis:
     * Paid: 900 (breakfast)
     * Owes: 300 (breakfast) + 400 (lunch) = 700 ✅
     * Gets Back: 300 (from U2001 for breakfast) + 300 (from U3001 for breakfast) = 600 ✅
     * Net Position: 900 paid - 700 owed = +200 (should get back 200 overall)
     * Individual Balances:
     * vs U2001: Gets back 300 (breakfast), owes 400 (lunch) → Net: owes 100 to U2001 ✅
     * vs U3001: Gets back 300 (breakfast), owes 0 → Net: gets back 300 from U3001 ✅


     * U2001 Analysis:
     * Paid: 500 (lunch)
     * Owes: 300 (breakfast) + 100 (lunch) = 400 ✅
     * Gets Back: 400 (from U1001 for lunch) = 400 ✅
     * Net Position: 500 paid - 400 owed = +100 (should get back 100 overall)
     * Individual Balances:
     * vs U1001: Gets back 400 (lunch), owes 300 (breakfast) → Net: gets back 100 from U1001


     * U3001 Analysis:
     * Paid: 0
     * Owes: 300 (breakfast) + 0 (not in lunch) = 300 ✅
     * Gets Back: 0 ✅
     * Net Position: 0 paid - 300 owed = -300 (owes 300 overall)
     * Individual Balances:
     * vs U1001: Gets back 0, owes 300 → Net: owes 300 to U1001 ✅
     */
}