package dat.backend.model.entities;

public class Product {
    int productId;
    String top;
    String bottom;
    int price;
    int orderId;
    int amount;

    public Product(int productId, String top, String bottom, int price, int orderId, int amount) {
        this.productId = productId;
        this.top = top;
        this.bottom = bottom;
        this.price = price;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Product(String top, String bottom, int price, int orderId, int amount) {
        this.top = top;
        this.bottom = bottom;
        this.price = price;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Product(String top, String bottom, int price, int amount) {
        this.top = top;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", price=" + price +
                ", orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}

