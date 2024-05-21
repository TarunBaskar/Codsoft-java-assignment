package currencyConvertor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterconsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); 
        exchangeRates.put("EUR", 0.82);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("INR", 73.47); 
        exchangeRates.put("CHY", 7.24); 
        exchangeRates.put("JPY", 156.40); 


        System.out.println("Currency Options:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency);
        }

        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();
        while (!exchangeRates.containsKey(baseCurrency)) {
            System.out.print("Invalid currency. Please enter a valid base currency: ");
            baseCurrency = scanner.next().toUpperCase();
        }

        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        while (!exchangeRates.containsKey(targetCurrency)) {
            System.out.print("Invalid currency. Please enter a valid target currency: ");
            targetCurrency = scanner.next().toUpperCase();
        }

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);
        double convertedAmount = amount * exchangeRate;

        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }
}
