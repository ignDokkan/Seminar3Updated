package se.kth.iv1350.POS.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Test class for the Receipt model.
 */
public class ReceiptTest {
    private Sale sale;
    private Receipt receipt;
    private Item item1;
    private Item item2;
    private final double amountPaid = 100.0;
    private final double change = 10.0;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        item1 = new Item("001", "Apple", 10.0, 0.25, "Fresh apple");
        item2 = new Item("002", "Banana", 20.0, 0.25, "Fresh banana");
        sale.addItem(item1);
        sale.addItem(item2);
        receipt = new Receipt(sale, amountPaid, change);
    }

    @Test
    void testReceiptToString() {
        String actualReceipt = receipt.toString();
        String expectedReceipt = "\n" +
                "Items Purchased:\n" +
                "Apple\t\t\t1 x 10.0 SEK\t 12.5 SEK\n" +
                "Banana\t\t\t1 x 20.0 SEK\t 25.0 SEK\n" +
                "Total: \t\t\t\t\t\t\t 37.5 SEK\n" +
                "VAT: \t\t\t\t\t    7.5 SEK\n" +
                "\nCash: \t\t\t\t\t\t\t100.0 SEK\n" +
                "Change: \t\t\t\t   10.0 SEK\n";

        // Remove timestamp from actual receipt
        actualReceipt = actualReceipt.replaceFirst("Time of Sale: \\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}\n", "");

        // Remove whitespace characters to normalize strings
        actualReceipt = actualReceipt.replaceAll("\\s", "");
        expectedReceipt = expectedReceipt.replaceAll("\\s", "");

        assertEquals(expectedReceipt, actualReceipt, "Receipt string is not formatted correctly.");
    }

}
