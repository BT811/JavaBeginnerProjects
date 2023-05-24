package StoreProject;

public class ElectronicDevice implements Comparable<ElectronicDevice> {
    private int id;
    private  Brand brand;
    private String name;
    private float price;
    private int discontRate;
    private int stock;
    private int storage;
    private float screenSize;
    private String color;

    public ElectronicDevice(int id, Brand brand, String name, float price, int discontRate, int stock, int storage, float screenSize, String color) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.discontRate = discontRate;
        this.stock = stock;
        this.storage = storage;
        this.screenSize = screenSize;
        this.color = color;
    }
    @Override
    public int compareTo(ElectronicDevice other) {
        return this.name.compareTo(other.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscontRate() {
        return discontRate;
    }

    public void setDiscontRate(int discontRate) {
        this.discontRate = discontRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
