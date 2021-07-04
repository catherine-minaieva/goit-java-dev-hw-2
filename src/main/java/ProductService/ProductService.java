package ProductService;

import Product.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final Map<String, Product> products = new HashMap<>();

    {
        products.put("A", new Product("A", 1.25, 3, 3));
        products.put("B", new Product("B", 4.25));
        products.put("C", new Product("C", 1.00, 6, 5));
        products.put("D", new Product("D", 0.75));
    }

    private String filteredBucket(String bucket) {
        if (isCorrectBucket(bucket)) {
            return Arrays.stream(bucket.toUpperCase()
                    .split(""))
                    .filter(products::containsKey)
                    .collect(Collectors.joining());
        }
        return bucket;
    }

    public double calculateTotalCost(String bucket) {
        String customerBucket = filteredBucket(bucket);
        if (isCorrectBucket(customerBucket)) {
            Map<String, Long> productsQuantity = Arrays.stream(customerBucket.split(""))
                    .map(products::get)
                    .collect(Collectors.groupingBy(Product::getCode,
                            Collectors.mapping(Product::getCode, Collectors.counting())));
            return productsQuantity.entrySet().stream()
                    .mapToDouble(p -> products.get(p.getKey()).getPriceByQuantity(p.getValue()))
                    .sum();
        } else {
            return 0;
        }
    }

    private boolean isCorrectBucket(String bucket) {
        return bucket != null && !bucket.isEmpty();
                //&& (products.containsKey(bucket));
    }
}
