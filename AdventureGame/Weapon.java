public class Weapon {
    private String  name;
    private int id;
    private int damage;
    private int price;

    Weapon(String name, int id, int damage, int price){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponlist = new Weapon[4];
        weaponlist[0] =new Weapon("Wooden Sword",1,3,5);
        weaponlist[1] =new Weapon("Dragon Sword",2,5,25);
        weaponlist[2] =new Weapon("Slime Sword",3,1,10);
        weaponlist[3] =new Weapon("Diamond Sword",4,7,40);
        return weaponlist;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
