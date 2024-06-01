package se.kth.iv1350.POS.startup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Main.
 */
public class MainTest {
    private ByteArrayOutputStream outputBuffer;
    private PrintStream originalSystemOut;
    
    private static final String SALE_STARTED_MSG = "A new sale has been started.";
    private static final String ADD_ITEM_ABC123_MSG = "Added 2 item(s) with item id abc123";
    private static final String ADD_ITEM_DEF456_MSG = "Added 1 item(s) with item id def456";
    
    @BeforeEach
    public void setUp() {
        outputBuffer = new ByteArrayOutputStream();
        PrintStream inMemorySystemOut = new PrintStream(outputBuffer);
        originalSystemOut = System.out;
        System.setOut(inMemorySystemOut);
    }
    
    @AfterEach
    public void tearDown() {
        outputBuffer = null;
        System.setOut(originalSystemOut);
    }

    @Test
    public void testMainOutput() {
        String[] args = null;
        Main.main(args);
        String output = outputBuffer.toString();
        assertTrue(output.contains(SALE_STARTED_MSG), "Sale did not start as expected.");
        assertTrue(output.contains(ADD_ITEM_ABC123_MSG), "No item with the ID abc123 exists");
        assertTrue(output.contains(ADD_ITEM_DEF456_MSG), "No item with the ID def456 exists");
    }    
}
