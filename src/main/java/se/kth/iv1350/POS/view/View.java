package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * The View class represents the view in the POS system.
 * It handles user interactions and displays information.
 */
public class View {
    private Controller contr;

    /**
     * Constructs a View object with the specified controller.
     *
     * @param contr The controller to be associated with the view.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Starts a new sale.
     */
    public void startSale() {
        contr.startSale();
        System.out.println("Sale started.");
    }

    /**
     * Adds an item to the current sale.
     *
     * @param itemID The ID of the item to be added.
     * @param amount The quantity of the item to be added.
     */
    public void addItem(String itemID, int amount) {
        ItemDTO itemDTO = contr.addItemToSale(itemID, amount);
        if (itemDTO != null) {
            String itemDetails = formatItemDetails(itemDTO, amount);
            System.out.println(itemDetails);
        } else {
            System.out.println("No item with the ID " + itemID + " exists");
        }
    }

    /**
     * Completes the sale by processing the payment.
     *
     * @param amountPaid The amount paid by the customer.
     */
    public void completeSale(double amountPaid) {
        contr.completeSale(amountPaid);
        System.out.println("Sale completed. Amount paid: " + amountPaid + " SEK.");
    }

    /**
     * Ends the current sale and prints the receipt.
     * 
     * @param amountPaid The amount paid by the customer.
     */
    public void endSale(double amountPaid) {
        contr.endSale(amountPaid);
    }

    /**
     * Formats the details of the added item for display.
     *
     * @param itemDTO The data transfer object containing item information.
     * @param amount The quantity of the item added.
     * @return A formatted string containing the item details.
     */
    private String formatItemDetails(ItemDTO itemDTO, int amount) {
        return "Added " + amount + " item(s) with item id " + itemDTO.getItemID() + ":\n" +
               "Item Name: " + itemDTO.getItemName() + "\n" +
               "Item Cost: " + itemDTO.getItemCost() + " SEK\n" +
               "VAT: " + (itemDTO.getVatRate() * 100) + "%\n" +
               "Item Description: " + itemDTO.getItemDescription() + "\n";
    }
}
