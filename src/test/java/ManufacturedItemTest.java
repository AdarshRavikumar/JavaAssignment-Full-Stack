

import JavaQuestionOne.ManufacturedItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManufacturedItemTest extends ManufacturedItem {

    @Before()
    void init() {
        System.out.println("Starting to test Manufactured");
    }
    public ManufacturedItemTest(String name, Integer quantity, double price, String itemType) {
        super(name, quantity, price, itemType);
    }

    @Test
    public void testCalculateTax() {
        double testPrice = 90;
        assertEquals(13.275, calculateTax(testPrice), 0);
    }

    @Test
    public void testCalculateFinalAmount() {
        double testPrice = 100;
        int testQuant = 1;
        assertEquals(114.75, calculateFinalAmount(testPrice, testQuant),0);
    }
}