# Splitwise Application - UML Class Diagram

```plantuml
@startuml SplitWise Class Diagram

!theme plain
skinparam backgroundColor #f9f9f9
skinparam class {
    BackgroundColor #ffffff
    BorderColor #333333
    ArrowColor #333333
}

' Core User Management
class User {
    - String userId
    - String userName
    - UserExpenseBalanceSheet userExpenseBalanceSheet
    --
    + User(String id, String name)
    + String getUserId()
    + UserExpenseBalanceSheet getUserExpenseBalanceSheet()
}

' Balance Management
class UserExpenseBalanceSheet {
    - Map<String, Balance> userVsBalance
    - double totalYourExpense
    - double totalPayment
    - double totalYouOwe
    - double totalYouGetBack
    --
    + UserExpenseBalanceSheet()
    + Map<String, Balance> getUserVsBalance()
    + double getTotalYourExpense()
    + void setTotalYourExpense(double)
    + double getTotalYouOwe()
    + void setTotalYouOwe(double)
    + double getTotalYouGetBack()
    + void setTotalYouGetBack(double)
    + double getTotalPayment()
    + void setTotalPayment(double)
}

class Balance {
    - double amountOwe
    - double amountGetBack
    --
    + double getAmountOwe()
    + void setAmountOwe(double)
    + double getAmountGetBack()
    + void setAmountGetBack(double)
}

' Expense Management
class Expense {
    - String expenseId
    - String description
    - double expenseAmount
    - List<Split> splitDetails
    - ExpenseSplitType splitType
    - User paidByUser
    --
    + Expense(String expenseId, double expenseAmount, String description,
              User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails)
}

enum ExpenseSplitType {
    EQUAL
    UNEQUAL
    PERCENTAGE
}

class Split {
    - User user
    - double amountOwe
    --
    + Split(User user, double amountOwe)
    + User getUser()
    + void setUser(User user)
    + double getAmountOwe()
    + void setAmountOwe(double)
}

' Group Management
class Group {
    - String groupId
    - String groupName
    - List<User> groupMembers
    - List<Expense> expenseList
    - ExpenseController expenseController
    --
    + Group()
    + String getGroupId()
    + void setGroupId(String)
    + void setGroupName(String)
    + String getGroupName()
    + void addMember(User member)
    + Expense createExpense(String expenseId, String description, 
                           double expenseAmount, List<Split> splitDetails, 
                           ExpenseSplitType splitType, User paidByUser)
}

' Controllers
class ExpenseController {
    - BalanceSheetController balanceSheetController
    --
    + ExpenseController()
    + Expense createExpense(String expenseId, String description, 
                           double expenseAmount, List<Split> splitDetails, 
                           ExpenseSplitType splitType, User paidByUser)
}

class BalanceSheetController {
    --
    + void updateUserExpenseBalanceSheet(User user, List<Split> splits, 
                                        double totalExpenseAmount)
    + void showBalanceSheetOfUser(User user)
}

class UserController {
    - List<User> usersList
    --
    + UserController()
    + void addUser(User user)
    + User getUser(String userId)
    + List<User> getAllUsers()
}

class GroupController {
    - List<Group> groupList
    --
    + GroupController()
    + void createGroup(String groupId, String groupName, List<User> groupMembers)
    + Group getGroup(String groupId)
}

' Strategy Pattern for Split Types
abstract class ExpenseSplit {
    {abstract} + void validateSplitRequest(List<Split> splitDetails, double totalAmount)
}

class EqualExpenseType extends ExpenseSplit {
    + void validateSplitRequest(List<Split> splitDetails, double totalAmount)
}

class UnequalExpenseType extends ExpenseSplit {
    + void validateSplitRequest(List<Split> splitDetails, double totalAmount)
}

class PercentageExpenseType extends ExpenseSplit {
    + void validateSplitRequest(List<Split> splitDetails, double totalAmount)
}

class SplitFactory {
    + {static} ExpenseSplit getSplitObject(ExpenseSplitType splitType)
}

' Demo Application
class SplitwiseAppDemo {
    + {static} void main(String[] args)
    + void demo()
}

' Relationships
User ||--|| UserExpenseBalanceSheet : "has"
UserExpenseBalanceSheet ||--o{ Balance : "contains"
User ||--o{ Split : "participates in"
Expense ||--o{ Split : "contains"
Expense ||--|| ExpenseSplitType : "uses"
Expense ||--|| User : "paidBy"
Group ||--o{ User : "contains"
Group ||--o{ Expense : "manages"
Group ||--|| ExpenseController : "uses"

ExpenseController ||--|| BalanceSheetController : "uses"
ExpenseController ..> SplitFactory : "uses"
ExpenseController ..> ExpenseSplit : "uses"

SplitFactory ..> EqualExpenseType : "creates"
SplitFactory ..> UnequalExpenseType : "creates"
SplitFactory ..> PercentageExpenseType : "creates"

SplitwiseAppDemo ..> UserController : "uses"
SplitwiseAppDemo ..> GroupController : "uses"
SplitwiseAppDemo ..> BalanceSheetController : "uses"

UserController ||--o{ User : "manages"
GroupController ||--o{ Group : "manages"

' Notes
note right of BalanceSheetController
  **Key Responsibilities:**
  1. Updates user balance sheets when expenses are created
  2. Tracks who owes whom and how much
  3. Maintains individual user-to-user balances
  4. Displays comprehensive balance reports
end note

note right of ExpenseSplit
  **Strategy Pattern Implementation:**
  - Different splitting strategies (Equal, Unequal, Percentage)
  - Factory creates appropriate strategy based on type
  - Each strategy validates split requests differently
end note

note bottom of User
  **Core Entity:**
  Each user has their own balance sheet
  tracking all expenses and settlements
end note

@enduml
```

## Key Design Patterns Used

### 1. **Strategy Pattern**
- `ExpenseSplit` (abstract strategy)
- `EqualExpenseType`, `UnequalExpenseType`, `PercentageExpenseType` (concrete strategies)
- `SplitFactory` (factory for strategy creation)

### 2. **Factory Pattern**
- `SplitFactory` creates appropriate splitting strategy based on `ExpenseSplitType`

### 3. **MVC Pattern**
- **Model**: `User`, `Expense`, `Group`, `Balance`, `Split`
- **Controller**: `ExpenseController`, `BalanceSheetController`, `UserController`, `GroupController`
- **View**: Console output via `showBalanceSheetOfUser()`

## Core Functionality Flow

1. **User Creation**: Users are created and managed by `UserController`
2. **Group Formation**: Groups are created with multiple users via `GroupController`
3. **Expense Creation**: 
   - Group creates expense through `ExpenseController`
   - Appropriate split strategy is selected using `SplitFactory`
   - Split validation is performed
   - Balance sheets are updated via `BalanceSheetController`
4. **Balance Tracking**: 
   - Individual user balances are maintained
   - User-to-user relationships are tracked
   - Comprehensive balance reports are generated

## Key Classes Relationships

- **User ↔ UserExpenseBalanceSheet**: One-to-one composition
- **UserExpenseBalanceSheet ↔ Balance**: One-to-many (tracks balances with different users)
- **Expense ↔ Split**: One-to-many (expense is split among multiple users)
- **Group ↔ User/Expense**: One-to-many (group contains users and manages expenses)
- **Controllers**: Orchestrate business logic and coordinate between entities

This design ensures proper separation of concerns, extensibility for new split types, and maintains accurate financial tracking between users.
