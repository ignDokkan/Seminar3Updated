package se.kth.iv1350.POS.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.ItemDTO;

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
    public void testGetItemDTOByID_ItemExists() {
        String itemID = "abc123"; // Assuming there is an item with ID "abc123" in the inventory database
        ItemDTO itemDTO = controller.getItemDTOByID(itemID);
        assertNotNull(itemDTO, "ItemDTO should not be null if item exists in the database.");
    }

    @Test
    public void testGetItemDTOByID_ItemNotFound() {
        String itemID = "nonexistent"; // Assume this ID does not exist in the database
        ItemDTO itemDTO = controller.getItemDTOByID(itemID);
        assertNull(itemDTO, "ItemDTO should be null if item is not found in the database.");
    }

    @Test
    public void testAddItemToSale_ItemFound() {
        controller.startSale();
        String itemID = "abc123"; // Using an existing item ID from the database
        int amount = 1;
        ItemDTO itemDTO = controller.addItemToSale(itemID, amount);
        assertNotNull(itemDTO, "ItemDTO should not be null if item is added to sale.");
    }

    @Test
    public void testAddItemToSale_ItemNotFound() {
        controller.startSale();
        String itemID = "nonexistent"; // Assume this ID does not exist in the database
        int amount = 1;
        ItemDTO itemDTO = controller.addItemToSale(itemID, amount);
        assertNull(itemDTO, "ItemDTO should be null if item is not found in the database.");
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
