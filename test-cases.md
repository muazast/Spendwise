# SpendWise — Test Cases

All results below come from actually running `java Main.java` (Java 25) with the listed inputs. "Input" is the sequence of values typed at the prompts, in order.

---

## TC1: Normal budget and expense entries

**Input:** budget `5000`; expenses: `College Transport / 800 / 1`, `Online Course / 1200 / 3`, `Movie / 450 / 2`, `Groceries / 1500 / 1`; then `N`

**Expected:** all four expenses accepted; totals update after each entry; report shows Essentials 2300, Entertainment 450, Learning 1200; total 3950; remaining 1050; highest expense Groceries (1500); budget utilized 79%.

**Actual result:** Matches expected. Total after each expense was 800, 2000, 2450, 3950. Final report values as above, plus status `WITHIN BUDGET (CAUTION)` and a health score of 85/100. (See `sample-output.txt`.)

**Result:** PASS

---

## TC2: Invalid monthly budget (zero, negative, non-numeric)

**Input:** `0`, `-500`, `abc`, then `3000`; expense `Lunch / 200 / 1`; `N`

**Expected:** each invalid value is rejected with a message and the budget prompt repeats; `3000` is accepted.

**Actual result:** `0` and `-500` gave "Budget must be greater than zero. Try again." `abc` gave "Invalid input! Please enter a whole number." The program did not crash. `3000` was then accepted and the run continued normally.

**Result:** PASS

---

## TC3: Zero or negative expense amount

**Input:** budget `2000`; expense name `Bus Pass`; amounts `0`, `-50`, `abc`, then `300`; category `1`; `N`

**Expected:** invalid amounts rejected; the expense is only recorded once `300` is entered; total spent is 300, not 250 or 0.

**Actual result:** `0` and `-50` gave "Amount must be greater than zero. Try again." `abc` gave "Invalid input! Please enter a whole number." After `300`, total spent showed Rs. 300 and remaining Rs. 1700. Expense count in the report was 1.

**Result:** PASS

---

## TC4: Invalid category

**Input:** budget `2000`; expense `Netflix / 199`; categories `7`, `0`, `abc`, then `2`; `N`

**Expected:** `7`, `0` and `abc` rejected; the expense is stored under Entertainment only after `2`.

**Actual result:** `7` and `0` gave "Invalid category! Please enter 1, 2 or 3." `abc` gave "Invalid input! Please enter 1, 2 or 3." After `2`, the report showed Entertainment Rs. 199 and Essentials/Learning Rs. 0.

**Result:** PASS

---

## TC5: Spending crossing the 75% threshold (exactly 75%)

**Input:** budget `1000`; expenses `Rent Share / 700 / 1` then `Books / 50 / 3`; `N`

**Expected:** no warning after 700 (70%); warning appears after 750 (exactly 75%); status shows caution, not over budget.

**Actual result:** No warning after the first expense. After the second expense the program printed "WARNING: You have used 75% or more of your monthly budget!" with total 750 and remaining 250. Final report: Budget Utilized 75%, Status `WITHIN BUDGET (CAUTION)`.

**Result:** PASS

---

## TC6: Spending exceeding the monthly budget

**Input:** budget `1000`; expenses `Phone Repair / 600 / 1` then `Concert / 700 / 2`; `N`

**Expected:** no alert after 600; after 1300 an over-budget alert showing the excess (300) and a negative remaining balance; final status `OVER BUDGET`.

**Actual result:** After the second expense the program printed "ALERT: You have EXCEEDED your monthly budget by Rs. 300!" with Total Spent Rs. 1300 and Remaining Budget Rs. -300. Report: Budget Utilized 130%, Status `OVER BUDGET`, health score 10/100 (CRITICAL) with advice to cut Rs. 300 next month.

**Result:** PASS

---

## TC7: Blank expense name and invalid Y/N answer

**Input:** budget `1000`; expense name left blank, then `Notes`; amount `100`; category `3`; at "Add another expense?" type `maybe`, then `y`; second expense `Snacks / 50 / 1`; then `n`

**Expected:** blank name rejected; `maybe` rejected and the prompt repeats; lowercase `y` and `n` are accepted.

**Actual result:** "Expense name cannot be empty." appeared and the prompt repeated. `maybe` gave "Please enter Y or N." Lowercase `y` continued to a second expense and lowercase `n` ended the session and printed the report (2 expenses, total Rs. 150).

**Result:** PASS
