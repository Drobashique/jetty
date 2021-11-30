package entity;

public class ProductEntity {
    private int id;
    private String name;
    private int quantity;

    public ProductEntity() {
    }

    public ProductEntity(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ProductEntity(int id, String name,int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
}
