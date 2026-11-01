void main() {
    Scanner scanner = new Scanner(System.in);

    IO.println("========================================");
    IO.println("             SPENDWISE");
    IO.println("     SMART STUDENT BUDGET ANALYZER");
    IO.println("========================================");
    IO.println();

    int monthlyBudget;
    while (true) {
        IO.print("Enter your monthly budget: ");
        if (!scanner.hasNextInt()) {
            IO.println("Invalid input! Please enter a whole number.");
            scanner.nextLine();
            continue;
        }
        monthlyBudget = scanner.nextInt();
        scanner.nextLine();
        if (monthlyBudget <= 0) {
            IO.println("Budget must be greater than zero. Try again.");
            continue;
        }
        break;
    }
    IO.println();
    IO.println("Budget successfully set to Rs. " + monthlyBudget);

    int totalSpent = 0;
    int remainingBudget = monthlyBudget;
    int expenseCount = 0;
    int essentialsTotal = 0;
    int entertainmentTotal = 0;
    int learningTotal = 0;
    String highestExpenseName = "";
    int highestExpenseAmount = 0;
    String anotherExpense;

    do {
        IO.println();
        IO.println("----------------------------------------");
        IO.println("             ADD EXPENSE");
        IO.println("----------------------------------------");
        IO.println();

        String expenseName;
        while (true) {
            IO.print("Enter expense name: ");
            expenseName = scanner.nextLine().trim();
            if (expenseName.isEmpty()) {
                IO.println("Expense name cannot be empty.");
                continue;
            }
            break;
        }

        int expenseAmount;
        while (true) {
            IO.print("Enter expense amount: ");
            if (!scanner.hasNextInt()) {
                IO.println("Invalid input! Please enter a whole number.");
                scanner.nextLine();
                continue;
            }
            expenseAmount = scanner.nextInt();
            scanner.nextLine();
            if (expenseAmount <= 0) {
                IO.println("Amount must be greater than zero. Try again.");
                continue;
            }
            break;
        }

        IO.println();
        IO.println("Select expense category:");
        IO.println("1. Essentials");
        IO.println("2. Entertainment");
        IO.println("3. Learning");
        IO.println();

        int category;
        while (true) {
            IO.print("Enter category choice: ");
            if (!scanner.hasNextInt()) {
                IO.println("Invalid input! Please enter 1, 2 or 3.");
                scanner.nextLine();
                continue;
            }
            category = scanner.nextInt();
            scanner.nextLine();
            if (category < 1 || category > 3) {
                IO.println("Invalid category! Please enter 1, 2 or 3.");
                continue;
            }
            break;
        }

        if (category == 1) {
            essentialsTotal += expenseAmount;
        } else if (category == 2) {
            entertainmentTotal += expenseAmount;
        } else {
            learningTotal += expenseAmount;
        }

        totalSpent += expenseAmount;
        remainingBudget = monthlyBudget - totalSpent;
        expenseCount++;

        if (expenseAmount > highestExpenseAmount) {
            highestExpenseAmount = expenseAmount;
            highestExpenseName = expenseName;
        }

        IO.println();
        IO.println("Expense added successfully!");
        IO.println();

        double percentUsed = totalSpent * 100.0 / monthlyBudget;

        if (totalSpent > monthlyBudget) {
            IO.println("ALERT: You have EXCEEDED your monthly budget by Rs. " + (-remainingBudget) + "!");
            IO.println();
        } else if (percentUsed >= 75) {
            IO.println("WARNING: You have used 75% or more");
            IO.println("of your monthly budget!");
            IO.println();
        }

        IO.println("Total Spent: Rs. " + totalSpent);
        IO.println("Remaining Budget: Rs. " + remainingBudget);
        IO.println();
        IO.println("----------------------------------------");

        // Y/N validation
        while (true) {
            IO.print("Add another expense? (Y/N): ");
            anotherExpense = scanner.nextLine().trim();
            if (anotherExpense.equalsIgnoreCase("Y") || anotherExpense.equalsIgnoreCase("N")) {
                break;
            }
            IO.println("Please enter Y or N.");
        }

    } while (anotherExpense.equalsIgnoreCase("Y"));

    // ---------- E. FINAL REPORT ----------
    double finalPercent = totalSpent * 100.0 / monthlyBudget;
    int budgetUtilized = (int) finalPercent; // type casting

    IO.println();
    IO.println("========================================");
    IO.println("           MONTHLY REPORT");
    IO.println("========================================");
    IO.println();
    IO.println("Monthly Budget       : Rs. " + monthlyBudget);
    IO.println("Total Expenses       : " + expenseCount);
    IO.println("Total Amount Spent   : Rs. " + totalSpent);
    IO.println("Remaining Budget     : Rs. " + remainingBudget);
    IO.println();
    IO.println("----------------------------------------");
    IO.println("         CATEGORY-WISE SPENDING");
    IO.println("----------------------------------------");
    IO.println();
    IO.println("Essentials           : Rs. " + essentialsTotal);
    IO.println("Entertainment        : Rs. " + entertainmentTotal);
    IO.println("Learning             : Rs. " + learningTotal);
    IO.println();
    IO.println("----------------------------------------");
    IO.println("          SPENDING INSIGHTS");
    IO.println("----------------------------------------");
    IO.println();
    IO.println("Highest Expense      : " + highestExpenseName);
    IO.println("Highest Amount       : Rs. " + highestExpenseAmount);
    IO.println();
    IO.println("Budget Utilized      : " + budgetUtilized + "%");
    IO.println();

    if (totalSpent > monthlyBudget) {
        IO.println("Status               : OVER BUDGET");
    } else if (finalPercent >= 75) {
        IO.println("Status               : WITHIN BUDGET (CAUTION)");
    } else {
        IO.println("Status               : WITHIN BUDGET");
    }


    double essentialsShare = essentialsTotal * 100.0 / monthlyBudget;
    double entertainmentShare = entertainmentTotal * 100.0 / monthlyBudget;
    double learningShare = learningTotal * 100.0 / monthlyBudget;

    int healthScore = 100;
    String advice = "";

    if (totalSpent > monthlyBudget) {
        healthScore -= 40;
        advice += "- You overspent. Cut Rs. " + (-remainingBudget) + " from next month's plan.\n";
    } else if (finalPercent >= 75) {
        healthScore -= 15;
        advice += "- You used over 75% of your budget. Leave a bigger safety cushion.\n";
    }
    if (essentialsShare > 50) {
        healthScore -= 15;
        advice += "- Essentials take over 50% of your budget. Look for cheaper alternatives.\n";
    }
    if (entertainmentShare > 30) {
        healthScore -= 25;
        advice += "- Entertainment is over 30% of your budget. Trim non-essential fun.\n";
    }
    if (learningShare < 10) {
        healthScore -= 10;
        advice += "- Learning is under 10% of your budget. Invest a little more in skills.\n";
    }

    String healthRating;
    if (healthScore >= 80) {
        healthRating = "EXCELLENT - Smart Saver";
    } else if (healthScore >= 60) {
        healthRating = "GOOD - Mostly Balanced";
    } else if (healthScore >= 40) {
        healthRating = "NEEDS ATTENTION";
    } else {
        healthRating = "CRITICAL - Rethink Your Spending";
    }

    IO.println();
    IO.println("----------------------------------------");
    IO.println("       SMART BUDGET HEALTH CHECK");
    IO.println("----------------------------------------");
    IO.println();
    IO.println("Essentials share     : " + (int) essentialsShare + "% (limit 50%)");
    IO.println("Entertainment share  : " + (int) entertainmentShare + "% (limit 30%)");
    IO.println("Learning share       : " + (int) learningShare + "% (goal 10%+)");
    IO.println();
    IO.println("Health Score         : " + healthScore + "/100");
    IO.println("Rating               : " + healthRating);
    IO.println();
    if (advice.isEmpty()) {
        IO.println("Advice: Great balance! Keep it up.");
    } else {
        IO.println("Advice:");
        IO.print(advice);
    }

    IO.println();
    IO.println("========================================");
    IO.println("     THANK YOU FOR USING SPENDWISE!");
    IO.println("========================================");
}
