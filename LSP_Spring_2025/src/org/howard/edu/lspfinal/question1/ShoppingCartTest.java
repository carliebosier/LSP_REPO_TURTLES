package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        cart.addItem("Book", 15.99);
        assertEquals(15.99, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect no exception)")
    public void testAddItemZeroPrice() {
        assertDoesNotThrow(() -> cart.addItem("Free Sticker", 0.0));
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Invalid Item", -5.0));
    }

    @Test
    @DisplayName("Test for applying 'SAVE10'")
    public void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE20'")
    public void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        cart.addItem("Notebook", 10.0);
        cart.addItem("Pen", 2.0);
        assertEquals(12.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        cart.addItem("Shirt", 20.0);
        cart.addItem("Hat", 10.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(27.0, cart.getTotalCost(), 0.01); // 30 - 10%
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test removing existing item")
    public void testRemoveExistingItem() {
        cart.addItem("Book", 10.0);
        cart.addItem("Pen", 2.0);
        boolean removed = cart.removeItem("Pen");
        assertTrue(removed);
        assertEquals(10.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test removing non-existent item")
    public void testRemoveNonExistentItem() {
        cart.addItem("Book", 10.0);
        boolean removed = cart.removeItem("NotExist");
        assertFalse(removed);
        assertEquals(10.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    public void testCartSizeUpdate() {
        assertEquals(0, cart.getCartSize());
        cart.addItem("Item1", 5.0);
        cart.addItem("Item2", 15.0);
        assertEquals(2, cart.getCartSize());
        cart.removeItem("Item1");
        assertEquals(1, cart.getCartSize());
    }
}

