package se.kth.iv1350.POS.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ItemDTO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the View class.
 */
public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        Controller contr = new Controller() {
            @Override
            public void startSale() {
                // Mock behavior for startSale
            }

            @Override
            public ItemDTO addItemToSale(String itemID, int amount) {
                // Mock behavior for addItemToSale
                if ("001".equals(itemID)) {
                    return new ItemDTO("001", "Item 1", 100.0, 0.25, "Description", amount);
                } else {
                    return null;
                }
            }


            @Override
            public void completeSale(double amountPaid) {
                // Mock behavior for completeSale
            }

            @Override
            public void endSale(double amountPaid) {
                // Mock behavior for endSale
                System.out.println("End sale: " + amountPaid);
                System.out.println("Total cost (incl VAT):");
                System.out.println("----------------------------End receipt----------------------------");
            }
        };
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testStartSale() {
        instanceToTest.startSale();
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("Sale started."), "The startSale method did not output correctly.");
    }

    @Test
    public void testAddItemWithValidID() {
        instanceToTest.startSale(); // Needed to initialize the sale in the controller
        instanceToTest.addItem("001", 1); // Assume "001" is a valid item ID
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("Added 1 item(s) with item id 001"), "Item was not added as expected.");
    }

    @Test
    public void testAddItemWithInvalidID() {
        instanceToTest.startSale(); // Needed to initialize the sale in the controller
        instanceToTest.addItem("999", 1); // Assume "999" is an invalid item ID
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("No item with the ID 999 exists"), "Invalid item ID handling is incorrect.");
    }

    @Test
    public void testEndSale() {
        double amountPaid = 100.0;
        instanceToTest.startSale(); // Needed to initialize the sale in the controller
        instanceToTest.endSale(amountPaid);
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains("End sale: 100.0"), "End sale output is incorrect.");
        assertTrue(printout.contains("Total cost (incl VAT):"), "Total cost was not displayed.");
        assertTrue(printout.contains("----------------------------End receipt----------------------------"), "Receipt was not ended correctly.");
    }
}
