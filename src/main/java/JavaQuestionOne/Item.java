package JavaQuestionOne;

public class Item {
    public String name;
    public Integer quantity;
    public double price;
    public String itemType;

    public Item(String name, Integer quantity, double price, String itemType) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.itemType = itemType;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }
}
