package StoreProject;



public class Brand implements Comparable<Brand> {
    private  int id;
    private String brand;
    private ElectronicDevice device;

    Brand(int id,String brand){
        this.id = id;
        this.brand = brand;
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ElectronicDevice getDevice() {
        return device;
    }

    public void setDevice(ElectronicDevice device) {
        this.device = device;
    }
    @Override
    public int compareTo(Brand other) {
        return this.brand.compareTo(other.brand);
    }
}
