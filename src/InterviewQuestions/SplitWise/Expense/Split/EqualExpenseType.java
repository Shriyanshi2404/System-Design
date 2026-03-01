package InterviewQuestions.SplitWise.Expense.Split;

import java.util.List;

public class EqualExpenseType implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        //validate total amount in splits of each user is equal and overall total equals to totalAmount or not
        double amountShouldBePresentForEachUser = totalAmount/splitList.size();
        for(Split split: splitList) {
            if(split.getAmountOwe() != amountShouldBePresentForEachUser) {
                //throw exception
            }
        }
    }
}
