package JavaQuestionOne;

public class ImportedItem extends Item implements Tax_FinalAmount{

    public ImportedItem(String name, int quantity, double price, String itemType) {
        super(name,quantity,price,itemType);
    }

    public double calculateTax(double price) {
        double importDuty = Constants.rawItemTax * price;
        double surcharge =0.0;
        if(price+importDuty <= 100)
            surcharge = 5.0;
        else if (price+importDuty >100 && price+importDuty <=200)
            surcharge = 10.0;
        else
            surcharge= (Constants.importedTax*(importDuty+price));

        return importDuty + surcharge;
    }

    public double calculateFinalAmount(double price, int quantity) {
        double salesTax = calculateTax(price);
        return (salesTax + price)*quantity;
    }
}
