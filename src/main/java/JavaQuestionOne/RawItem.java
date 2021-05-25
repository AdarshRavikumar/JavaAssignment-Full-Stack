package JavaQuestionOne;

public class RawItem extends Item implements Tax_FinalAmount{

    public RawItem(String name, Integer quantity, double price, String itemType) {
        super(name,quantity,price,itemType);
    }

    public double calculateFinalAmount(double price, int quantity) {
        double salesTax = calculateTax(price);
        return (salesTax + price)*quantity;
    }

    public double calculateTax(double price) {
        return (Constants.rawItemTax * price)/100;
    }
}
