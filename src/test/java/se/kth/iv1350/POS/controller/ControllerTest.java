package se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.model.Item;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testStartSale() {
        controller.startSale();
        assertNotNull(controller.getSale(), "Sale should not be null after starting.");
    }

    @Test
    public void testGetItemByID() {
        // Assuming there is an item with ID "abc123" in the inventory database
        Item item = controller.getItemByID("abc123");
        assertNotNull(item, "Item should not be null if it exists in the database.");
    }

    @Test
    public void testAddItemToSale() {
        controller.startSale();
        String itemID = "abc123"; // Using an existing item ID from the database
        int amount = 1;
        String result = controller.addItemToSale(itemID, amount);
        assertFalse(result.isEmpty(), "Result should not be empty if item is added to sale.");
    }

    @Test
    public void testAddItemToSale_ItemNotFound() {
        controller.startSale();
        String itemID = "nonexistent"; // Assume this ID does not exist in the database
        int amount = 1;
        String result = controller.addItemToSale(itemID, amount);
        assertTrue(result.isEmpty(), "Result should be empty if item is not found in the database.");
    }

    @Test
    public void testGetSale() {
        controller.startSale();
        assertNotNull(controller.getSale(), "Sale should not be null after starting.");
    }

    @Test
    public void testCompleteSale() {
        // Assuming sale is started and items are added
        controller.startSale();
        String itemID = "abc123";
        int amount = 1;
        controller.addItemToSale(itemID, amount);
        double amountPaid = 100.0;
        assertDoesNotThrow(() -> controller.completeSale(amountPaid), "Complete sale should not throw exceptions.");
    }

    @Test
    public void testEndSale() {
        // Assuming sale is started and items are added
        controller.startSale();
        String itemID = "abc123";
        int amount = 1;
        controller.addItemToSale(itemID, amount);
        double amountPaid = 100.0;
        assertDoesNotThrow(() -> controller.endSale(amountPaid), "End sale should not throw exceptions.");
    }
}
