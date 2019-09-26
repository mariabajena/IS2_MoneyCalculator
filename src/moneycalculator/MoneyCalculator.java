package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MoneyCalculator {

    public static void main(String[] args) throws IOException {
        System.out.println("Introduce una cantidad de dólares: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        double exchangerate = getExchangeRate("USD","EUR");
        System.out.println(amount + " dolares equivalen a " 
              + amount*exchangerate + " euros");        
    }
    
    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("https://free.currconv.com/api/v7/convert?q=USD_EUR&compact=ultra&apiKey=7634451601e7e399bc43");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+5, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }    
    
}