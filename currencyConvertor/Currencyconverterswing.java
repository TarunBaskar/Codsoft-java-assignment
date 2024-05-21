package currencyConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Currencyconverterswing extends JFrame {
	 private JComboBox<String> baseCurrencyComboBox;
	    private JComboBox<String> targetCurrencyComboBox;
	    private JTextField amountTextField;
	    private JLabel resultLabel;

	    private Map<String, Double> exchangeRates;

	    public Currencyconverterswing() {
	        setTitle("Currency Converter");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null); // Center the frame on the screen

	        exchangeRates = new HashMap<>();
	        exchangeRates.put("USD", 1.0);
	        exchangeRates.put("EUR", 0.82);
	        exchangeRates.put("GBP", 0.72);
	        exchangeRates.put("INR", 73.47);
	        exchangeRates.put("CHY", 7.24);
	        exchangeRates.put("JPY", 156.40);

	        initComponents();
	    }

	    private void initComponents() {
	        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
	        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	        JLabel baseCurrencyLabel = new JLabel("Base Currency:");
	        mainPanel.add(baseCurrencyLabel);

	        baseCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
	        mainPanel.add(baseCurrencyComboBox);

	        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
	        mainPanel.add(targetCurrencyLabel);

	        targetCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
	        mainPanel.add(targetCurrencyComboBox);

	        JLabel amountLabel = new JLabel("Amount:");
	        mainPanel.add(amountLabel);

	        amountTextField = new JTextField();
	        mainPanel.add(amountTextField);

	        JButton convertButton = new JButton("Convert");
	        convertButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                convertCurrency();
	            }
	        });
	        mainPanel.add(convertButton);

	        resultLabel = new JLabel();
	        mainPanel.add(resultLabel);

	        add(mainPanel);
	    }

	    private void convertCurrency() {
	        String baseCurrency = (String) baseCurrencyComboBox.getSelectedItem();
	        String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();

	        double exchangeRate = exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);

	        try {
	            double amount = Double.parseDouble(amountTextField.getText());
	            double convertedAmount = amount * exchangeRate;
	            resultLabel.setText(String.format("Converted amount: %.2f %s", convertedAmount, targetCurrency));
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Currencyconverterswing().setVisible(true);
	            }
	        });
	    }
    }

