package Product;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTest {

    private Product testProduct;

    @Before
    public void init() {
        testProduct = new Product("A", 1.25, 3, 3);
    }

    @Test
    public void testGetPriceByQuantity_happyPath() {
        double expected = 1.25;
        double actual = testProduct.getPriceByQuantity(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPriceByQuantity_withZeroQuantity() {
        assertThrows(RuntimeException.class, () -> testProduct.getPriceByQuantity(0),
                "Amount can't be less than 1");
    }

    @Test
    public void testGetPrice_withMinusQuantity() {
        assertThrows(RuntimeException.class, ()-> testProduct.getPriceByQuantity(-2),
                "Quantity can't be less than 1");
    }

    @Test
    public void testCompareProducts_happyPath() {
        Product similar = new Product("A", 1.25, 3, 3);
        assertEquals(similar, testProduct);
    }

    @Test
    public void testShouldCompareDifferentProduct() {
        Product testProduct2 = new Product("B", 4.25);
        assertNotEquals(testProduct2, testProduct);

        Product sameWithAnotherPrice = new Product("A", 1.5, 3, 3);
        assertNotEquals(sameWithAnotherPrice, testProduct);

        Product sameWithAnotherSaleQuantity = new Product("A", 1.25, 4, 3);
        assertNotEquals(sameWithAnotherSaleQuantity, testProduct);

        Product sameWithAnotherSalePrice = new Product("A", 1.25, 3, 4);
        assertNotEquals(sameWithAnotherSalePrice, testProduct);
    }

    @Test
    public void testCompareHashCode_happyPath() {
        Product linkToTestProduct = testProduct;
        assertEquals(linkToTestProduct.hashCode(), testProduct.hashCode());

        Product sameToTestProduct = new Product("A", 1.25, 3, 3);
        assertEquals(sameToTestProduct.hashCode(), testProduct.hashCode());
    }

    @Test
    public void testCompareHashCode_DifferentProduct() {
        Product sameWithAnotherPrice = new Product("A", 1.24, 3, 3);
        assertNotEquals(sameWithAnotherPrice.hashCode(), testProduct.hashCode());
    }
}