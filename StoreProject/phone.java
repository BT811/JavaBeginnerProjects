package StoreProject;

public class phone extends ElectronicDevice{
    private int ramMB;
    phone(int id, Brand brand, String name, float price, int discontRate, int stock, int ramMB, int storage,float screenSize, String color){
        super(id,brand,name,price,discontRate,stock,storage,screenSize,color);
        this.ramMB = ramMB;
    }


    public int getRamMB() {
        return ramMB;
    }


    public void setRamMB(int ramMB) {
        this.ramMB = ramMB;
    }
}
