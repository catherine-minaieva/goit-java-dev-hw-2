import ProductService.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService inShop = new ProductService();
        double yourBucket = inShop.calculateTotalCost("ABCDABA");
        System.out.println(yourBucket);
        }
    }

