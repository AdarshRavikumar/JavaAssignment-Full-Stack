package JavaQuestionOneTest;

import JavaQuestionOne.RawItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RawItemTest extends RawItem {

    public RawItemTest(String name, Integer quantity, double price, String itemType) {
        super(name, quantity, price, itemType);
    }

    @Before()
    void init() {
        System.out.println("Starting to test Raw");
    }

    @Test
    public void testCalculateFinalAmount() {
        double testPrice = 100;
        int testQuant = 1;
        assertEquals(112.5, calculateFinalAmount(testPrice, testQuant),0);
    }

    @Test
    public void testCalculateTax() {
        double testPrice = 90;
        assertEquals(11.25, calculateTax(testPrice), 0);
    }
}