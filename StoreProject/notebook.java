package StoreProject;

public class notebook extends ElectronicDevice {
    private int ramSSD;


    notebook(int id, Brand brand, String name, float price, int discontRate, int stock, int ramSSD, int storage, float screenSize,String color){
        super(id, brand, name, price, discontRate, stock,storage, screenSize, color);
        this.ramSSD =ramSSD;
    }

    public int getRamSSD() {
        return ramSSD;
    }

    public void setRamSSD(int ramSSD) {
        this.ramSSD = ramSSD;
    }
}
