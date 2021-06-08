package JavaQuestionOne;

public class ManufacturedItem extends Item implements taxFinalAmount {

    public ManufacturedItem(String name, Integer quantity, double price, String itemType) {
        super(name,quantity,price,itemType);
    }

    public double calculateTax(double price) {
        return (Constants.manufacturedItemTax* price) + Constants.twoPercent*(price + Constants.manufacturedItemTax * price);
    }
    public double calculateFinalAmount(double price, int quantity) {
        double salesTax = calculateTax(price);
        return (salesTax + price)*quantity;
    }
}
