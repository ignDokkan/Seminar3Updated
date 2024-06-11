package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDTOTest {
    private ItemDTO item;

    @BeforeEach
    public void setUp() {
        item = new ItemDTO("123", "Test Item", 50.0, 0.25, "Test Description", 10);
    }

    @Test
    public void testGetItemID() {
        assertEquals("123", item.getItemID(), "Item ID should match the one provided in the constructor.");
    }

    @Test
    public void testGetItemName() {
        assertEquals("Test Item", item.getItemName(), "Item name should match the one provided in the constructor.");
    }

    @Test
    public void testGetItemCost() {
        assertEquals(50.0, item.getItemCost(), 0.001, "Item cost should match the one provided in the constructor.");
    }

    @Test
    public void testGetVatRate() {
        assertEquals(0.25, item.getVatRate(), 0.001, "VAT rate should match the one provided in the constructor.");
    }

    @Test
    public void testGetItemDescription() {
        assertEquals("Test Description", item.getItemDescription(), "Item description should match the one provided in the constructor.");
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, item.getQuantity(), "Item quantity should match the one provided in the constructor.");
    }
}
