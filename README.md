# SpendWise — Smart Student Budget & Expense Analyzer

A console-based Java 25 application that helps students track their monthly budget, record categorized expenses, and understand their spending habits.

## Problem Statement

Students usually get a fixed monthly allowance but rarely track where it goes. Small expenses such as transport, food, entertainment, subscriptions and online courses add up and quietly eat a large part of the budget. SpendWise lets a user enter a monthly budget, record any number of expenses, and get a final report showing whether they stayed within budget and how balanced their spending was.

## Why I Built This

<!-- TODO: write 2-3 sentences in your own words. Example angle: your own experience tracking (or failing to track) money as a student, and why a simple tool that gives instant feedback would have helped. -->

## Features Implemented

- **Budget setup** with validation (zero, negative and non-numeric values are rejected)
- **Unlimited expense entry** in a loop, with no restart needed
- **Three categories:** Essentials, Entertainment, Learning, each with its own running total
- **Live budget monitoring** after every expense: total spent and remaining budget
- **75% warning** when spending reaches or crosses 75% of the budget
- **Over-budget alert** showing exactly how much the budget was exceeded
- **Final monthly report:** budget, expense count, total spent, remaining balance, category totals, highest expense (name and amount), budget utilized (%), and final status
- **Input validation** for budget, expense name (not blank), amount, category and the Y/N prompt. Invalid input never counts as a successful expense.
- **Unique feature:** Smart Budget Health Check (below)

## Technologies and Java Concepts Used

- Java 25 compact source file (no class declaration) with `IO.print()` / `IO.println()`
- Variables and data types: `int`, `double`, `String`
- Type conversion / casting: `(int)` cast to turn a `double` percentage into a whole number
- Arithmetic, relational and logical operators
- `if`, `else if`, `else`, including nested conditionals
- `while`, `do-while` loops
- `break` and `continue` for input-retry logic
- `Scanner` with `hasNextInt()` to validate numeric input without crashing
- String handling: `trim()`, `isEmpty()`, `equalsIgnoreCase()`, string concatenation

No arrays, user-defined methods, file handling or GUI were used, as the assignment requires.

## How to Run

Requires **JDK 25** or newer.

```bash
git clone https://github.com/<your-username>/SpendWise.git
cd SpendWise
java Main.java
```

(Java 25 can run a single source file directly, so there is no separate compile step.)

## Unique Feature: Smart Budget Health Check

After the standard report, SpendWise scores the user's spending habits **out of 100** and gives targeted advice.

**How it works:** it starts at 100 and subtracts points for each rule broken.

| Rule | Penalty |
| --- | --- |
| Total spending exceeds the budget | -40 |
| Total spending is 75% or more of the budget (and not over) | -15 |
| Essentials are more than 50% of the budget | -15 |
| Entertainment is more than 30% of the budget | -25 |
| Learning is less than 10% of the budget | -10 |

**Rating from the final score:**

| Score | Rating |
| --- | --- |
| 80-100 | EXCELLENT - Smart Saver |
| 60-79 | GOOD - Mostly Balanced |
| 40-59 | NEEDS ATTENTION |
| 0-39 | CRITICAL - Rethink Your Spending |

Each broken rule also adds one line of specific advice (for example, the exact amount to cut next month when over budget). The category shares are calculated as `categoryTotal * 100.0 / monthlyBudget` and displayed with an `(int)` cast.

**Why these thresholds:** they are simple rules of thumb for a student budget (needs first, limited entertainment, some investment in learning) and are easy to change in the code.

## Screenshots

<!-- TODO: add your own screenshots here after running the program, for example:
![Normal run](screenshots/normal-run.png)
![Over budget](screenshots/over-budget.png)
-->

## Files

- `Main.java` — the application
- `sample-output.txt` — a complete successful run
- `test-cases.md` — documented test cases
