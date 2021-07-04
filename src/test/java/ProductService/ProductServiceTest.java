package ProductService;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductService testProductService;

    @Before
    public void init() {
        testProductService = new ProductService();
            }

    @Test
    public void testShouldCalculateTotalCost_happyPath() {
        String bucket = "ABCDABA";
        double expected = 13.25;
        double actual = testProductService.calculateTotalCost(bucket);
        assertEquals(expected, actual);

        String bucketWithLowerCaseLetters = "abdCAb";
        double expectedWithLowerCaseLetters = 12.75;
        double actualWithLowerCaseLetters = testProductService.calculateTotalCost(bucketWithLowerCaseLetters);
        assertEquals(expectedWithLowerCaseLetters, actualWithLowerCaseLetters);
    }

    @Test
    public void testShouldCalculateTotalCost_withEmptyBucket() {
        double expectedWithNull = 0;
        double actualWithNull = testProductService.calculateTotalCost(null);
        assertEquals(expectedWithNull, actualWithNull);
    }

            @Test
        public void testShouldCalculateTotalCost_withUnknownProducts() {
            String bucketWithUnknownCodes = "fknnf";
            double expectedWithUnknownCodes = 0;
            double actualWithUnknownCodes = testProductService.calculateTotalCost(bucketWithUnknownCodes);
            assertEquals(expectedWithUnknownCodes, actualWithUnknownCodes);

            String bucketWithSpace = " ABC DA BA";
            double expectedWithSpace = 13.25;
            double actualWithSpace = testProductService.calculateTotalCost(bucketWithSpace);
            assertEquals(expectedWithSpace, actualWithSpace);

            String bucketWithNumbers = "ABC58DABA25";
            double expectedWithNumbers = 13.25;
            double actualWithNumbers = testProductService.calculateTotalCost(bucketWithNumbers);
            assertEquals(expectedWithNumbers, actualWithNumbers);

            String bucketWithCorrectAndUnknown = "ABCDABAGHN";
            double expectedWithCorrectAndUnknown = 13.25;
            double actualWithCorrectAndUnknown = testProductService.calculateTotalCost(bucketWithCorrectAndUnknown);
            assertEquals(expectedWithCorrectAndUnknown, actualWithCorrectAndUnknown);
    }
}