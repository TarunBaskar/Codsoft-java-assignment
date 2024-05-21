package atmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private ATM atm;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JLabel messageLabel;

    public ATMInterface(ATM atm) {
        this.atm = atm;
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel amountLabel = new JLabel("Amount:");
        panel.add(amountLabel);

        amountField = new JTextField();
        panel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDeposit();
            }
        });
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performWithdraw();
            }
        });
        panel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        panel.add(checkBalanceButton);

        balanceLabel = new JLabel("Balance: " + atm.checkBalance());
        panel.add(balanceLabel);

        messageLabel = new JLabel("");
        panel.add(messageLabel);

        add(panel);
    }

    private void performDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            atm.deposit(amount);
            balanceLabel.setText("Balance: " + atm.checkBalance());
            messageLabel.setText("Deposit successful!");
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid amount.");
        }
    }

    private void performWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (atm.withdraw(amount)) {
                balanceLabel.setText("Balance: " + atm.checkBalance());
                messageLabel.setText("Withdrawal successful!");
            } else {
                messageLabel.setText("Insufficient balance.");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid amount.");
        }
    }

    private void checkBalance() {
        balanceLabel.setText("Balance: " + atm.checkBalance());
        messageLabel.setText("Balance checked.");
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMInterface(atm).setVisible(true);
            }
        });
    }
}

