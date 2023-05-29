public class Armor {
    private String  name;
    private int id;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armorlist = new Armor[4];
        armorlist[0] =new Armor("Leather Armor",1,3,2);
        armorlist[1] =new Armor("Dragon Armor",2,10,30);
        armorlist[2] =new Armor("Steel Armor",3,8,25);
        armorlist[3] =new Armor("Chain Armor",4,5,20);
        return armorlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
