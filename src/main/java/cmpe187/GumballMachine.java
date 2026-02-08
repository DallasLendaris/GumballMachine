package cmpe187;

import java.util.Scanner;
public class GumballMachine {
    private final double ygb = 0.05;
    private final double rgb = 0.1;
    private final double quarter = 0.25;
    private final double dime = 0.1;
    private final double nickel = 0.05;
    private double balance = 0;

    GumballMachine(){
        this.balance = 0;
    }
    double getBalance(){
        return balance;
    }

    // Based on inserted coin, updates the balance
    void insertCoin(String coin){
        switch (coin.toLowerCase()) {
            case "quarter" -> balance += quarter;
            case "dime" -> balance += dime;
            case "nickel" -> balance += nickel;
            default -> System.out.println("Invalid Coin");
        }
        
    }
    // Dispenses a Yellow or Red Gumball
    public boolean dispenseGumball(String gumball){
        if(gumball.toLowerCase().equals("yellow") && balance >= ygb){
            System.out.println("Dispensed 1 Yellow Gumball, Enjoy!");
            balance -= ygb;
            return true;
        }
        else if(gumball.toLowerCase().equals("red") && balance >= rgb){
            System.out.println("Dispensed 1 Red Gumball, Enjoy!");
            balance -= rgb;
            return true;
        }
        else{
            System.out.print("Not enough funds for gumball :(");
        }
        return false;
        
    }

    // Provides the UI with the current balance
    String currbalance(){
        return String.format("Current balance: $%.2f", balance);
    }

    // Returns the remaining change
    void returnChange(){
        int q = 0, d = 0, n = 0;
        balance = Math.round(balance * 100.0) / 100.0; // round to nearest cent
        while(balance >= 0.25 - 1e-6){
            q++;
            balance -= 0.25;
            balance = Math.round(balance * 100.0) / 100.0;
        }
        while(balance >= 0.10 - 1e-6){
            d++;
            balance -= 0.10;
            balance = Math.round(balance * 100.0) / 100.0;
        }
        while(balance >= 0.05 - 1e-6){
            n++;
            balance -= 0.05;
            balance = Math.round(balance * 100.0) / 100.0;
        }
        System.out.print("Change returned: ");
        if(q > 1){
            System.out.print(q + " Quarters, ");
        }
        else{
            System.out.print(q + " Quarter, ");
        }
        if(d > 1){
            System.out.print(d + " Dimes, ");
        }
        else{
            System.out.print(d + " Dime, ");
        }
        if(n > 1){
            System.out.println(n + " Nickels.");
        }
        else{
            System.out.println(n + " Nickel.");
        }
    }

    private static void printHelp(){
        System.out.println("\nCommands:");
        System.out.println("  insert <nickel|dime|quarter|anything>  - insert a coin (invalid stored until dispense)");
        System.out.println("  red                                    - press RED lever (5c)");
        System.out.println("  yellow                                 - press YELLOW lever (10c)");
        System.out.println("  balance                                - show current balance");
        System.out.println("  change                                 - return all remaining change");
        System.out.println("  help                                   - show commands");
        System.out.println("  quit                                   - exit\n");
        System.out.println("Examples:");
        System.out.println("  insert quarter");
        System.out.println("  red");
        System.out.println("  red");
        System.out.println("  change\n");
    }


    public static void main(String[] args) {
        GumballMachine gm = new GumballMachine();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Gumball Vending Machine ===");
            System.out.println("Red: $0.10 | Yellow: $0.05 | Accepts: nickel, dime, quarter");
            System.out.println("Invalid coins are returned when you press a dispense lever.");
            printHelp();
            while (true) {
                System.out.print("> ");
                if(!sc.hasNextLine()) break;
                
                String line = sc.nextLine().trim();
                if(line.isEmpty()) continue;
                
                String[] parts = line.split("\\s+");
                String cmd = parts[0].toLowerCase();
                
                switch (cmd){
                    case "help" -> printHelp();
                    
                    case "balance" -> System.out.println(gm.currbalance());
                    
                    case "insert" -> {
                        if(parts.length < 2){
                            System.out.println("Usage: insert <coin>");
                            break;
                        }
                        String coin = parts[1];
                        gm.insertCoin(coin);
                        System.out.println(gm.currbalance());
                    }
                    
                    case "red" ->  {
                        gm.dispenseGumball("red");
                        System.out.println(gm.currbalance());
                    }
                    
                    case "yellow" -> {
                        gm.dispenseGumball("yellow");
                        System.out.println(gm.currbalance());
                    }
                    
                    case "change" -> {
                        gm.returnChange();
                        System.out.println(gm.currbalance());
                    }
                    
                    case "quit", "exit" -> {
                        System.out.println("Goodbye");
                        sc.close();
                        return;
                    }
                    
                    
                    default -> {
                        System.out.println("Unknown command: " + cmd);
                        System.out.println("Type 'help' to see valid commands.");
                        
                    }
                }
            }
        }
    }

}

