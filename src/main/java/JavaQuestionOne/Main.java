package JavaQuestionOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public void fetchCLArgValues(String[] argument, ArrayList<Item> obj, Main mainObj ) throws Exception{
        // Since user will be entering "-name Samsung Mobile -type raw -price 1000"
        String[] args = argument;
        do {
            String name = null;
            Integer quantity = null;
            Double price = null;
            String type = null;

            Map<String, String> arguments = createMap(args);

            // Fetch name
            if (fetchNameFromInput(arguments)) {
                name = arguments.get("-name");
            }

            // fetch Quantity
            if (fetchQuantityFromInput(arguments)) {
                quantity = Integer.parseInt(arguments.get("-quantity"));
            } else {
                quantity = 0;
            }

            // fetch price
            if (fetchPriceFromInput(arguments)) {
                price = Double.parseDouble(arguments.get("-price"));
            } else {
                price = 0.0;
            }

            // fetch type
            if (fetchTypeFromInput(arguments)) {
                type = arguments.get("-type");
            } else {
                throw new Exception("Item type is must");
            }

            // Create objects based on Type
            if (type.equalsIgnoreCase("raw")) {
                obj.add(new RawItem(name, quantity, price, type));
            } else if (type.equalsIgnoreCase("manufactured")) {
                obj.add(new ManufacturedItem(name, quantity, price, type));
            } else if (type.equalsIgnoreCase("imported")) {
                obj.add(new ImportedItem(name, quantity, price, type));
            } else {
                throw new Exception("Incorrect Type Passed");
            }

            // Check if user wants to continue or Stop
            if (mainObj.isUserContinuing()) {
                args = null;
                args = mainObj.askUserToContinue(obj);
            }else {
                mainObj.printDetails(obj);
                break;
            }

        }while (true);
    }

    public boolean isUserContinuing() {
        System.out.println("Enter Y to continue / N to Stop");
        String ch = sc.next();
        if (ch.equalsIgnoreCase("y")) {
            return true;
        }else {
            return false;
        }
    }

    public void printDetails(ArrayList<Item> obj) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("                        Item Inventory                       ");
        System.out.println("-------------------------------------------------------------");

        for(int index=0;index<obj.size();index++)
        {
            if (obj.get(index).getItemType().equalsIgnoreCase("raw")) {
                RawItem curObj = (RawItem) obj.get(index);
                System.out.println(curObj.getName()+"--------"+curObj.getQuantity()+"--------"+curObj.getItemType() + "--------" + curObj.calculateFinalAmount(curObj.getPrice(), curObj.getQuantity()));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            } else if (obj.get(index).getItemType().equalsIgnoreCase("manufactured")) {
                ManufacturedItem curObj = (ManufacturedItem) obj.get(index);
                System.out.println(curObj.getName()+"--------"+curObj.getQuantity()+"--------"+curObj.getItemType() + "--------" + curObj.calculateFinalAmount(curObj.getPrice(), curObj.getQuantity()));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            } else  {
                ImportedItem curObj = (ImportedItem) obj.get(index);
                System.out.println(curObj.getName()+"--------"+curObj.getQuantity()+"--------"+curObj.getItemType() + "--------" + curObj.calculateFinalAmount(curObj.getPrice(), curObj.getQuantity()));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public boolean fetchNameFromInput(Map<String, String> arguments) {
        String val = arguments.get(Constants.name);
        if (val != null ) {
            if (!val.trim().isEmpty()) {
                return true;
            }
        }
            return false;
    }

    public boolean fetchQuantityFromInput(Map<String, String> arguments) {
        String val = arguments.get(Constants.quantity);
        if (val != null ) {
            if (!val.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean fetchTypeFromInput(Map<String, String> arguments) {
        String val = arguments.get(Constants.type);
        if (val != null ) {
            if (!val.trim().isEmpty()) {
                return true;
            }
        }
        return false;

    }

    public boolean fetchPriceFromInput(Map<String, String> arguments) {
        String val = arguments.get(Constants.price);
        if (val != null ) {
            if (!val.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String> createMap(String[] args) {
       Map<String, String> arguments = new HashMap<String, String>();
        for (int counter = 0; counter < args.length - 1; counter += 2) {
            arguments.put(args[counter], args[counter + 1]);
        }
        return arguments;
    }

    public String[] askUserToContinue(ArrayList<Item> obj){
        System.out.println("Enter -name<Item Name> -price<Item Price> -quantity<Item Quantity> -type<Item type> ");
        sc.nextLine();
        String inp = sc.nextLine();
        return inp.split(" ");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        ArrayList<Item> obj = new ArrayList<Item>();
        try {
            mainObj.fetchCLArgValues(args, obj, mainObj );
        }catch(Exception e) {
            mainObj.printDetails(obj);
        }
    }
}
