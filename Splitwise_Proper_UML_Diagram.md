# Splitwise Application - Proper UML Class Diagram

```
                                   SPLITWISE APPLICATION UML CLASS DIAGRAM
                                              (Has-A & Is-A Relationships)

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                            CORE ENTITIES                                                    │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

                    ┌───────────────────┐      1     1    ┌─────────────────────────┐      1     *    ┌─────────────────┐
                    │       User        │◆────────────────│  UserExpenseBalanceSheet │◆────────────────│    Balance      │
                    ├───────────────────┤                 ├─────────────────────────┤                 ├─────────────────┤
                    │ - userId: String  │                 │ - userVsBalance: Map    │                 │ - amountOwe     │
                    │ - userName: String│                 │ - totalYourExpense      │                 │ - amountGetBack │
                    ├───────────────────┤                 │ - totalPayment          │                 ├─────────────────┤
                    │ + getUserId()     │                 │ - totalYouOwe           │                 │ + getAmountOwe()│
                    │ + getBalanceSheet│                 │ - totalYouGetBack       │                 │ + setAmountOwe()│
                    └───────────────────┘                 ├─────────────────────────┤                 │ + getAmountGet  │
                                                          │ + getTotalExpense()     │                 │   Back()        │
                                                          │ + setTotalExpense()     │                 │ + setAmountGet  │
                                                          │ + getTotalPayment()     │                 │   Back()        │
                                                          │ + setTotalPayment()     │                 └─────────────────┘
                                                          │ + getTotalYouOwe()      │                 
                                                          │ + setTotalYouOwe()      │                 
                                                          │ + getTotalYouGetBack()  │                 
                                                          │ + setTotalYouGetBack()  │                 
                                                          └─────────────────────────┘                 

                    ┌───────────────────┐      1     *    ┌─────────────────────────┐      *     1    ┌─────────────────┐
                    │      Expense      │◆────────────────│         Split           │◆────────────────│      User       │
                    ├───────────────────┤                 ├─────────────────────────┤                 │   (reference)   │
                    │ - expenseId       │                 │ - user: User            │                 └─────────────────┘
                    │ - description     │                 │ - amountOwe: double     │
                    │ - expenseAmount   │                 ├─────────────────────────┤
                    │ - splitDetails    │                 │ + getUser()             │
                    │ - splitType       │────────────────▶│ + getAmountOwe()        │
                    │ - paidByUser      │                 │ + setUser()             │
                    ├───────────────────┤                 │ + setAmountOwe()        │
                    │ + Expense()       │                 └─────────────────────────┘
                    └───────────────────┘
                            │
                            │ uses
                            ▼
                    ┌───────────────────┐
                    │ ExpenseSplitType  │
                    ├───────────────────┤
                    │ • EQUAL           │
                    │ • UNEQUAL         │
                    │ • PERCENTAGE      │
                    └───────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                         GROUP MANAGEMENT                                                    │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

                    ┌───────────────────┐      *     *    ┌─────────────────────────┐
                    │       User        │◆────────────────│         Group           │
                    │   (reference)     │                 ├─────────────────────────┤
                    └───────────────────┘                 │ - groupId: String       │
                                                          │ - groupName: String     │
                                                          │ - groupMembers: List    │
                    ┌───────────────────┐      1     *    │ - expenseList: List     │
                    │      Expense      │◆────────────────│ - expenseController     │
                    │   (reference)     │                 ├─────────────────────────┤
                    └───────────────────┘                 │ + addMember()           │
                                                          │ + createExpense()       │
                                                          │ + getGroupId()          │
                                                          │ + setGroupName()        │
                                                          └─────────────────────────┘
                                                                    │
                                                                    │ uses
                                                                    ▼
                                                          ┌─────────────────────────┐
                                                          │   ExpenseController     │
                                                          │     (reference)         │
                                                          └─────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                           CONTROLLERS                                                       │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

    ┌───────────────────┐      1     1    ┌─────────────────────────┐      *     1    ┌─────────────────┐
    │ ExpenseController │◆────────────────│  BalanceSheetController │◆────────────────│      User       │
    ├───────────────────┤                 ├─────────────────────────┤                 │   (manages)     │
    │ - balanceSheet    │                 │                         │                 └─────────────────┘
    │   Controller      │                 │                         │
    ├───────────────────┤                 ├─────────────────────────┤
    │ + createExpense() │                 │ + updateUserExpense     │
    └───────────────────┘                 │   BalanceSheet()        │
            │                             │ + showBalanceSheet      │
            │ uses                        │   OfUser()              │
            ▼                             └─────────────────────────┘
    ┌───────────────────┐
    │   SplitFactory    │
    │   (reference)     │
    └───────────────────┘

    ┌───────────────────┐      *     1    ┌─────────────────────────┐      *     1    ┌─────────────────┐
    │  UserController   │◆────────────────│         User            │       │         │      Group      │
    ├───────────────────┤                 │      (manages)          │       │         │   (manages)     │
    │ - usersList       │                 └─────────────────────────┘       │         └─────────────────┘
    ├───────────────────┤                                                   │                 ▲
    │ + addUser()       │                 ┌─────────────────────────┐       │                 │
    │ + getUser()       │                 │   GroupController       │◆──────┘                 │
    │ + getAllUsers()   │                 ├─────────────────────────┤                         │
    └───────────────────┘                 │ - groupList             │                         │
                                          ├─────────────────────────┤                         │
                                          │ + createGroup()         │                         │
                                          │ + getGroup()            │                         │
                                          └─────────────────────────┘                         │
                                                    │                                         │
                                                    └─────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                        STRATEGY PATTERN                                                     │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

                                          ┌─────────────────────────┐
                                          │    ExpenseSplit         │
                                          │     <<abstract>>        │
                                          ├─────────────────────────┤
                                          │ + validateSplitRequest  │
                                          │   (splits, amount)      │
                                          └─────────────────────────┘
                                                       ▲
                                                       │ IS-A
                                        ┌──────────────┼──────────────┐
                                        │              │              │
                            ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
                            │ EqualExpense    │ │ UnequalExpense  │ │ PercentageExp   │
                            │     Type        │ │     Type        │ │   enseType      │
                            ├─────────────────┤ ├─────────────────┤ ├─────────────────┤
                            │ + validateSplit │ │ + validateSplit │ │ + validateSplit │
                            │   Request()     │ │   Request()     │ │   Request()     │
                            └─────────────────┘ └─────────────────┘ └─────────────────┘
                                        ▲              ▲              ▲
                                        │              │              │
                                        └──────────────┼──────────────┘
                                                       │ creates
                                                       ▼
                                          ┌─────────────────────────┐
                                          │    SplitFactory         │
                                          ├─────────────────────────┤
                                          │ + getSplitObject        │
                                          │   (splitType)           │
                                          └─────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                      MAIN APPLICATION                                                       │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

                                          ┌─────────────────────────┐
                                          │  SplitwiseAppDemo       │
                                          ├─────────────────────────┤
                                          │ + main(String[])        │
                                          │ + demo()                │
                                          └─────────────────────────┘
                                                       │
                                                       │ uses
                                                       ▼
                          ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
                          │ UserController  │    │ GroupController │    │ BalanceSheet    │
                          │  (reference)    │    │  (reference)    │    │   Controller    │
                          └─────────────────┘    └─────────────────┘    │  (reference)    │
                                                                        └─────────────────┘

══════════════════════════════════════════════════════════════════════════════════════════════════════════════
                                           RELATIONSHIP LEGEND
══════════════════════════════════════════════════════════════════════════════════════════════════════════════

◆─────────    Composition (HAS-A) - Strong ownership, child cannot exist without parent
▲             Inheritance (IS-A) - Child class extends parent class  
─────────▶    Association - Uses or depends on
*             Many (0 or more)
1             One (exactly 1)

KEY RELATIONSHIPS:
• User HAS-A UserExpenseBalanceSheet (composition)
• UserExpenseBalanceSheet HAS-A Map<String, Balance> (composition)  
• Expense HAS-A List<Split> (composition)
• Split HAS-A User (association/reference)
• Group HAS-A List<User> and List<Expense> (composition)
• EqualExpenseType IS-A ExpenseSplit (inheritance)
• UnequalExpenseType IS-A ExpenseSplit (inheritance)  
• PercentageExpenseType IS-A ExpenseSplit (inheritance)
• ExpenseController HAS-A BalanceSheetController (composition)
• Controllers manage their respective entities (composition/association)
```
