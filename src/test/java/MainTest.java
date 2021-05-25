

import JavaQuestionOne.Main;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest extends Main {

    @Before()
    void init() {
        System.out.println("Starting to test Main");
    }
    @Test
    public void testFetchNameFromInput() {
        System.out.println("Enter Input");
        String[] args = "-name iPhone -type imported -quantity 1 -price 60000".split(" ");
        HashMap<String, String> map =  createMap(args);
        assertTrue(fetchNameFromInput(map));

        args = "-type imported -quantity 1 -price 60000".split(" ");
        map =  createMap(args);
        assertFalse(fetchNameFromInput(map));

    }

    @Test
    public void testFetchQuantityFromInput() {
        String[] args = "-name iPhone -type manufactured -quantity 1 -price 60000".split(" ");
        HashMap<String, String> map =  createMap(args);
        assertTrue(fetchQuantityFromInput(map));

        args = "-name iPhone -type manufactured -price 60000".split(" ");
        map =  createMap(args);
        assertFalse(fetchQuantityFromInput(map));
    }

    @Test(expected= Exception.class)
    public void testFetchTypeFromInput() {
        System.out.println("Enter Input");
        String[] args = "-name iPhone -type raw -quantity 1 -price 60000".split(" ");
        HashMap<String, String> map =  createMap(args);
        assertTrue(fetchTypeFromInput(map));

        args = "-name iPhone -quantity 1 -price 60000".split(" ");
        map =  createMap(args);
        assertFalse(fetchQuantityFromInput(map));
    }

    @Test
    public void testFetchPriceFromInput() {
        System.out.println("Enter Input");
        String[] args = "-name iPhone -type raw -quantity 1 -price 60000".split(" ");
        HashMap<String, String> map =  createMap(args);
        assertTrue(fetchPriceFromInput(map));

        args = "-name iPhone -type raw -quantity 1".split(" ");
        map =  createMap(args);
        assertFalse(fetchQuantityFromInput(map));
    }
}