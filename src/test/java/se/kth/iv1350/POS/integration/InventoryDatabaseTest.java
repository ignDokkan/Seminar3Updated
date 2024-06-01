package se.kth.iv1350.POS.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.model.Item;

public class InventoryDatabaseTest {

    @Test
    public void testGetItemByID_ItemExists() {
        InventoryDatabase inventoryDB = new InventoryDatabase();
        Item item = inventoryDB.getItemByID("abc123");
        assertNotNull(item, "Item should not be null if it exists in the database.");
        assertEquals("BigWheel Oatmeal", item.getItemName(), "Item name should match");
        assertEquals(29.90, item.getItemCost(), 0.001, "Item cost should match");
        assertEquals(0.06, item.getVatRate(), 0.001, "VAT rate should match");
        assertEquals("BigWheel Oatmeal 500 g , whole grain oats, high fiber, gluten free", item.getItemDescription(), "Item description should match");
    }

    @Test
    public void testGetItemByID_ItemNotFound() {
        InventoryDatabase inventoryDB = new InventoryDatabase();
        Item item = inventoryDB.getItemByID("nonexistent");
        assertNull(item, "Item should be null if it does not exist in the database.");
    }
}
