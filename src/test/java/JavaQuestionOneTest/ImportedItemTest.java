package JavaQuestionOneTest;

import JavaQuestionOne.ImportedItem;
import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class ImportedItemTest extends ImportedItem {

    @Before()
    void init() {
        System.out.println("Starting to test Imported Class");
    }

    public ImportedItemTest(String name, int quantity, double price, String itemType) {
        super(name, quantity, price, itemType);
    }

    @Test
    public void testCalculateTax() {
        double testPrice = 90;
        assertEquals(14, calculateTax(testPrice), 0);
    }

    @Test
    public void testCalculateFinalAmount() {
        double testPrice = 100;
        int testQuant = 1;
        assertEquals(120.0, calculateFinalAmount(testPrice, testQuant),0);
    }
}