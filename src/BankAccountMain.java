import javax.swing.JOptionPane;

public class BankAccountMain {

    public static void main(String[] args) {

        // Get first name
        String firstName = JOptionPane.showInputDialog(
                null,
                "Enter your first name:"
        );

        // Get last name
        String lastName = JOptionPane.showInputDialog(
                null,
                "Enter your last name:"
        );

        // Get account ID
        String accountIDInput = JOptionPane.showInputDialog(
                null,
                "Enter your account ID:"
        );

        try {

            int accountID = Integer.parseInt(accountIDInput);

            // Create BankAccount
            BankAccount account =
                    new BankAccount(firstName, lastName, accountID);

            // Start GUI
            new BankAccountGUI(account);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid account ID."
            );
        }
    }
}