package InterviewQuestions.SplitWise.BalanceSheet;

import InterviewQuestions.SplitWise.Expense.Split.Split;
import InterviewQuestions.SplitWise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    /**
     * 1. Fetching the balance sheet of User who paid for the expense and updating the totalPayment for that user
     * 2. Check for each user present in Split list
     *     - Fetch the balance sheet of oweUser along with get the owe amount of that oweUser
     *     - If oweUser and paid User is same --> then simply add the oweAmount into user's totalExpense
     *     - Else, add the oweAmount --> in the user's getBackAmount()
     * 3. Get the Balance (userOweBalance) of that paid user
     *    - See if the oweUser id is present in the map of userVsBalance of userBalancedSheet ?
     *    - if present, then userOweBalance we can get from map of userBalancedSheet
     *    - else we can put the oweUser id into map and userOweBalance can be a new object of Balance.
     *    - also update the userOweBalance with the current getBackAmount + oweAmount
     * 4. update the balance sheet of owe user
     *    - set totalExpense = current total expense + oweAmount
     *    - set totalOweAmount = current total owe amount + oweAmount
     * 5. Get the balance (userPaidBalance) of the owe user
     *    - See if the paid user id is present in the map of userVsBalance of oweUserBalancedSheet  ?
     *    - if present, then userPaidBalance we can get from map of oweUserBalancedSheet
     *    - else we can put the paid userId into map and userPaidBalance can be a new object of Balance.
     *    - also update the userPaidBalance with the current getOweAmount + oweAmount
     * @param user
     * @param splits
     * @param totalExpenseAmount
     */
    public void updateUserExpenseBalanceSheet(User user, List<Split> splits, double totalExpenseAmount){

        //update the total amount paid for the expense which is paid by user

        // get the balance sheet of user
        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();
        // set the totalPayment as current totalPayment + totalExpenseAmount
        userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split : splits) {

            User userOwe = split.getUser();
            double oweAmount = split.getAmountOwe();

            // if user who owes the amount is same as the user who paid the amount
            if(user.getUserId().equals(userOwe.getUserId())){
                userExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense()+oweAmount);
            }
            // if user who owes the amount is different from the user who paid for the expense, then owe amount is the getBack amount for paid user
            else {
                //update the balance of paid user
                userExpenseBalanceSheet.setTotalYouGetBack(userExpenseBalanceSheet.getTotalYouGetBack() + oweAmount);

                Balance userOweBalance;
                if(userExpenseBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {

                    userOweBalance = userExpenseBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else {
                    userOweBalance = new Balance();
                    userExpenseBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }

                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //update the balance sheet of owe user
                UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(user.getUserId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(user.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(user.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymentMade: " + userExpenseBalanceSheet.getTotalPayment());

        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userID = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }
        System.out.println("---------------------------------------");
    }
}
