package pl.edu.wszib.shop.models;

public class Product {

    private int id;
    private String producer;
    private String category;
    private int amount;

    public Product(int id, String producer, String category, int amount) {
        this.id = id;
        this.producer = producer;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
