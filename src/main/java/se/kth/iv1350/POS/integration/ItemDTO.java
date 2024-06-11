package se.kth.iv1350.POS.integration;

/**
 * Data transfer object for an item.
 */
public class ItemDTO {
    private final String itemID;
    private final String itemName;
    private final double itemCost;
    private final double vatRate;
    private final String itemDescription;
    private final int quantity;

    /**
     * Creates a new instance representing a specific item.
     *
     * @param itemID The ID of the item.
     * @param itemName The name of the item.
     * @param itemCost The cost of the item.
     * @param vatRate The VAT rate for the item.
     * @param itemDescription A description of the item.
     * @param quantity The quantity of the item in stock.
     */
    public ItemDTO(String itemID, String itemName, double itemCost, double vatRate, String itemDescription, int quantity) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.vatRate = vatRate;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
    }

    /**
     * @return The ID of the item.
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return The cost of the item.
     */
    public double getItemCost() {
        return itemCost;
    }

    /**
     * @return The VAT rate of the item.
     */
    public double getVatRate() {
        return vatRate;
    }

    /**
     * @return A description of the item.
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @return The quantity of the item in stock.
     */
    public int getQuantity() {
        return quantity;
    }
}
