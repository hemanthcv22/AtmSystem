## ATM System Project 🏧

### Overview
This Java application simulates an ATM system where users can perform operations like deposit, withdraw, check balance, and view transaction history using a graphical user interface (GUI) built with JavaFX.

### Features
- **Authorization:** Users enter a PIN to access the ATM.
- **Deposit:** Add funds to the account.
- **Withdraw:** Deduct funds, with checks for sufficient balance.
- **Balance Inquiry:** Display current account balance.
- **Transaction History:** View recent transactions.

### How to Use
1. **Authorization:** Enter PIN and press "Done".
2. **Options:** Choose actions like Deposit, Withdraw, Balance Inquiry, or Transaction History.
3. **Transactions:** Enter amounts and press "Done" for deposit/withdraw.
4. **History:** Navigate through recent transactions using "Previous" and "Next" buttons.

### Implementation
- **Classes:** `ATM`, `Transaction`, `AtmApplication`.
- **GUI:** JavaFX used for interactive interface.
- **Security:** PIN-based authorization (`creditCardNumber = "5483"` for demo).
- **Transaction Handling:** History stored in an `ArrayList`.

### Run the Application
- Compile and run `AtmApplication.java`.
- JavaFX libraries required for GUI components.

### Notes
- Demo PIN: `5483` grants access.
- GUI designed for usability with transaction feedback.

Enjoy managing your virtual ATM transactions with this application!

---

This readme provides a concise overview of your project, its features, usage instructions, and technical implementation details. Adjust as needed to fit any additional specifics or updates to your project!
