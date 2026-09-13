import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountGUI extends JFrame implements ActionListener {

    private BankAccount account;

    private JPanel panel;

    private JLabel nameLabel;
    private JLabel accountLabel;
    private JLabel balanceLabel;

    private JTextField amountField;

    private JButton balanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;

    public BankAccountGUI(BankAccount account) {

        this.account = account;

        // Set up the window
        setTitle("Bank Balance Application");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the JPanel
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        // Create labels
        nameLabel = new JLabel(
                "Account Holder: " +
                        account.getFirstName() + " " +
                        account.getLastName(),
                SwingConstants.CENTER
        );

        accountLabel = new JLabel(
                "Account ID: " + account.getAccountID(),
                SwingConstants.CENTER
        );

        balanceLabel = new JLabel(
                String.format("Balance: $%.2f", account.getBalance()),
                SwingConstants.CENTER
        );

        // Create text field
        amountField = new JTextField();
        amountField.setBorder(
                BorderFactory.createTitledBorder("Enter Amount")
        );

        // Create buttons
        balanceButton = new JButton("Display Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");

        // Register buttons with ActionListener
        balanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add components to JPanel
        panel.add(nameLabel);
        panel.add(accountLabel);
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(balanceButton);

        // Create a separate button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);

        // Add panels to JFrame
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Display balance
        if (e.getSource() == balanceButton) {

            updateBalance();

        }

        // Deposit
        else if (e.getSource() == depositButton) {

            try {
                double amount = Double.parseDouble(amountField.getText());

                if (account.deposit(amount)) {
                    updateBalance();
                    amountField.setText("");

                    JOptionPane.showMessageDialog(
                            this,
                            "Deposit successful!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Please enter a positive amount."
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid number."
                );
            }
        }

        // Withdraw
        else if (e.getSource() == withdrawButton) {

            try {
                double amount = Double.parseDouble(amountField.getText());

                if (account.withdraw(amount)) {
                    updateBalance();
                    amountField.setText("");

                    JOptionPane.showMessageDialog(
                            this,
                            "Withdrawal successful!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Insufficient funds or invalid amount."
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid number."
                );
            }
        }

        // Exit
        else if (e.getSource() == exitButton) {

            JOptionPane.showMessageDialog(
                    this,
                    String.format(
                            "Remaining Balance: $%.2f",
                            account.getBalance()
                    )
            );

            System.exit(0);
        }
    }

    // Updates the balance displayed on the GUI
    private void updateBalance() {

        balanceLabel.setText(
                String.format(
                        "Balance: $%.2f",
                        account.getBalance()
                )
        );
    }
}
