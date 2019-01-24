package kolokwium2;

public class StockItem {

    private String productCode;
    private boolean active;
    private String name;
    private double price;
    private double vat;
    private String unit;
    private String category;
    private String producer;
    private double weight;
    private int stock;
    private String delivery;


    public StockItem(String productCode, boolean active, String name, double price, double vat, String unit, String category, String producer, double weight, int stock, String delivery) {
        this.productCode = productCode;
        this.active = active;
        this.name = name;
        this.price = price;
        this.vat = vat;
        this.unit = unit;
        this.category = category;
        this.producer = producer;
        this.weight = weight;
        this.stock = stock;
        this.delivery = delivery;
    }


    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getVat() {
        return vat;
    }

    public String getUnit() {
        return unit;
    }

    public String getCategory() {
        return category;
    }

    public String getProducer() {
        return producer;
    }

    public double getWeight() {
        return weight;
    }

    public int getStock() {
        return stock;
    }

    public String getDelivery() {
        return delivery;
    }
}
