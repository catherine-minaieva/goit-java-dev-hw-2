package Product;

import java.util.Objects;

public class Product implements ProductId<String> {
    private final String code;
    private final double price;
    private final int saleQuantity;
    private final double salePrice;

    public Product(String code, double price, int saleQuantity, double salePrice) {
        this.code = code;
        this.price = price;
        this.saleQuantity = saleQuantity;
        this.salePrice = salePrice;
    }

    public Product(String code, double price) {
        this(code, price, 1, price);
    }

    public String getCode() {
        return code;
    }

    public double getPriceByQuantity(long quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("No products were chosen");
        }
        if (quantity < saleQuantity) {
            return quantity * price;
        }
       else {
            return (quantity / saleQuantity) * salePrice + (quantity % saleQuantity) * price;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                saleQuantity == product.saleQuantity &&
                Double.compare(product.salePrice, salePrice) == 0 &&
                code.equals(product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, price, saleQuantity, salePrice);
    }

    @Override
    public String toString() {
        return "Product" +
                "code='" + code + '\'' +
                ", price=" + price;
    }
}



